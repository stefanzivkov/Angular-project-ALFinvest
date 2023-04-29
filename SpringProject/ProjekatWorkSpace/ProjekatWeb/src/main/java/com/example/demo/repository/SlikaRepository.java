package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Slika;

public interface SlikaRepository extends JpaRepository<Slika, Integer>{
	
	@Query("select s from Slika s where s.stan.idStan = :id")
	List<Slika> getSlikeStana(@Param("id") int idStana);
}
