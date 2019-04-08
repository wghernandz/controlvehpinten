package controlvehpinten.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="anio")
public class Anio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idanio;
	private String anio;
	public int getIdanio() {
		return idanio;
	}
	public void setIdanio(int idanio) {
		this.idanio = idanio;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	
}
