package controlvehpinten.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.entity.Registroestado;

@Repository("registroestadoDao")
@Transactional
public class RegistroestadoDaoImpl implements RegistroestadoDao {
	@PersistenceContext
	public EntityManager entityManager;
	
	public Registroestado addRegistroestado(Registroestado registroestado) {
		entityManager.persist(registroestado);
		return registroestado;
	}
	public Registroestado updateRegistroestado(Registroestado registroestado) {
		entityManager.merge(registroestado);
		return registroestado;
	}
	public void deleteRegistroestado(int registroestadoId) {
		entityManager.remove(registroestadoId);
	}
	public Registroestado getRegistroestado(int registroestadoId) {
		String sql="select r from Registroestado r where r.idregistroestado="+registroestadoId;
		try {
			return (Registroestado)entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}
	public List<Registroestado> getRegistroestados(){
		List<Registroestado> registroestados;
		registroestados=entityManager.createQuery("select r from Registroestado r").getResultList();
		return registroestados;
	}
}
