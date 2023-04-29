package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Integer>{
	
	@Query("select k from Korisnik k where k.uloga.naziv = 'agent'")
	List<Korisnik> sviAgenti();
	
	@Query("select k from Korisnik k where k.username = :usr")
	Korisnik korisnikRegistracija(@Param("usr")String username);
	
	@Query("select k from Korisnik k where k.uloga.naziv = 'kupac'")
	List<Korisnik> sviKupci();
	
	@Query("select k from Korisnik k where k not like :kor and k.uloga.naziv = 'agent'")
	List<Korisnik> brisanje(@Param("kor")Korisnik k);
	
	@Query("select k from Korisnik k where k.username = :username")
	Korisnik findByUsername(@Param("username") String username);
}
