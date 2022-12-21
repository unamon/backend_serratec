package org.serratec.apicontroleequipamento.service;

import java.io.IOException;
import java.util.Optional;

import org.serratec.apicontroleequipamento.model.Material;
import org.serratec.apicontroleequipamento.model.NotaFiscal;
import org.serratec.apicontroleequipamento.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NotaFiscalService {
	@Autowired
	private NotaFiscalRepository notaFiscalRepo;
	
	public NotaFiscal inserir(Material material, MultipartFile file) throws IOException {
		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.setNome(file.getName());
		notaFiscal.setTipo(file.getContentType());
		notaFiscal.setDados(file.getBytes());
		notaFiscal.setMaterial(material);
		return notaFiscalRepo.save(notaFiscal);
	}
	
	public NotaFiscal buscarPorIdMaterial(Long id) {
		Optional<NotaFiscal> notaFiscal = notaFiscalRepo.findByIdMaterial(id);
		if(notaFiscal.isEmpty()) {
			return null;
		}
		return notaFiscal.get();
		
	}
	
}
