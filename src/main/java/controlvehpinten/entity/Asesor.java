package controlvehpinten.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="asesor")
public class Asesor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idasesor;
	@ManyToOne
	@JoinColumn(name="idpersona")
	private Persona persona;
	private int cantvehicrecibidos;
	public int getIdasesor() {
		return idasesor;
	}
	public void setIdasesor(int idasesor) {
		this.idasesor = idasesor;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public int getCantvehicrecibidos() {
		return cantvehicrecibidos;
	}
	public void setCantvehicrecibidos(int cantvehicrecibidos) {
		this.cantvehicrecibidos = cantvehicrecibidos;
	}
	
}
