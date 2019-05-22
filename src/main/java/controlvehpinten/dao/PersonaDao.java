package controlvehpinten.dao;

import java.util.List;

import controlvehpinten.entity.Persona;

public interface PersonaDao {
	public Persona addPersona(Persona persona);
	public Persona updatePersona(Persona persona);
	public void deletePersona(int personaId);
	public Persona getPersona(int personaId);
	public List<Persona> getPersonas();
}
