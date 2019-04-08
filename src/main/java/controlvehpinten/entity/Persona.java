package controlvehpinten.entity;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="persona")
public class Persona {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int idpersona;
private String primernombre;
private String segundonombre;
private String primerapellido;
private String segundoapellido;
public int getIdpersona() {
	return idpersona;
}
public void setIdpersona(int idpersona) {
	this.idpersona = idpersona;
}
public String getPrimernombre() {
	return primernombre;
}
public void setPrimernombre(String primernombre) {
	this.primernombre = primernombre;
}
public String getSegundonombre() {
	return segundonombre;
}
public void setSegundonombre(String segundonombre) {
	this.segundonombre = segundonombre;
}
public String getPrimerapellido() {
	return primerapellido;
}
public void setPrimerapellido(String primerapellido) {
	this.primerapellido = primerapellido;
}
public String getSegundoapellido() {
	return segundoapellido;
}
public void setSegundoapellido(String segundoapellido) {
	this.segundoapellido = segundoapellido;
}
	
}
