package controlvehpinten.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.entity.Asesor;

@Repository("asesorDao")
@Transactional
public class AsesorDaoImpl implements AsesorDao {
	@PersistenceContext
	public EntityManager entityManager;
	
	public Asesor addAsesor(Asesor asesor) {
		entityManager.persist(asesor);
		return asesor;
	}
	public Asesor updateAsesor(Asesor asesor) {
		entityManager.merge(asesor);
		return asesor;
	}
	public void deleteAsesor(int asesorId) {
		entityManager.remove(asesorId);
	}
	public Asesor getAsesor(int asesorId) {
		String sql="select a from Asesor a where a.idasesor="+asesorId;
		try {
			return (Asesor)entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}
	public List<Asesor> getAsesores(){
		List<Asesor> asesores;
		asesores=entityManager.createQuery("select a from Asesor a").getResultList();
		return asesores;
	}
}
