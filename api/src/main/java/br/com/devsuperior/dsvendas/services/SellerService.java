package br.com.devsuperior.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devsuperior.dsvendas.dto.SellerDTO;
import br.com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repo;
	
	public List<SellerDTO> findAll(){
		return  repo.findAll().stream()
					.map(obj -> {
						return new SellerDTO(obj);
					})
					.collect(Collectors.toList());
	}
	
}
