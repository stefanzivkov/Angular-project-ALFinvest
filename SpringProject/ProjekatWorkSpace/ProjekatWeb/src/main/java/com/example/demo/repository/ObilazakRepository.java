package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Korisnik;
import model.Obilazak;
import model.Stan;

public interface ObilazakRepository extends JpaRepository<Obilazak, Integer> {
	
	@Query("select o from Obilazak o where o.stan.korisnik = :k order by o.datum")
	List<Obilazak> obilasciAgenta(@Param("k")Korisnik k);
	
	//pregled zakazanih obilazaka
	@Query("select o from Obilazak o where o.stan.korisnik = :k and o.potvrdaObilaska = 1 order by o.datum")
	List<Obilazak> getZakazaniObilasci(@Param("k")Korisnik k);
	
	//pregled nezakazanih obilazaka
	@Query("select o from Obilazak o where o.stan.korisnik = :k and o.potvrdaObilaska = 0 order by o.datum")
	List<Obilazak> getNezakazaniObilasci(@Param("k")Korisnik k);
	
	
	@Query("select o from Obilazak o where  o.datum = :datum and o.potvrdaObilaska = 1 and o.stan.korisnik = :k order by o.datum")
	List<Obilazak> pretragaZObilazaka(@Param("datum")Date datum, @Param("k")Korisnik k);
	
	@Query("select o from Obilazak o where  o.datum = :datum and o.potvrdaObilaska = 0 and o.stan.korisnik = :k order by o.datum")
	List<Obilazak> pretragaNObilazaka(@Param("datum")Date datum, @Param("k")Korisnik k);
	
	
	//kupac
	@Query("select o from Obilazak o where o.korisnik = :k")
	List<Obilazak> getObilasciKupac(@Param("k")Korisnik k);
	
	@Query("select o from Obilazak o where o.korisnik = :k and o.potvrdaObilaska = 1")
	List<Obilazak> getObilasciZakazani(@Param("k")Korisnik k);
	
	@Query("select o from Obilazak o where o.korisnik = :k and o.potvrdaObilaska = 0")
	List<Obilazak> getObilasciNezakazani(@Param("k")Korisnik k);
	
	@Query("select o from Obilazak o where o.datum = :datum and o.vreme = :vreme and o.stan = :s")
	List<Obilazak> proveraObilaska(@Param("datum")Date datum, @Param("vreme")String vreme, @Param("s")Stan s);
	
	@Query("select o from Obilazak o order by o.stan.korisnik.ime")
	List<Obilazak> sviObilasci();
	
	@Query("select o from Obilazak o where o.stan = :s")
	List<Obilazak> prodajaObrisi(@Param("s")Stan s);
	
	List<Obilazak> findAllByOrderByKorisnik();
	
	List<Obilazak> findAllByOrderByDatum();
}
