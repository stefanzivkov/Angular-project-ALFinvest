package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	private String email;

	private String ime;

	private String password;

	private String prezime;

	private String username;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="korisnik")
	@JsonIgnore
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Uloga
	@ManyToOne
	@JsonIgnore
	private Uloga uloga;

	//bi-directional many-to-one association to Obilazak
	@OneToMany(mappedBy="korisnik")
	@JsonIgnore
	private List<Obilazak> obilazaks;

	//bi-directional many-to-one association to Omiljenistanovi
	@OneToMany(mappedBy="korisnik")
	@JsonIgnore
	private List<Omiljenistanovi> omiljenistanovis;

	//bi-directional many-to-one association to Prodaja
	@JsonIgnore
	@OneToMany(mappedBy="korisnik")
	private List<Prodaja> prodajas;

	//bi-directional many-to-one association to Stan
	@JsonIgnore
	@OneToMany(mappedBy="korisnik", fetch=FetchType.EAGER)
	private List<Stan> stans;

	public Korisnik() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setKorisnik(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setKorisnik(null);

		return komentar;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public List<Obilazak> getObilazaks() {
		return this.obilazaks;
	}

	public void setObilazaks(List<Obilazak> obilazaks) {
		this.obilazaks = obilazaks;
	}

	public Obilazak addObilazak(Obilazak obilazak) {
		getObilazaks().add(obilazak);
		obilazak.setKorisnik(this);

		return obilazak;
	}

	public Obilazak removeObilazak(Obilazak obilazak) {
		getObilazaks().remove(obilazak);
		obilazak.setKorisnik(null);

		return obilazak;
	}

	public List<Omiljenistanovi> getOmiljenistanovis() {
		return this.omiljenistanovis;
	}

	public void setOmiljenistanovis(List<Omiljenistanovi> omiljenistanovis) {
		this.omiljenistanovis = omiljenistanovis;
	}

	public Omiljenistanovi addOmiljenistanovi(Omiljenistanovi omiljenistanovi) {
		getOmiljenistanovis().add(omiljenistanovi);
		omiljenistanovi.setKorisnik(this);

		return omiljenistanovi;
	}

	public Omiljenistanovi removeOmiljenistanovi(Omiljenistanovi omiljenistanovi) {
		getOmiljenistanovis().remove(omiljenistanovi);
		omiljenistanovi.setKorisnik(null);

		return omiljenistanovi;
	}

	public List<Prodaja> getProdajas() {
		return this.prodajas;
	}

	public void setProdajas(List<Prodaja> prodajas) {
		this.prodajas = prodajas;
	}

	public Prodaja addProdaja(Prodaja prodaja) {
		getProdajas().add(prodaja);
		prodaja.setKorisnik(this);

		return prodaja;
	}

	public Prodaja removeProdaja(Prodaja prodaja) {
		getProdajas().remove(prodaja);
		prodaja.setKorisnik(null);

		return prodaja;
	}

	public List<Stan> getStans() {
		return this.stans;
	}

	public void setStans(List<Stan> stans) {
		this.stans = stans;
	}

	public Stan addStan(Stan stan) {
		getStans().add(stan);
		stan.setKorisnik(this);

		return stan;
	}

	public Stan removeStan(Stan stan) {
		getStans().remove(stan);
		stan.setKorisnik(null);

		return stan;
	}

}