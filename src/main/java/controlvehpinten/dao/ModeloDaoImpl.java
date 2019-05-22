package controlvehpinten.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.entity.Modelo;

@Repository("modeloDao")
@Transactional
public class ModeloDaoImpl implements ModeloDao {
	@PersistenceContext
	public EntityManager entityManager;
	
	public Modelo addModelo(Modelo modelo) {
		entityManager.persist(modelo);
		return modelo;
	}
	public Modelo updateModelo(Modelo modelo) {
		entityManager.merge(modelo);
		return modelo;
	}
	public void deleteModelo(int modeloId) {
		entityManager.remove(modeloId);
	}
	public Modelo getModelo(int modeloId) {
		String sql="select m from Modelo m where m.idmodelo="+modeloId;
		try {
			return (Modelo)entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}
	public List<Modelo> getModelos(){
		List<Modelo> modelos;
		modelos=entityManager.createQuery("select m from Modelo m").getResultList();
		return modelos;
	}
	
	//obtener modelos segun marca
	public List<Modelo> getModelosporMarca(int idmarca){
		List<Modelo> modelos;
		//System.out.println("tamaño +" + modelos.size());
		String sql="select m from Modelo m where m.marca="+idmarca;
		try {
			modelos=entityManager.createQuery(sql).getResultList();
			
		return modelos;
		}catch(Exception e) {
			System.out.println("ERROR"+e.getMessage());
			System.out.println("ERROR"+e.getCause());
			return null;
		}
	}
	
}
