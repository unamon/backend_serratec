package org.serratec.apicontroleequipamento.repository;


import java.util.List;

import org.serratec.apicontroleequipamento.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{
    public List<Categoria> findByNome(String nome);
}
