package org.serratec.apicontroleequipamento.service;

import java.util.Optional;

import org.serratec.apicontroleequipamento.model.Pessoa;
import org.serratec.apicontroleequipamento.repository.PessoaRepository;
import org.serratec.apicontroleequipamento.security.PessoaDetalhe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PessoaDetalheImpl implements UserDetailsService{
	@Autowired
	private PessoaRepository pessoaRepo;

	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Pessoa> pessoa = pessoaRepo.findByEmail(username);
		if (pessoa.isEmpty()) {
			throw new RuntimeException();
		}
		return new PessoaDetalhe(pessoa.get());
	}
	
}
