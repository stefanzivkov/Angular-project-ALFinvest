package com.example.demo.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.ObilazakRepository;
import com.example.demo.repository.ProdajaRepository;
import com.example.demo.repository.SlikaRepository;
import com.example.demo.repository.StanRepository;
import com.example.demo.repository.UlogaRepository;
import com.example.demo.repository.ZgradaRepository;

import model.Korisnik;
import model.Obilazak;
import model.Prodaja;
import model.Stan;
import model.Zgrada;

@Controller
@RequestMapping(value = "/agent")
@CrossOrigin(origins="http://localhost:4200")
public class AgentController {

	@Autowired
	StanRepository stanRepo;

	@Autowired
	ZgradaRepository zgradaRepo;

	@Autowired
	ObilazakRepository obilazakRepo;

	@Autowired
	ProdajaRepository prodajaRepo;

	@Autowired
	KorisnikRepository korisnikRepo;

	@Autowired
	UlogaRepository ulogaRepo;
	
	@Autowired
	SlikaRepository slikaRepo;
	

	@RequestMapping(value = "/dodavanjeStana", method = RequestMethod.POST)
	public ResponseEntity<Boolean> dodavanjeStana(@RequestParam("idZgrada") int idZgrada, @RequestParam("idKorisnik") int idKorisnik, @RequestParam("cena") double cena, 
			@RequestParam("kvadratura") double kvadratura, @RequestParam("opis") String opis, @RequestParam("sprat") int sprat, @RequestParam("broj") int broj ) {
		Zgrada z = zgradaRepo.findById(idZgrada).get();
		Korisnik k = korisnikRepo.findById(idKorisnik).get();
		Stan s = new Stan();
		s.setCena(cena);
		s.setKvadratura(kvadratura);
		s.setSprat(sprat);
		s.setOpis(opis);
		s.setZgrada(z);
		s.setKorisnik(k);
		s.setBroj(broj);
		Stan stan = stanRepo.getStanZgradaBroj(z, broj);
		if (stan == null) {
			s = stanRepo.save(s);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);

		} else {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/dodavanjeZgrade", method = RequestMethod.POST)
	public ResponseEntity<Boolean> dodavanjeStana(@RequestParam("godina") String godina, @RequestParam("adresa") String adresa, @RequestParam("grad") String grad ) {
		Zgrada z = new Zgrada();
		z.setAdresa(adresa);
		z.setGodinaIzgradnje(godina);
		z.setGrad(grad);
		Zgrada zgrada = zgradaRepo.getZgradaGradAdresa(grad, adresa);
		if (zgrada == null) {
			z = zgradaRepo.save(z);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
	}
	

	@RequestMapping(value = "/dodavanjeProdaje", method = RequestMethod.POST)
	public ResponseEntity<Boolean> unosProdaje(@RequestParam("idStan") int idStan, @RequestParam("idKorisnik") int idKorisnik, @RequestParam("datum") String datum) throws ParseException {
		Prodaja p = new Prodaja();
		Stan s = stanRepo.findById(idStan).get();
		Korisnik k = korisnikRepo.findById(idKorisnik).get();
		List<Obilazak> obilasci = obilazakRepo.prodajaObrisi(s);
		for(Obilazak o : obilasci) {
			obilazakRepo.delete(o);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		p.setDatum(sdf.parse(datum));
		p.setStan(s);
		p.setKorisnik(k);
		p = prodajaRepo.save(p);
		if (p != null) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/sviKupci")
	public ResponseEntity<List<Korisnik>> sviKupci(){
		List<Korisnik> kupci = korisnikRepo.sviKupci();
		return new ResponseEntity<List<Korisnik>>(kupci, HttpStatus.OK);
	}
	
	@GetMapping(value="/sviStanovi")
	public ResponseEntity<List<Stan>> sviStanovi(){
		List<Stan> stanovi = stanRepo.slobodniStanovi();
		return new ResponseEntity<List<Stan>>(stanovi, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/azuriranjeObilaska/{idObilazak}")
	public ResponseEntity<Boolean> azuriranjeObilaska(@PathVariable("idObilazak") int idObilazak) {
		Obilazak o = obilazakRepo.findById(idObilazak).get();
		o.setPotvrdaObilaska(1);
		o = obilazakRepo.save(o);
		if(o == null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}else {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
	}
	
	@PostMapping(value="/azuriranjeStana")
	public ResponseEntity<Boolean> azuriranjeStana(@RequestParam("idStan") int idStan, @RequestParam("cena") double cena) {
		Stan s = stanRepo.findById(idStan).get();
		s.setCena(cena);
		s = stanRepo.save(s);
		if(s != null) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}else {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
	}
	
}
