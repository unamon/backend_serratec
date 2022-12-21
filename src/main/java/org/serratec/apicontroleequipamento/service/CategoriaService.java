package org.serratec.apicontroleequipamento.service;

import java.util.List;
import java.util.Optional;

import org.serratec.apicontroleequipamento.dto.CategoriaInserirDTO;
import org.serratec.apicontroleequipamento.exception.ResourceNotFoundException;
import org.serratec.apicontroleequipamento.model.Categoria;
import org.serratec.apicontroleequipamento.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository catRepo;

    /**
     * Método responsável por buscar todas as categorias no Banco de Dados.
     * @return Retorna todas as categorias do Banco de Dados.
     */
    public List<Categoria> getAll(){
        return catRepo.findAll();
    }


    /**
     * Método responsável por buscar uma categoria pelo identificador no Banco de Dados.
     * @param id : Identificador da categoria a ser encontrada no Banco de Dados.
     * @return Retorna a categoria encontrada no Banco de Dados pelo id informado.
     */

    public Categoria getById(Long id){
        Optional<Categoria> optCategoria = catRepo.findById(id);

        if(optCategoria.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar a categoria com id " + id);
		}
        System.out.println(optCategoria.get());
        return optCategoria.get();
    }

    /**
     * Método responsável por salvar uma categoria no Banco de Dados.
     * @param categoriaDTO : DTO com os dados à serem convertidos em Categoria e salvos no Banco de Dados.
     * @return Salva uma entidade do tipo categoria no Banco de Dados.
     */
    public Categoria register(CategoriaInserirDTO categoriaDTO){

    	Categoria novaCategoriaDB = new Categoria(categoriaDTO);
        
        validarNome(novaCategoriaDB);
        novaCategoriaDB.setId(null);
        
        return catRepo.save(novaCategoriaDB);
    }

    /**
     * Método responsável por atualizar uma categoria no Banco de Dados.
     * @param id : Identificador da categoria a ser atualizada no Banco de Dados.
     * @param categoria : DTO com as informações para atualizar a entidade no Banco de Dados.
     * @return Atualiza uma entidade do tipo Categoria no Banco de Dados pelo id informado.
     */
    public Categoria update(Long id, CategoriaInserirDTO categoria){
    	Optional<Categoria>	categoriaDB = catRepo.findById(id);
    	if(categoriaDB.isEmpty()) {
            throw new ResourceNotFoundException("Categoria de id " + id + "não encontrada.");
    	}
        Categoria novaCategoria = new Categoria(categoria);
        novaCategoria.setId(id);
        return catRepo.save(novaCategoria);
    }

    /**
     * Método responsável por deletar uma categoria no Banco de Dados.
     * @param id : Identificador da categoria a ser deletada no Banco de Dados.
     */
    public void delete(Long id) {
		getById(id);
		catRepo.deleteById(id);
	}

    /*MUDAR TIPO DE EXCEPTION PARA RESOURCEBADREQUESTEXCEPTION */
    private void validarNome(Categoria categoria){
        List<Categoria> categorias = catRepo.findByNome(categoria.getNome());
        if(categoria.getNome() == null){
            throw new ResourceNotFoundException("A categoria deve ser informada");
        }else if(categorias.size()>0){
            throw new ResourceNotFoundException("A categoria já existe");
        }

    }
}
