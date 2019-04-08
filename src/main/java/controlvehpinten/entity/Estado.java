package controlvehpinten.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class Estado {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idestado;
	private String nombreestado;
	public int getIdestado() {
		return idestado;
	}
	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}
	public String getNombreestado() {
		return nombreestado;
	}
	public void setNombreestado(String nombreestado) {
		this.nombreestado = nombreestado;
	}
}
