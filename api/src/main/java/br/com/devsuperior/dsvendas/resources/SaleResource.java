package br.com.devsuperior.dsvendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devsuperior.dsvendas.dto.SaleDTO;
import br.com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import br.com.devsuperior.dsvendas.dto.SaleSumDTO;
import br.com.devsuperior.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleResource {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		return ResponseEntity.ok().body(service.findAll(pageable));
	}
	
	@GetMapping(value = "/amount")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
		return ResponseEntity.ok().body(service.amountGroupedBySeller());
	}

	@GetMapping(value = "/success")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller(){
		return ResponseEntity.ok().body(service.successGroupedBySeller());
	}

}
