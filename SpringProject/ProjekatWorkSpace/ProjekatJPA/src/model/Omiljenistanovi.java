package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the omiljenistanovi database table.
 * 
 */
@Entity
@NamedQuery(name="Omiljenistanovi.findAll", query="SELECT o FROM Omiljenistanovi o")
public class Omiljenistanovi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOmiljeniStanovi;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JsonIgnore
	private Korisnik korisnik;

	//bi-directional many-to-one association to Stan
	@ManyToOne
	@JsonIgnore
	private Stan stan;

	public Omiljenistanovi() {
	}

	public int getIdOmiljeniStanovi() {
		return this.idOmiljeniStanovi;
	}

	public void setIdOmiljeniStanovi(int idOmiljeniStanovi) {
		this.idOmiljeniStanovi = idOmiljeniStanovi;
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

}