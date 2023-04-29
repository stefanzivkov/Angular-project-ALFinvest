package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Korisnik;
import model.Omiljenistanovi;
import model.Stan;

public interface OmiljenistanoviRepository extends JpaRepository<Omiljenistanovi, Integer> {
	
	@Query("select o from Omiljenistanovi o where o.korisnik = :k")
	List<Omiljenistanovi> getOmiljeni(@Param("k")Korisnik k);
	
	@Query("select o from Omiljenistanovi o where o.korisnik = :k and o.stan = :s")
	Omiljenistanovi proveraOmiljenih(@Param("k")Korisnik k, @Param("s")Stan s);
	
	@Query("select o from Omiljenistanovi o where o.stan = :s and o.korisnik = :k")
	Omiljenistanovi brisanje(@Param("s")Stan s, @Param("k")Korisnik k);
}
