package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Zgrada;

public interface ZgradaRepository extends JpaRepository<Zgrada, Integer> {
	
	@Query("select z from Zgrada z where z.grad = :grad and z.adresa = :adresa")
	Zgrada getZgradaGradAdresa(@Param("grad")String s, @Param("adresa")String adresa);
}
