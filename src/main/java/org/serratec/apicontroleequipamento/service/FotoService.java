package org.serratec.apicontroleequipamento.service;

import java.io.IOException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.apicontroleequipamento.model.Foto;
import org.serratec.apicontroleequipamento.model.Pessoa;
import org.serratec.apicontroleequipamento.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoService {
	@Autowired
	private FotoRepository fotoRepository;

	/**
	 * 
	 * @param pessoa
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public Foto inserir(Pessoa pessoa, MultipartFile file) throws IOException {
		Foto foto = new Foto();
		foto.setNome(file.getName());
		foto.setTipo(file.getContentType());
		foto.setDados(file.getBytes());
		foto.setPessoa(pessoa);
		return fotoRepository.save(foto);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public Foto buscarPorIdPessoa(Long id) {
		Optional<Foto> foto = fotoRepository.findByIdPessoa(id);
		if (foto.isEmpty()) {
			return null;
		}
		return foto.get();
	}
	
	public Foto update(Pessoa pessoa, MultipartFile file) throws IOException {
		Optional<Foto> fotoDB = fotoRepository.findByIdPessoa(pessoa.getId());
		Foto foto = fotoDB.get();
		foto.setNome(file.getName());
		foto.setTipo(file.getContentType());
		foto.setDados(file.getBytes());
		foto.setPessoa(pessoa);
		return fotoRepository.save(foto);
	}
}
