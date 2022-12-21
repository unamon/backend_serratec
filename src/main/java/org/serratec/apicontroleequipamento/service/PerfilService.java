package org.serratec.apicontroleequipamento.service;

import java.util.List;
import java.util.Optional;

import org.serratec.apicontroleequipamento.exception.ResourceNotFoundException;
import org.serratec.apicontroleequipamento.model.Perfil;
import org.serratec.apicontroleequipamento.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PerfilService {
    
    @Autowired
    PerfilRepository repo;

    public List<Perfil> getAll(){
        return repo.findAll();
    }

    public Perfil getById(Long id){
        Optional<Perfil> optPerfil = repo.findById(id);
        return optPerfil.get();
    }

    public Perfil register(Perfil perfil){
        perfil.setId(null);
        return repo.save(perfil);
    }

    public Perfil update(Long id, Perfil perfil){
        Optional<Perfil> optPerfil = repo.findById(id);
        if (optPerfil.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o Perfil com id " + id);
		}
        return repo.save(perfil);
    }

    public void delete(Long id){
        
    }
}
