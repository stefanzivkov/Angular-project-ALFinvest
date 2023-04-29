package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Korisnik;
import model.Prodaja;

public interface ProdajaRepository extends JpaRepository<Prodaja, Integer> {
	
	@Query("select p from Prodaja p where p.stan.korisnik = :k order by p.datum")
	List<Prodaja> getProdajeAgenta(@Param("k")Korisnik k);
	
	@Query("select p from Prodaja p where p.stan.korisnik = :k and p.datum > :dat order by p.datum")
	List<Prodaja> pretragaProdaja(@Param("k")Korisnik k, @Param("dat")Date datum);
	
	List<Prodaja> findAllByOrderByKorisnik();
}
