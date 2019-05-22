package controlvehpinten.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.entity.Persona;

@Repository("personaDao")
@Transactional
public class PersonaDaoImpl implements PersonaDao{
	@PersistenceContext
	public EntityManager entityManager;
	
	public Persona addPersona(Persona persona) {
		entityManager.persist(persona);
		return persona;
	}
	public Persona updatePersona(Persona persona) {
		entityManager.merge(persona);
		return persona;
	}
	public void deletePersona(int personaId) {
		entityManager.remove(personaId);
	}
	public Persona getPersona(int personaId) {
		String sql="select p from Persona p where p.personaid="+personaId;
		try {
			return (Persona)entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}
	public List<Persona> getPersonas(){
		List<Persona> personas;
		personas=entityManager.createQuery("select p from Persona p").getResultList();
		return personas;
	}
}
