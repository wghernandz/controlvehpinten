package controlvehpinten.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuariorole")
public class UsuarioRole {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idusuariorole;
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name="idrole")
	private Role role;
	public int getIdusuariorole() {
		return idusuariorole;
	}
	public void setIdusuariorole(int idusuariorole) {
		this.idusuariorole = idusuariorole;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
