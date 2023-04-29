package com.example.demo.controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.KomentarRepository;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.ObilazakRepository;
import com.example.demo.repository.OmiljenistanoviRepository;
import com.example.demo.repository.StanRepository;

import model.Komentar;
import model.Korisnik;
import model.Obilazak;
import model.Omiljenistanovi;
import model.Stan;
import model.Zgrada;

@Controller
@RequestMapping(value="/kupac")
@CrossOrigin(origins="http://localhost:4200")
public class KupacController {

	@Autowired
	ObilazakRepository obilazakRepo;
	
	@Autowired
	KorisnikRepository korisnikRepo;
	
	@Autowired
	StanRepository stanRepo;
	
	@Autowired
	KomentarRepository komentarRepo;
	
	@Autowired
	OmiljenistanoviRepository omiljenistanoviRepo;
	
	@RequestMapping(value="/dodavanjeObilaska", method=RequestMethod.POST)
	public ResponseEntity<Boolean> dodavanjeObilaska(@RequestParam("vreme") String vreme,@RequestParam("datum") Date datum,@RequestParam("napomena") String napomena,
			@RequestParam("idKorisnik") int idKorisnik, @RequestParam("idStan") int idStan) {
		System.out.println("zakazivanje "+idKorisnik);
		Korisnik k = korisnikRepo.findById(idKorisnik).get();

		Stan s = stanRepo.findById(idStan).get();
		Obilazak o = new Obilazak();
		o.setDatum(datum);
		o.setVreme(vreme);
		o.setKorisnik(k);
		o.setNapomena(napomena);
		o.setStan(s);
		o.setPotvrdaObilaska(0);
		List<Obilazak> ob = obilazakRepo.proveraObilaska(datum, vreme, s);
		if(ob.size() == 0) {
			o = obilazakRepo.save(o);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}else{
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/dodavanjeKomentara", method=RequestMethod.POST)
	public ResponseEntity<Boolean> dodavanjeKomentara(@RequestParam("idKorisnik") int idKorisnik, @RequestParam("idStan") int idStan, @RequestParam("komentar") String komentar) {
		Korisnik k = korisnikRepo.findById(idKorisnik).get();
		Stan s = stanRepo.findById(idStan).get();
		Komentar kom = new Komentar();
		kom.setKomentar(komentar);
		kom.setKorisnik(k);
		kom.setStan(s);
		kom = komentarRepo.save(kom);
		if(kom != null) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}else {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/prikazKomentara/{idStan}")
	public ResponseEntity<List<Komentar>> prikazKomentara(@PathVariable("idStan") int idStan) {
		Stan s = stanRepo.findById(idStan).get();
		List<Komentar> komentari = s.getKomentars();
		return new ResponseEntity<List<Komentar>>(komentari, HttpStatus.OK);
	}
	
	@RequestMapping(value="/prikazStanovaZaObilazak/{idKorisnik}", method=RequestMethod.GET)
	public ResponseEntity<List<Stan>> pretragaStanovaZakazani(@PathVariable("idKorisnik") int idKorisnik) {
		Korisnik korisnik = korisnikRepo.findById(idKorisnik).get();
		List<Stan> stanovi = stanRepo.zakazanObilazakStan(korisnik);
		return new ResponseEntity<List<Stan>>(stanovi, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getObilasci/{idKorisnik}", method=RequestMethod.GET)
	public ResponseEntity<List<Obilazak>> pretragaObilazaka(@PathVariable("idKorisnik") int idKorisnik) {
		Korisnik korisnik = korisnikRepo.findById(idKorisnik).get();
		List<Obilazak> obilasci = obilazakRepo.getObilasciKupac(korisnik);
		return new ResponseEntity<List<Obilazak>>(obilasci, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getZgrada/{idObilazak}", method=RequestMethod.GET)
	public ResponseEntity<Zgrada> getZgradaObilazak(@PathVariable("idObilazak") int idObilazak) {
		Obilazak o = obilazakRepo.findById(idObilazak).get();
		Stan s = o.getStan();
		return new ResponseEntity<Zgrada>(s.getZgrada(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/omiljeniStanovi/{idKorisnik}", method=RequestMethod.GET)
	public ResponseEntity<List<Stan>> omiljeniStanovi(@PathVariable("idKorisnik") int idKorisnik) {
		System.out.println("idKorisnik"+idKorisnik);
		Korisnik k = korisnikRepo.findById(idKorisnik).get();
		List<Stan> tmp = stanRepo.omiljeniStanovi(k);
		List<Stan> slobodni = stanRepo.slobodniStanovi();
		List<Stan> omiljeni = new ArrayList<Stan>();
		for(Stan s: tmp) {
			if(slobodni.contains(s)) {
				omiljeni.add(s);
			}
		}
		return new ResponseEntity<List<Stan>>(omiljeni, HttpStatus.OK);
	}
	
	@RequestMapping(value="/prikazStana")
	public String prikazStana(HttpServletRequest request, Integer idS) {
		Stan s = stanRepo.findById(idS).get();
		request.getSession().setAttribute("stan", s);
		return "kupac/prikazStana";
	}
	
	@RequestMapping(value="/dodajUOmiljene")
	public ResponseEntity<Boolean> dodajUOmiljene(@RequestParam("idStan") int idStan,@RequestParam("idKorisnik") int idKorisnik) {
		Stan s = stanRepo.findById(idStan).get();
		Korisnik k = korisnikRepo.findById(idKorisnik).get();
		Omiljenistanovi om = omiljenistanoviRepo.proveraOmiljenih(k, s);
		if(om == null) {
		Omiljenistanovi omiljeni = new Omiljenistanovi();
		omiljeni.setKorisnik(k);
		omiljeni.setStan(s);
		omiljeni = omiljenistanoviRepo.save(omiljeni);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
		}else {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
	}


	
	@RequestMapping(value="/ukloniOmiljeni")
	public String ukloniOmiljeni(HttpServletRequest request) {
		Stan s = (Stan)request.getSession().getAttribute("stan");
		Korisnik k = (Korisnik) request.getSession().getAttribute("korisnik");
		Omiljenistanovi o = omiljenistanoviRepo.brisanje(s,k);
		omiljenistanoviRepo.delete(o);
		return "kupac/pocetnaStranicaKupac";
	}
}
