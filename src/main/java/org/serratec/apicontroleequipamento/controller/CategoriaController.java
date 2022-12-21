package org.serratec.apicontroleequipamento.controller;

import java.util.List;

import org.serratec.apicontroleequipamento.dto.CategoriaInserirDTO;
import org.serratec.apicontroleequipamento.model.Categoria;
import org.serratec.apicontroleequipamento.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService catService;

    @GetMapping
    @ApiOperation(value="Listagem de todas as categorias")
    @ApiResponses(value= {
    @ApiResponse(code=200, message="Retorna Lista com todas as categorias"),
    @ApiResponse(code=401, message="Erro de autenticação"),
    @ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
    @ApiResponse(code=505, message="Exceção interna da aplicação"),
    })
    public ResponseEntity<List<Categoria>> getAll(){
 
        return ResponseEntity.ok(catService.getAll()); //200
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Busca de categoria por ID")
    @ApiResponses(value= {
    @ApiResponse(code=200, message="Retorna a categoria e suas informações"),
    @ApiResponse(code=401, message="Erro de autenticação"),
    @ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
    @ApiResponse(code=404, message="Recurso não encontrado"),
    @ApiResponse(code=505, message="Exceção interna da aplicação"),
    })
    public ResponseEntity<Categoria> getById(@PathVariable Long id){
    	System.out.println(id);
        Categoria categoria = catService.getById(id);
        return ResponseEntity.ok(categoria); //200
    }

    @PostMapping
    @ApiOperation(value="POST de categoria")
    @ApiResponses(value= {
    @ApiResponse(code=201, message="A categoria inserida é retornada"),
    @ApiResponse(code=401, message="Erro de autenticação"),
    @ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
    @ApiResponse(code=404, message="Recurso não encontrado"),
    @ApiResponse(code=505, message="Exceção interna da aplicação"),
    })
    public ResponseEntity<Categoria> register(@RequestBody CategoriaInserirDTO categoria) {
		return ResponseEntity.ok(catService.register(categoria)); //201
	}

    @PutMapping("/{id}")
    @ApiOperation(value="Update de categoria")
    @ApiResponses(value= {
    @ApiResponse(code=200, message="Retorna o pedido específico"),
    @ApiResponse(code=401, message="Erro de autenticação"),
    @ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
    @ApiResponse(code=404, message="Recurso não encontrado"),
    @ApiResponse(code=505, message="Exceção interna da aplicação"),
    })
    public ResponseEntity<Categoria> update( @PathVariable Long id, @RequestBody CategoriaInserirDTO categoria){

        Categoria cat = catService.update(id, categoria);
        return ResponseEntity.ok(cat); //200
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Remoção de categoria")
    @ApiResponses(value= {
    @ApiResponse(code=200, message="Retorna o pedido específico"),
    @ApiResponse(code=401, message="Erro de autenticação"),
    @ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
    @ApiResponse(code=404, message="Recurso não encontrado"),
    @ApiResponse(code=505, message="Exceção interna da aplicação"),
    })
    public ResponseEntity<Categoria> delete(@PathVariable Long id){
        catService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
    }
}
