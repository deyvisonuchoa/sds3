package br.com.devsuperior.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.devsuperior.dsvendas.dto.SaleDTO;
import br.com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import br.com.devsuperior.dsvendas.dto.SaleSumDTO;
import br.com.devsuperior.dsvendas.repositories.SaleRepository;
import br.com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repo;
	
	@Autowired
	private SellerRepository sellerRepo;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepo.findAll();
		return  repo.findAll(pageable)
					.map(obj -> {
						return new SaleDTO(obj);
					});
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		sellerRepo.findAll();
		return  repo.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		sellerRepo.findAll();
		return  repo.successGroupedBySeller();
	}
	
}
