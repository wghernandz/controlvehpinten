package controlvehpinten.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.GenerationType;

@Entity
@Table(name="registroestado")
public class Registroestado {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idregistroestado;
	@ManyToOne
	@JoinColumn(name="idingresovehiculo")
	private Ingresovehiculo ingresovehiculo;
	@ManyToOne
	@JoinColumn(name="idestado")
	private Estado estado;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaestado;
	public int getIdregistroestado() {
		return idregistroestado;
	}
	public void setIdregistroestado(int idregistroestado) {
		this.idregistroestado = idregistroestado;
	}
	public Ingresovehiculo getIngresovehiculo() {
		return ingresovehiculo;
	}
	public void setIngresovehiculo(Ingresovehiculo ingresovehiculo) {
		this.ingresovehiculo = ingresovehiculo;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Date getFechaestado() {
		return fechaestado;
	}
	public void setFechaestado(Date fechaestado) {
		this.fechaestado = fechaestado;
	}
	
}
