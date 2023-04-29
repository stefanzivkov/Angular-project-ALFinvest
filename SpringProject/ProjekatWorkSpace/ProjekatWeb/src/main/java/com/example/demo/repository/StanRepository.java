package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Korisnik;
import model.Stan;
import model.Zgrada;

public interface StanRepository extends JpaRepository<Stan, Integer>{
	
	@Query("select s from Stan s where s.zgrada = :z and s.broj = :broj")
	Stan getStanZgradaBroj(@Param("z")Zgrada z, @Param("broj")int broj);
	
	@Query("select s from Stan s where s.korisnik = :k order by s.zgrada.grad")
	List<Stan> getStanovi(@Param("k")Korisnik k);
	
	@Query("select s from Stan s where s.zgrada.grad = :g and s.korisnik = :k order by s.zgrada.grad")
	List<Stan> pretragaStanovaGrad(@Param("g")String grad, @Param("k")Korisnik k);
	
	@Query("select s from Stan s inner join s.obilazaks o where o.korisnik = :k and o.potvrdaObilaska = 1 order by s.zgrada.grad")
	List<Stan> zakazanObilazakStan(@Param("k")Korisnik k);
	
	@Query("select s from Stan s inner join s.omiljenistanovis o where o.korisnik = :k")
	List<Stan> omiljeniStanovi(@Param("k")Korisnik k);
	
	@Query("select s from Stan s left join s.prodajas p on p.stan = s where p.stan is null")
	List<Stan> slobodniStanovi();
	
	@Query("select s from Stan s where s.korisnik = :k and not exists (select p from Prodaja p where p.stan = s)")
	List<Stan> slobodniStanoviProdaja(@Param("k")Korisnik k);
	
	@Query("select s from Stan s where s.zgrada.grad = :grad and not exists (select p from Prodaja p where p.stan = s)")
	List<Stan> pretragaPoGradu(@Param("grad")String s);
	
}
