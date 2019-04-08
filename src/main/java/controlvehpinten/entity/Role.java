package controlvehpinten.entity;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idrole;
	private String nombrerole;
	public int getIdrole() {
		return idrole;
	}
	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}
	public String getNombrerole() {
		return nombrerole;
	}
	public void setNombrerole(String nombrerole) {
		this.nombrerole = nombrerole;
	}
	
}
