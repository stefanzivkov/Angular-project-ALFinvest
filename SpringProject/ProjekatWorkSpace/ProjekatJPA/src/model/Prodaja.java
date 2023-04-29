package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the prodaja database table.
 * 
 */
@Entity
@NamedQuery(name="Prodaja.findAll", query="SELECT p FROM Prodaja p")
public class Prodaja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProdaja;

	@Temporal(TemporalType.DATE)
	private Date datum;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JsonIgnore
	private Korisnik korisnik;

	//bi-directional many-to-one association to Stan
	@ManyToOne
	@JsonIgnore
	private Stan stan;

	public Prodaja() {
	}

	public int getIdProdaja() {
		return this.idProdaja;
	}

	public void setIdProdaja(int idProdaja) {
		this.idProdaja = idProdaja;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
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