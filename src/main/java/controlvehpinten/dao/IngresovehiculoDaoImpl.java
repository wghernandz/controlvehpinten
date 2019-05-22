package controlvehpinten.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.entity.Ingresovehiculo;

@Repository("ingresovehiculoDao")
@Transactional
public class IngresovehiculoDaoImpl implements IngresovehiculoDao {
	@PersistenceContext
	public EntityManager entityManager;
	
	public Ingresovehiculo addIngresovehiculo(Ingresovehiculo ingresovehiculo) {
		entityManager.persist(ingresovehiculo);
		return ingresovehiculo;
	}
	public Ingresovehiculo updateIngresovehiculo(Ingresovehiculo ingresovehiculo) {
		entityManager.merge(ingresovehiculo);
		return ingresovehiculo;
	}
	public void deleteIngresovehiculo(int ingresovehiculoId) {
		entityManager.remove(ingresovehiculoId);
	}
	public Ingresovehiculo getIngresovehiculo(int ingresovehiculoId) {
		String sql="select i from Ingresovehiculo where i.idingresovehiculo="+ingresovehiculoId;
		try {
			return (Ingresovehiculo)entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}
	public List<Ingresovehiculo> getIngresovehiculos(){
		List<Ingresovehiculo> ingresovehiculos;
		ingresovehiculos=entityManager.createQuery("select i from Ingresovehiculo i").getResultList();
		return ingresovehiculos;
	}
	
}
