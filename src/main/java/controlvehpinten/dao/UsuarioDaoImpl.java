package controlvehpinten.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.entity.Usuario;


	@Repository("usuarioDAO")
	@Transactional
	public class UsuarioDaoImpl implements UsuarioDao{
		
		
		@PersistenceContext
		public EntityManager entityManager;

		@Transactional(readOnly=false)
		public Usuario addUsuario(Usuario usuario) {
			
			entityManager.persist(usuario);
			return usuario;
		}

		@Transactional(readOnly=false)
		public Usuario updateUsuario(Usuario usuario) {
			entityManager.merge(usuario);
			return usuario;
		}

		@Transactional(readOnly=false)
		public void deleteUsuario(int usuarioId) {
			
			
		}

		@Transactional(readOnly=true)
		public Usuario getUsuario(int usuarioId) {
			String sql = "select u from Usuario u where u.usuarioid="+usuarioId;
			try{
				return (Usuario) entityManager.createQuery(sql).getSingleResult();
			}catch(Exception e){
				return null;
			}
			
		}

		@Transactional(readOnly=true)
		public List<Usuario> getUsuarios() {
			List<Usuario> list;
			list=entityManager.createQuery("select u from Usuario u").getResultList();
			return list;
		}

	}
	
	
