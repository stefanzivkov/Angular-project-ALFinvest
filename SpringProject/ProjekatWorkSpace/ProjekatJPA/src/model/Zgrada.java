package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the zgrada database table.
 * 
 */
@Entity
@NamedQuery(name="Zgrada.findAll", query="SELECT z FROM Zgrada z")
public class Zgrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZgrada;

	private String adresa;

	private String godinaIzgradnje;
	
	private String grad;

	//bi-directional many-to-one association to Stan
	@JsonIgnore
	@OneToMany(mappedBy="zgrada")
	private List<Stan> stans;

	public Zgrada() {
	}

	public int getIdZgrada() {
		return this.idZgrada;
	}

	public void setIdZgrada(int idZgrada) {
		this.idZgrada = idZgrada;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getGodinaIzgradnje() {
		return this.godinaIzgradnje;
	}

	public void setGodinaIzgradnje(String godinaIzgradnje) {
		this.godinaIzgradnje = godinaIzgradnje;
	}

	public List<Stan> getStans() {
		return this.stans;
	}

	public void setStans(List<Stan> stans) {
		this.stans = stans;
	}

	public Stan addStan(Stan stan) {
		getStans().add(stan);
		stan.setZgrada(this);

		return stan;
	}

	public Stan removeStan(Stan stan) {
		getStans().remove(stan);
		stan.setZgrada(null);

		return stan;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}
	
	

}