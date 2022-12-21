package org.serratec.apicontroleequipamento.controller;

import java.io.IOException;
import java.util.List;

import org.serratec.apicontroleequipamento.dto.PessoaInserirDTO;
import org.serratec.apicontroleequipamento.dto.PessoaRespostaDTO;
import org.serratec.apicontroleequipamento.model.Foto;
import org.serratec.apicontroleequipamento.service.FotoService;
import org.serratec.apicontroleequipamento.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	FotoService fotoService;
	
	@GetMapping
	public ResponseEntity<List<PessoaRespostaDTO>> getAll(){
		return ResponseEntity.ok(pessoaService.getPessoas());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaRespostaDTO> getPessoa(@PathVariable Long id){
		return ResponseEntity.ok(pessoaService.getPessoaById(id));
	}
	
	@GetMapping("/{id}/foto")
	public ResponseEntity<byte[]> buscarFoto(@PathVariable Long id) {
		Foto foto = fotoService.buscarPorIdPessoa(id);
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", foto.getTipo());
		header.add("Content-length", String.valueOf(foto.getDados().length));
		return new ResponseEntity<>(foto.getDados(), header, HttpStatus.OK);
	}
	
	@PostMapping(consumes = (MediaType.MULTIPART_FORM_DATA_VALUE))
	@ResponseStatus(code = HttpStatus.CREATED)
	public PessoaRespostaDTO register(@RequestPart PessoaInserirDTO novaPessoa, @RequestPart MultipartFile file) throws IOException {
		PessoaRespostaDTO pessoa = pessoaService.register(novaPessoa, file); 
		return pessoa;
	}

}
