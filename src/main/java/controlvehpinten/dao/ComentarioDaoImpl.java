package controlvehpinten.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.entity.Comentario;

@Repository("comentarioDao")
@Transactional
public class ComentarioDaoImpl implements ComentarioDao {
	@PersistenceContext
	public EntityManager entityManager;
	
	public Comentario addComentario(Comentario comentario) {
		entityManager.persist(comentario);
		return comentario;
	}
	public Comentario updateComentario(Comentario comentario) {
		entityManager.merge(comentario);
		return comentario;
	}
	public void deleteComentario(int comentarioId) {
		entityManager.remove(comentarioId);
	}
	public Comentario getComentario(int comentarioId) {
		String sql="select c from Comentario c where c.idcomentario="+comentarioId;
		try {
			return (Comentario)entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}
	public List<Comentario> getComentarios(){
		List<Comentario> comentarios;
		comentarios=entityManager.createQuery("select c from Comentario c").getResultList();
		return comentarios;
	}
}
