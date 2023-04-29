package com.example.demo.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.ObilazakRepository;
import com.example.demo.repository.ProdajaRepository;
import com.example.demo.repository.StanRepository;
import com.example.demo.repository.UlogaRepository;

import model.Korisnik;
import model.Obilazak;
import model.Prodaja;
import model.Uloga;

@Controller
@RequestMapping(value="/vlasnik")
@CrossOrigin(origins="http://localhost:4200")
public class VlasnikController {
	
	@Autowired
	UlogaRepository ulogaRepo;
	
	@Autowired
	KorisnikRepository korisnikRepo;
	
	@Autowired
	ObilazakRepository obilazakRepo;
	
	@Autowired
	ProdajaRepository prodajaRepo;
	
	@Autowired
	StanRepository stanRepo;
	
	@RequestMapping(value="/unosAgenta", method=RequestMethod.POST)
	public ResponseEntity<Boolean> dodajAgenta(@RequestParam(name="username") String username, @RequestParam(name="password") String password,
			@RequestParam(name="ime") String ime, @RequestParam(name="prezime") String prezime,
			@RequestParam(name="email") String email, HttpServletRequest request) {
		System.out.println("dodavanje agenta");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Korisnik kor = korisnikRepo.korisnikRegistracija(username);
		if (kor == null) {
			Uloga u = ulogaRepo.findById(2).get();
			Korisnik korisnik = new Korisnik();
			korisnik.setIme(ime);
			korisnik.setPrezime(prezime);
			korisnik.setUsername(username);
			korisnik.setPassword(passwordEncoder.encode(password));
			korisnik.setEmail(email);
			korisnik.setUloga(u);
			korisnikRepo.save(korisnik);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/prikazSvihAgenata")
	public ResponseEntity<List<Korisnik>> prikazSvihAgenata(HttpServletRequest request) {
		List<Korisnik> agenti = korisnikRepo.sviAgenti();
		return new ResponseEntity<List<Korisnik>>(agenti, HttpStatus.OK);
	}
	
	@RequestMapping(value="/obilasciAgenta/{idKorisnik}")
	public ResponseEntity<List<Obilazak>> obilasciAgenta(@PathVariable("idKorisnik") int idKorisnik) {
		Korisnik k = korisnikRepo.findById(idKorisnik).get();
		List<Obilazak> obilasci = obilazakRepo.obilasciAgenta(k);
		return new ResponseEntity<List<Obilazak>>(obilasci, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/prodajeAgenta/{idKorisnik}")
	public ResponseEntity<List<Prodaja>> prodajeAgenta(@PathVariable("idKorisnik") int idKorisnik) {
		Korisnik k = korisnikRepo.findById(idKorisnik).get();
		List<Prodaja> prodaje = prodajaRepo.getProdajeAgenta(k);
		return new ResponseEntity<List<Prodaja>>(prodaje, HttpStatus.OK);
	}
}
