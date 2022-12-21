package org.serratec.apicontroleequipamento.repository;


import org.serratec.apicontroleequipamento.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>{
    
}
