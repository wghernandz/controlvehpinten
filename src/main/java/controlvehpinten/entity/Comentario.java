package controlvehpinten.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comentario")
public class Comentario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcomentario;
	@ManyToOne
	@JoinColumn(name="registroestado")
	private Registroestado registroestado;
	public int getIdcomentario() {
		return idcomentario;
	}
	public void setIdcomentario(int idcomentario) {
		this.idcomentario = idcomentario;
	}
	public Registroestado getRegistroestado() {
		return registroestado;
	}
	public void setRegistroestado(Registroestado registroestado) {
		this.registroestado = registroestado;
	}

}
