package org.serratec.apicontroleequipamento.controller;

import java.io.IOException;
import java.util.List;

import org.serratec.apicontroleequipamento.dto.MaterialInserirDTO;
import org.serratec.apicontroleequipamento.dto.MaterialRespostaDTO;
import org.serratec.apicontroleequipamento.model.Material;
import org.serratec.apicontroleequipamento.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/materiais")
public class MaterialController {

	@Autowired
	MaterialService matService;

	@GetMapping
	public ResponseEntity<List<Material>> getAll() {
		List<Material> materiais = matService.getAll();
		return ResponseEntity.ok(materiais);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca de material por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna o material e suas informações"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<MaterialRespostaDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(matService.getById(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "Retorna materiais com formato de paginação. Mais recomendado usar.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os materiais"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Page<Material>> getAllByPage(

			@PageableDefault(sort = "nome", direction = Direction.DESC, page = 0, size = 1) Pageable materialsPageable) {
		Page<Material> materiais = matService.getByPage(materialsPageable);

		return ResponseEntity.ok(materiais);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Registro de novo material")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Retorna o material registrado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public MaterialRespostaDTO register(@RequestPart MaterialInserirDTO novoMaterial, @RequestPart MultipartFile file) throws IOException {
		return matService.register(novoMaterial, file);

	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update de material")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna o material modificado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Material> update(@PathVariable Long id, @RequestBody MaterialInserirDTO material) {
		return ResponseEntity.ok(matService.update(id, material)); // 200
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta o material")
	@ApiResponses(value = { @ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		matService.delete(id);
		return ResponseEntity.noContent().build(); // 204
	}

}
