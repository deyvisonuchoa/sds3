package br.com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devsuperior.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

}
