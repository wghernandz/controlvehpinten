package controlvehpinten.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.entity.Anio;
@Repository("anioDao")
@Transactional
public class AnioDaoImpl implements AnioDao {
	@PersistenceContext
	public EntityManager entityManager;

	public Anio addAnio(Anio anio) {
		entityManager.persist(anio);
		return anio;
	}
	public Anio updateAnio(Anio anio) {
		entityManager.merge(anio);
		return anio;
	}
	public void deleteAnio(int anioId) {
		entityManager.remove(anioId);
	}
	public Anio getAnio(int anioId) {
		String sql="select a from Anio a where a.idanio="+anioId;
		try {
			return (Anio)entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}
	public List<Anio> getAnios(){
		List<Anio> anios;
		
		anios= entityManager.createQuery("select a from Anio a").getResultList();
		
		return anios;
	}
}
