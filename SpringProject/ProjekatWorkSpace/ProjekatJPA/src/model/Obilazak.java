package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the obilazak database table.
 * 
 */
@Entity
@NamedQuery(name="Obilazak.findAll", query="SELECT o FROM Obilazak o")
public class Obilazak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idObilazak;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private int potvrdaObilaska;

	private String vreme;
	
	private String napomena;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JsonIgnore
	private Korisnik korisnik;

	//bi-directional many-to-one association to Stan
	@ManyToOne
	@JsonIgnore
	private Stan stan;

	public Obilazak() {
	}

	public int getIdObilazak() {
		return this.idObilazak;
	}

	public void setIdObilazak(int idObilazak) {
		this.idObilazak = idObilazak;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getPotvrdaObilaska() {
		return this.potvrdaObilaska;
	}

	public void setPotvrdaObilaska(int potvrdaObilaska) {
		this.potvrdaObilaska = potvrdaObilaska;
	}

	public String getVreme() {
		return this.vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Stan getStan() {
		return this.stan;
	}

	public void setStan(Stan stan) {
		this.stan = stan;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	
	

}