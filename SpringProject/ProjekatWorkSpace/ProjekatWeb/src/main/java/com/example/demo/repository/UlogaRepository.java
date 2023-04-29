package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Uloga;

public interface UlogaRepository extends JpaRepository<Uloga, Integer>{
	
	@Query("select u from Uloga u  where u.naziv = 'agent' or u.naziv = 'kupac'")
	List<Uloga> sveBezVlasnika();
}
