package br.com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
