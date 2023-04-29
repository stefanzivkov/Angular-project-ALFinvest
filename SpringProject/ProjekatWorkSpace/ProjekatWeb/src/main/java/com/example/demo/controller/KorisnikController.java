package com.example.demo.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.classes.Response;
import com.example.demo.repository.KomentarRepository;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.SlikaRepository;
import com.example.demo.repository.StanRepository;
import com.example.demo.repository.UlogaRepository;
import com.example.demo.repository.ZgradaRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.Komentar;
import model.Korisnik;
import model.Slika;
import model.Stan;
import model.Uloga;
import model.Zgrada;

@Controller
@RequestMapping(value = "/korisnik")
@CrossOrigin(origins="http://localhost:4200")
public class KorisnikController {

	@Autowired
	KorisnikRepository korisnikRepo;

	@Autowired
	UlogaRepository ulogaRepo;
	
	@Autowired
	ZgradaRepository zgradaRepo;
	
	@Autowired
	StanRepository stanRepo;
	
	@Autowired
	SlikaRepository slikaRepo;
	
	@Autowired
	KomentarRepository komentarRepo;
	
	@PostMapping(value="login")
	public ResponseEntity<Response> login(@RequestParam("username") String username,@RequestParam("password") String password, Principal principal) {
		Korisnik kor = korisnikRepo.findByUsername(username);
		Response resp = new Response();
		System.out.println("Unutar login metode "+username);
		if ( kor == null) { //ukoliko nema korisnika u listi korisnika
			return new ResponseEntity<Response>(resp, HttpStatus.OK);
		}
		System.out.println("Unutar login metode");
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		if ( !passEncoder.matches(password, kor.getPassword())) //ukoliko se sifra ne poklapa sa sifrom koja odgovara tom usernameu
			return new ResponseEntity<Response>(resp, HttpStatus.OK);
		resp.setIdKorisnika(kor.getIdKorisnik());
		resp.setIdUloga(kor.getUloga().getIdUloga());
		resp.setToken(getJWTToken(kor.getUsername()));
		return new ResponseEntity<Response>(resp, HttpStatus.OK);
	}
	
	//dobavi JWT token koji salje u response
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(korisnikRepo.findByUsername(username).getUloga().getNaziv());
		
		String token = Jwts.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Boolean> registracija(@RequestParam(name="username") String username, @RequestParam(name="password") String password,
			@RequestParam(name="ime") String ime, @RequestParam(name="prezime") String prezime,
			@RequestParam(name="email") String email, HttpServletRequest request) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Korisnik kor = korisnikRepo.korisnikRegistracija(username);
		if (kor == null) {
			Uloga u = ulogaRepo.findById(3).get();
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
	
	@GetMapping("/sveZgrade")
	public ResponseEntity<List<Zgrada>> getZgrade() {
		List<Zgrada> zgrade = zgradaRepo.findAll();
		return new ResponseEntity<List<Zgrada>>(zgrade, HttpStatus.OK);
	}
	
	@GetMapping("/getZgrada/{idZgrada}")
	public ResponseEntity<Zgrada> getZgrada(@PathVariable("idZgrada") int idZgrada) {
		Zgrada zgrada = zgradaRepo.findById(idZgrada).get();
		return new ResponseEntity<Zgrada>(zgrada, HttpStatus.OK);
	}
	
	@GetMapping("/getZgradaStan/{idStana}")
	public ResponseEntity<Zgrada> getZgradaStan(@PathVariable("idStana") int idStana) {
		Stan stan = stanRepo.findById(idStana).get();
		Zgrada zgrada = stan.getZgrada();
		return new ResponseEntity<Zgrada>(zgrada, HttpStatus.OK);
	}
	
	@GetMapping("/stanoviZgrade/{idZgrade}")
	public ResponseEntity<List<Stan>> stanoviZgrade(@PathVariable("idZgrade") int idZgrade){
		Zgrada zgrada = zgradaRepo.findById(idZgrade).get();
		List<Stan> stanoviZgrade = zgrada.getStans();
		return new ResponseEntity<List<Stan>>(stanoviZgrade, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sviStanovi", method = RequestMethod.GET)
	public ResponseEntity<List<Stan>> prikazStanova() {
		List<Stan> stanovi = stanRepo.findAll();
		return new ResponseEntity<List<Stan>>(stanovi, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/slobodniStanovi", method = RequestMethod.GET)
	public ResponseEntity<List<Stan>> slobodniStanovi() {
		List<Stan> stanovi = stanRepo.slobodniStanovi();
		return new ResponseEntity<List<Stan>>(stanovi, HttpStatus.OK);
	}

	@RequestMapping(value = "/prikazStana/{idStana}", method = RequestMethod.GET)
	public ResponseEntity<Stan> pretragaStanova(@PathVariable("idStana") int idStana) {
		Stan stan = stanRepo.findById(idStana).get();
		return new ResponseEntity<Stan>(stan, HttpStatus.OK);
	}
	
	@GetMapping(value="/slikeStana/{idStana}")
	public ResponseEntity<List<Slika>> slikeStana(@PathVariable("idStana") int idStana){
		return new ResponseEntity<List<Slika>>(slikaRepo.getSlikeStana(idStana), HttpStatus.OK);
	}
	
	@RequestMapping(value="/pretragaStanovaGrad/{grad}", method=RequestMethod.GET)
	public ResponseEntity<List<Stan>> pretragaStanova(@PathVariable("grad") String grad) {
		List<Stan> stanovi = stanRepo.pretragaPoGradu(grad);
		return new ResponseEntity<List<Stan>>(stanovi, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/korisnikKomentar/{idKomentar}")
	public ResponseEntity<Korisnik> komentarKorisnik(@PathVariable("idKomentar") int idKomentar){
		Komentar kom = komentarRepo.findById(idKomentar).get();
		return new ResponseEntity<Korisnik>(kom.getKorisnik(), HttpStatus.OK);
	}
}
