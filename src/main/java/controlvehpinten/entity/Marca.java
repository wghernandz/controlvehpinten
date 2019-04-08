package controlvehpinten.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marca")
public class Marca {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idmarca;
	private String nombremarca;
	public int getIdmarca() {
		return idmarca;
	}
	public void setIdmarca(int idmarca) {
		this.idmarca = idmarca;
	}
	public String getNombremarca() {
		return nombremarca;
	}
	public void setNombremarca(String nombremarca) {
		this.nombremarca = nombremarca;
	}
	
}
