package org.serratec.apicontroleequipamento.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.apicontroleequipamento.dto.HistoricoInserirDTO;
import org.serratec.apicontroleequipamento.dto.MaterialRespostaSimplesDTO;
import org.serratec.apicontroleequipamento.exception.ResourceNotFoundException;
import org.serratec.apicontroleequipamento.model.Historico;
import org.serratec.apicontroleequipamento.model.Material;
import org.serratec.apicontroleequipamento.model.Pessoa;
import org.serratec.apicontroleequipamento.model.Status;
import org.serratec.apicontroleequipamento.repository.HistoricoRepository;
import org.serratec.apicontroleequipamento.repository.MaterialRepository;
import org.serratec.apicontroleequipamento.repository.PessoaRepository;
import org.serratec.apicontroleequipamento.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoService {

	@Autowired
	HistoricoRepository histRepo;
	@Autowired
	PessoaRepository pessoaRepo;
	@Autowired
	MaterialRepository matRepo;
	@Autowired
	StatusRepository statRepo;

	public List<Historico> getAll() {
		List<Historico> historicos =  histRepo.findAll();
				
		return historicos;
	}
	
	
	public List<MaterialRespostaSimplesDTO> getAllRecenteSimplesPorIdStatus(Long id) {
		List<Historico> historicos =  histRepo.getHistoricoMaisRecentePorId(id);
		
		List<MaterialRespostaSimplesDTO> RespostaDTO = historicos
				.stream()
				.map(h -> new MaterialRespostaSimplesDTO(h))
				.collect(Collectors.toList());
				
		return RespostaDTO;
	}
	
	
	public List<MaterialRespostaSimplesDTO> getAllRecenteSimples() {
		List<Historico> historicos =  histRepo.getHistoricosDistintosRecentes();
		
		List<MaterialRespostaSimplesDTO> RespostaDTO = historicos
				.stream()
				.map(h -> new MaterialRespostaSimplesDTO(h))
				.collect(Collectors.toList());
				
		return RespostaDTO;
	}

	public Historico getById(Long id) {
		Optional<Historico> optHist = histRepo.findById(id);
		if (optHist.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o Histórico com id " + id);
		}
		return optHist.get();
	}
	
	public List<Historico> getByMaterial(Long id) {
		return histRepo.getByIdMaterial(id);
	}
	
	public List<Historico> getByPessoa(Long id) {
		return histRepo.getByPessoa(id);
	}
	
	public Historico getMaisRecente(Long id) {
		return histRepo.getMaisRecente(id);
	}
	
	public Historico register(HistoricoInserirDTO historicoDTO) {

		Optional<Pessoa> pessoaDB = pessoaRepo.findById(historicoDTO.getIdPessoaResponsavel());
		if (pessoaDB.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar a pessoa com id " + historicoDTO.getIdPessoaResponsavel());
		}
		Optional<Material> materialDB = matRepo.findById(historicoDTO.getIdMaterial());
		if (pessoaDB.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o material com id " + historicoDTO.getIdMaterial());
		}
		Optional<Status> statDB = statRepo.findById(historicoDTO.getStatus());
		if (statDB.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o status com id " + historicoDTO.getStatus());
		}
		
		Historico historicoDB = new Historico();
		historicoDB.setPessoa(pessoaDB.get());
		historicoDB.setMaterial(materialDB.get());
		historicoDB.setStatus(statDB.get());
		historicoDB.setObservacao(historicoDTO.getObservacoes());
		return histRepo.save(historicoDB);
	}

	/* UPDATE AQUI */
	public Historico update(Long id, Historico historico) {
		Optional<Historico> optHist = histRepo.findById(id);
		if (optHist.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o Histórico com id " + id);
		}
		return histRepo.save(historico);

	}

	public void delete(Long id) {
		Optional<Historico> hist = histRepo.findById(id);
		if (hist.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o Histórico com id " + id);
		}
		histRepo.deleteById(id);
	}
}
