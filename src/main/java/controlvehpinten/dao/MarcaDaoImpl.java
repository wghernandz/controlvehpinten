package controlvehpinten.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.entity.Marca;

@Repository("marcaDao")
@Transactional
public class MarcaDaoImpl implements MarcaDao {
	@PersistenceContext
	public EntityManager entityManager;
	
	@Transactional(readOnly=false)
	public Marca addMarca(Marca marca) {
		entityManager.persist(marca);
		return marca;
	}
	@Transactional(readOnly=false)
	public Marca updateMarca(Marca marca) {
		entityManager.merge(marca);
		return marca;
	}
	@Transactional(readOnly=false)
	public void deleteMarca(int marcaId) {
		entityManager.remove(marcaId);
	}
	@Transactional(readOnly=false)
	public Marca getMarca(int marcaId) {
		String sql="select m from Marca m where m.idmarca="+marcaId;
		try { 
			return (Marca)entityManager.createQuery(sql).getSingleResult();
		}
		catch(Exception e) {
			return null;
		}
		
	}
	@Transactional(readOnly=false)
	public List<Marca> getMarcas(){
		List<Marca> marcas;
		
		marcas=entityManager.createQuery("select m from Marca m").getResultList();
		
		return marcas;
	}
}
