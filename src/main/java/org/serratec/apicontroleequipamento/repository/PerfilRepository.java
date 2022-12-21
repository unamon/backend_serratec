package org.serratec.apicontroleequipamento.repository;

import org.serratec.apicontroleequipamento.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    
}
