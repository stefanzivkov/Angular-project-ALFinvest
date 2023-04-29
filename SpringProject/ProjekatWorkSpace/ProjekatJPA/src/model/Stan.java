package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the stan database table.
 * 
 */
@Entity
@NamedQuery(name="Stan.findAll", query="SELECT s FROM Stan s")
public class Stan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStan;

	private double cena;

	private double kvadratura;

	private String opis;

	private int sprat;
	
	private int broj;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="stan")
	@JsonIgnore
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Obilazak
	@OneToMany(mappedBy="stan")
	@JsonIgnore
	private List<Obilazak> obilazaks;

	//bi-directional many-to-one association to Omiljenistanovi
	@OneToMany(mappedBy="stan")
	@JsonIgnore
	private List<Omiljenistanovi> omiljenistanovis;

	//bi-directional many-to-one association to Prodaja
	@OneToMany(mappedBy="stan")
	@JsonIgnore
	private List<Prodaja> prodajas;

	//bi-directional many-to-one association to Slika
	@OneToMany(mappedBy="stan")
	@JsonIgnore
	private List<Slika> slikas;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JsonIgnore
	private Korisnik korisnik;

	//bi-directional many-to-one association to Zgrada
	@ManyToOne
	@JsonIgnore
	private Zgrada zgrada;

	public Stan() {
	}

	public int getIdStan() {
		return this.idStan;
	}

	public void setIdStan(int idStan) {
		this.idStan = idStan;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getKvadratura() {
		return this.kvadratura;
	}

	public void setKvadratura(double kvadratura) {
		this.kvadratura = kvadratura;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getSprat() {
		return this.sprat;
	}

	public void setSprat(int sprat) {
		this.sprat = sprat;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setStan(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setStan(null);

		return komentar;
	}

	public List<Obilazak> getObilazaks() {
		return this.obilazaks;
	}

	public void setObilazaks(List<Obilazak> obilazaks) {
		this.obilazaks = obilazaks;
	}

	public Obilazak addObilazak(Obilazak obilazak) {
		getObilazaks().add(obilazak);
		obilazak.setStan(this);

		return obilazak;
	}

	public Obilazak removeObilazak(Obilazak obilazak) {
		getObilazaks().remove(obilazak);
		obilazak.setStan(null);

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
		omiljenistanovi.setStan(this);

		return omiljenistanovi;
	}

	public Omiljenistanovi removeOmiljenistanovi(Omiljenistanovi omiljenistanovi) {
		getOmiljenistanovis().remove(omiljenistanovi);
		omiljenistanovi.setStan(null);

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
		prodaja.setStan(this);

		return prodaja;
	}

	public Prodaja removeProdaja(Prodaja prodaja) {
		getProdajas().remove(prodaja);
		prodaja.setStan(null);

		return prodaja;
	}

	public List<Slika> getSlikas() {
		return this.slikas;
	}

	public void setSlikas(List<Slika> slikas) {
		this.slikas = slikas;
	}

	public Slika addSlika(Slika slika) {
		getSlikas().add(slika);
		slika.setStan(this);

		return slika;
	}

	public Slika removeSlika(Slika slika) {
		getSlikas().remove(slika);
		slika.setStan(null);

		return slika;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Zgrada getZgrada() {
		return this.zgrada;
	}

	public void setZgrada(Zgrada zgrada) {
		this.zgrada = zgrada;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}
	
	

}