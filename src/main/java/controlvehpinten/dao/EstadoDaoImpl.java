package controlvehpinten.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.entity.Estado;

@Repository("estadoDao")
@Transactional
public class EstadoDaoImpl implements EstadoDao {
	@PersistenceContext
	public EntityManager entityManager;
	
	public Estado addEstado(Estado estado) {
		entityManager.persist(estado);
		return estado;
	}
	public Estado updateEstado(Estado estado) {
		entityManager.merge(estado);
		return estado;
	}
	public void deleteEstado(int estadoId) {
		entityManager.remove(estadoId);
	}
	public Estado getEstado(int estadoId) {
		String sql="select e from Estado e where e.idestado="+estadoId;
		try {
			return (Estado)entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e) {
			return null;
		}
		
	}
	public List<Estado> getEstados(){
		List<Estado> estados;
		estados=entityManager.createQuery("select e from Estado e").getResultList();
		return estados;
	}
}
