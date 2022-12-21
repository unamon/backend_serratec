		package org.serratec.apicontroleequipamento.service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.apicontroleequipamento.dto.PessoaInserirDTO;
import org.serratec.apicontroleequipamento.dto.PessoaRespostaDTO;
import org.serratec.apicontroleequipamento.enums.TipoPessoaENUM;
import org.serratec.apicontroleequipamento.exception.ResourceNotFoundException;
import org.serratec.apicontroleequipamento.model.Endereco;
import org.serratec.apicontroleequipamento.model.Perfil;
import org.serratec.apicontroleequipamento.model.Pessoa;
import org.serratec.apicontroleequipamento.model.PessoaJuridica;
import org.serratec.apicontroleequipamento.repository.EnderecoRepository;
import org.serratec.apicontroleequipamento.repository.PerfilRepository;
import org.serratec.apicontroleequipamento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class PessoaService {
	@Autowired
	FotoService fotoService;

	@Autowired
	PessoaRepository pessoaRepo;

	@Autowired
	EnderecoRepository endRepo;

	@Autowired
	PerfilRepository perfilRepo;

	@Autowired
	BCryptPasswordEncoder encoder;

	public List<PessoaRespostaDTO> getPessoas() {
		List<PessoaRespostaDTO> pessoasDTO = pessoaRepo.findAll().stream().map(p -> adicionarImagemURI(p))
				.collect(Collectors.toList());
		return pessoasDTO;

	}

	public PessoaRespostaDTO getPessoaById(Long id) {
		Optional<Pessoa> pessoaDB = pessoaRepo.findById(id);
		if (pessoaDB.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar a pessoa com id " + id);
		}
		return adicionarImagemURI(pessoaDB.get());

	}

public PessoaRespostaDTO register(PessoaInserirDTO novaPessoaDTO, MultipartFile file) throws IOException {
		if(pessoaRepo.findByEmail(novaPessoaDTO.getEmail()).isPresent()) {
			throw new ResourceNotFoundException("Email já existe");
			//ERRO PLACEHOLDER!!!!!!!!
		}
		Endereco novoEndereco = endRepo.save(novaPessoaDTO.getEndereco());
		Long idPerfil = novaPessoaDTO.getIdPerfil();
		Optional<Perfil> PerfilDB = perfilRepo.findById(idPerfil);

		if (PerfilDB.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o perfil com id " + idPerfil);
		}

		if (novaPessoaDTO.getTipoPessoa() == TipoPessoaENUM.F) {
			Pessoa novaPessoaDB = new Pessoa(novaPessoaDTO, novoEndereco, PerfilDB.get());

			novaPessoaDB.setSenha(encoder.encode(novaPessoaDTO.getSenha()));
			pessoaRepo.save(novaPessoaDB);
			fotoService.inserir(novaPessoaDB, file);
			return adicionarImagemURI(novaPessoaDB);

		} else if (novaPessoaDTO.getTipoPessoa() == TipoPessoaENUM.J) {
			PessoaJuridica novaPessoaJDB = new PessoaJuridica(novaPessoaDTO, novoEndereco, PerfilDB.get());
      novaPessoaJDB.setSenha(encoder.encode(novaPessoaDTO.getSenha()));
			pessoaRepo.save(novaPessoaJDB);
			fotoService.inserir(novaPessoaJDB, file);
			return adicionarImagemURI(novaPessoaJDB);
			

		} else {
			throw new ResourceNotFoundException("TIPO NÃO VÁLIDO");
		}

	}

	public PessoaRespostaDTO update(PessoaInserirDTO pessoaUpdate, MultipartFile file) throws IOException {
		Endereco novoEndereco = endRepo.save(pessoaUpdate.getEndereco());
		Long idPerfil = pessoaUpdate.getIdPerfil();
		Optional<Perfil> PerfilDB = perfilRepo.findById(idPerfil);

		if (PerfilDB.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o perfil com id " + idPerfil);
		}

		if (pessoaUpdate.getTipoPessoa() == TipoPessoaENUM.F) {
			Pessoa novaPessoaDB = new Pessoa(pessoaUpdate, novoEndereco, PerfilDB.get());

			novaPessoaDB.setSenha(encoder.encode(pessoaUpdate.getSenha()));
			pessoaRepo.save(novaPessoaDB);
			fotoService.inserir(novaPessoaDB, file);
			return adicionarImagemURI(novaPessoaDB);

		} else if (pessoaUpdate.getTipoPessoa() == TipoPessoaENUM.J) {
			PessoaJuridica novaPessoaJDB = new PessoaJuridica(pessoaUpdate, novoEndereco, PerfilDB.get());
      novaPessoaJDB.setSenha(encoder.encode(pessoaUpdate.getSenha()));
			pessoaRepo.save(novaPessoaJDB);
			fotoService.inserir(novaPessoaJDB, file);
			return adicionarImagemURI(novaPessoaJDB);
			
		} else {
			throw new ResourceNotFoundException("TIPO NÃO VÁLIDO");
		}

	}
	
	
	public PessoaRespostaDTO adicionarImagemURI(Pessoa pessoa) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/pessoas/{id}/foto")
				.buildAndExpand(pessoa.getId())
				.toUri();
		PessoaRespostaDTO dto = new PessoaRespostaDTO(pessoa, uri.toString());
		return dto;
	}
}
