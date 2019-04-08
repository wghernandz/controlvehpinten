package controlvehpinten.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="ingresovehiculo")
public class Ingresovehiculo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@SequenceGenerator(name="SEQ_ID_FACTURA",sequenceName="seq_idfactura", allocationSize=1)
	private int idingresovehiculo;
	@ManyToOne
	@JoinColumn(name="idanio")
	private Anio anio;
	@ManyToOne
	@JoinColumn(name="idasesor")
	private Asesor asesor;
	@ManyToOne
	@JoinColumn(name="idmodelo")
	private Modelo modelo;
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name="idestado")
	private Estado estado;
	private String siniestro;
	private String amparo;
	private String placa;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaingreso;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechapromesa;
	public int getIdingresovehiculo() {
		return idingresovehiculo;
	}
	public void setIdingresovehiculo(int idingresovehiculo) {
		this.idingresovehiculo = idingresovehiculo;
	}
	public Anio getAnio() {
		return anio;
	}
	public void setAnio(Anio anio) {
		this.anio = anio;
	}
	public Asesor getAsesor() {
		return asesor;
	}
	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getSiniestro() {
		return siniestro;
	}
	public void setSiniestro(String siniestro) {
		this.siniestro = siniestro;
	}
	public String getAmparo() {
		return amparo;
	}
	public void setAmparo(String amparo) {
		this.amparo = amparo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Date getFechaingreso() {
		return fechaingreso;
	}
	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}
	public Date getFechapromesa() {
		return fechapromesa;
	}
	public void setFechapromesa(Date fechapromesa) {
		this.fechapromesa = fechapromesa;
	}
}
