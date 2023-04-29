package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Komentar;
import model.Stan;

public interface KomentarRepository extends JpaRepository<Komentar, Integer>{
	
	@Query("select k from Komentar k where k.stan = :s")
	List<Komentar> komentari(@Param("s")Stan s);
}
