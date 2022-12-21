package org.serratec.apicontroleequipamento.controller;

import java.util.List;

import org.serratec.apicontroleequipamento.dto.HistoricoInserirDTO;
import org.serratec.apicontroleequipamento.dto.MaterialRespostaSimplesDTO;
import org.serratec.apicontroleequipamento.model.Historico;
import org.serratec.apicontroleequipamento.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/historico")
public class HistoricoController {

	@Autowired
	HistoricoService service;

	@GetMapping
	@ApiOperation(value = "Listagem de todos históricos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna Lista com todos os históricos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<List<Historico>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca de histórico pelo ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna histórico pelo id"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Historico> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}
	
	@GetMapping("/simples")
	public ResponseEntity<List<MaterialRespostaSimplesDTO>> getAllRecenteSimples() {
		return ResponseEntity.ok(service.getAllRecenteSimples());
	}
	
	@GetMapping("/simples/{id}")
	public ResponseEntity<List<MaterialRespostaSimplesDTO>> getAllRecentePorStatusId(Long id) {
		return ResponseEntity.ok(service.getAllRecenteSimplesPorIdStatus(id));
	}
	
	@GetMapping("/material/{id}")
	public ResponseEntity<List<Historico>> getByMaterial(@PathVariable Long id){ 
		return ResponseEntity.ok(service.getByMaterial(id));
	}
	
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<List<Historico>> getByPessoa(@PathVariable Long id) {
		return ResponseEntity.ok(service.getByPessoa(id));
	}
	
	@GetMapping("/recente/{id}")
	public ResponseEntity<Historico> getMaisRecente(@PathVariable Long id) {
		return ResponseEntity.ok(service.getMaisRecente(id));
	}

	@PostMapping
	@ApiOperation(value = "Registro de novo histórico")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna histórico criado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
//	@ResponseStatus(code = HttpStatus.CREATED)
	public Historico Register(@RequestBody HistoricoInserirDTO historico) {
		return service.register(historico);

	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update do histórico")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna histórico atualizado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public Historico update(@PathVariable Long id, @RequestBody Historico historico) {
		return service.update(id, historico);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta o historico")
	@ApiResponses(value = { @ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	}

}
