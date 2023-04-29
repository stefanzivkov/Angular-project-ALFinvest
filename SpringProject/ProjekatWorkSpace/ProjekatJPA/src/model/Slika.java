package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the slika database table.
 * 
 */
@Entity
@NamedQuery(name="Slika.findAll", query="SELECT s FROM Slika s")
public class Slika implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSlika;

	@Lob
	private byte[] root;

	//bi-directional many-to-one association to Stan
	@ManyToOne
	@JsonIgnore
	private Stan stan;

	public Slika() {
	}

	public int getIdSlika() {
		return this.idSlika;
	}

	public void setIdSlika(int idSlika) {
		this.idSlika = idSlika;
	}

	public byte[] getRoot() {
		return this.root;
	}

	public void setRoot(byte[] root) {
		this.root = root;
	}

	public Stan getStan() {
		return this.stan;
	}

	public void setStan(Stan stan) {
		this.stan = stan;
	}

}