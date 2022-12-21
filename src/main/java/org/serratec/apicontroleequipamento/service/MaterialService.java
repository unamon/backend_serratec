package org.serratec.apicontroleequipamento.service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.serratec.apicontroleequipamento.dto.MaterialInserirDTO;
import org.serratec.apicontroleequipamento.dto.MaterialRespostaDTO;
import org.serratec.apicontroleequipamento.exception.ResourceNotFoundException;
import org.serratec.apicontroleequipamento.model.Categoria;
import org.serratec.apicontroleequipamento.model.Historico;
import org.serratec.apicontroleequipamento.model.Material;
import org.serratec.apicontroleequipamento.model.Origem;
import org.serratec.apicontroleequipamento.model.Pessoa;
import org.serratec.apicontroleequipamento.model.Status;
import org.serratec.apicontroleequipamento.repository.CategoriaRepository;
import org.serratec.apicontroleequipamento.repository.HistoricoRepository;
import org.serratec.apicontroleequipamento.repository.MaterialRepository;
import org.serratec.apicontroleequipamento.repository.PessoaRepository;
import org.serratec.apicontroleequipamento.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class MaterialService {

	@Autowired
	MaterialRepository materialRepo;

	@Autowired
	CategoriaRepository catRepo;

	@Autowired
	PessoaRepository pessoaRepo;

	@Autowired
	StatusRepository statusRepo;

	@Autowired
	HistoricoRepository histRepo;

	@Autowired
	NotaFiscalService notaService;
	
	public List<Material> getAll() {
		List<Material> materiais = materialRepo.findAll();
		return materiais;
	}

	public Page<Material> getByPage(Pageable pageable) {
		return materialRepo.findAll(pageable);
	}

	public MaterialRespostaDTO getById(Long id) {
		Optional<Material> optPatrimonio = materialRepo.findById(id);
		if (optPatrimonio.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar a categoria com id " + id);
		}
		return adicionarNotaFiscalURI(optPatrimonio.get());
	}

	public MaterialRespostaDTO register(MaterialInserirDTO novoMaterial, MultipartFile file) throws IOException {

		Long idCategoria = novoMaterial.getIdCategoriaMaterial();
		Long idPessoa = novoMaterial.getOrigem().getIdPessoaOrigem();

		Optional<Categoria> categoriaDB = catRepo.findById(idCategoria);
		Optional<Pessoa> pessoaOrigemDB = pessoaRepo.findById(idPessoa);
		Optional<Status> statusDB = statusRepo.findById((long) 1);

		if (categoriaDB.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar a categoria com id " + idCategoria);
		}
		if (pessoaOrigemDB.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar a pessoa com id " + idPessoa);
		}

		Origem origemDB = new Origem(novoMaterial.getOrigem(), pessoaOrigemDB.get());
		Material materialDB = new Material(novoMaterial, categoriaDB.get(), origemDB);
		Historico historico = new Historico(materialDB, statusDB.get(),pessoaOrigemDB.get(), "MATERIAL ADICIONADO");
		
		notaService.inserir(materialDB, file);
		histRepo.save(historico);
		Material m = materialRepo.save(materialDB);
		
		return adicionarNotaFiscalURI(m);

	}

	public Material update(Long id, MaterialInserirDTO material) {
		Long idCategoria = material.getIdCategoriaMaterial();
		Long idPessoa = (long) 1;

		Optional<Material> materialDB = materialRepo.findById(id);
		Optional<Categoria> categoriaDB = catRepo.findById(idCategoria);
		Optional<Pessoa> pessoaOrigemDB = pessoaRepo.findById(idPessoa);
		Origem origem = new Origem();
		
		if (materialDB.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o material com id " + id);
		}
		if (categoriaDB.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar a categoria com id " + idCategoria);
		}
		if (pessoaOrigemDB.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar a pessoa com id " + idPessoa);
		} else {
			origem = new Origem(material.getOrigem(), pessoaOrigemDB.get());
		}
		
		Material novoMaterialDB = new Material(material, categoriaDB.get(), origem);
		novoMaterialDB.setId(id);

		Historico histAtual = histRepo.getMaisRecente(id);

		Historico historico = new Historico(novoMaterialDB, histAtual.getStatus(), histAtual.getPessoa(),
				"MATERIAL ATUALIZADO");
		histRepo.save(historico);

		return materialRepo.save(novoMaterialDB);
	}

	public void delete(Long id) {
		Optional<Material> materialDB = materialRepo.findById(id);
		if (materialDB.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o material com id " + id);
		}
		materialRepo.deleteById(id);
	}

	public MaterialRespostaDTO adicionarNotaFiscalURI(Material material) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/materiais/{id}/notaFiscal")
				.buildAndExpand(material.getId())
				.toUri();
		MaterialRespostaDTO dto = new MaterialRespostaDTO();
		dto.setDescricao(material.getDescricao());
		dto.setId(material.getId());
		dto.setNome(material.getNome());
		dto.setCategoria(material.getCategoria());
		dto.setOrigem(material.getOrigem());
		dto.setUrlNotaFiscal(uri.toString());
		return dto;
	}
}
