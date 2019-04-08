package controlvehpinten.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;


@Entity
@Table(name="modelo")
public class Modelo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idmodelo;
	@ManyToOne
	@JoinColumn(name="idmarca")
	private Marca marca;
	private String nombremodelo;
	public int getIdmodelo() {
		return idmodelo;
	}
	public void setIdmodelo(int idmodelo) {
		this.idmodelo = idmodelo;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public String getNombremodelo() {
		return nombremodelo;
	}
	public void setNombremodelo(String nombremodelo) {
		this.nombremodelo = nombremodelo;
	}
	
}
