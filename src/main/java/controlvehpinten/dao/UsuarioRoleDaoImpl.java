package controlvehpinten.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.entity.UsuarioRole;

@Repository("usuarioroleDao")
@Transactional
public class UsuarioRoleDaoImpl implements UsuarioRoleDao {
	@PersistenceContext
	public EntityManager entityManager;

	public UsuarioRole addUsuarioRole(UsuarioRole usuarioRole) {
		entityManager.persist(usuarioRole);
		return usuarioRole;
	}

	public UsuarioRole updateUsuarioRole(UsuarioRole usuarioRole) {
		entityManager.merge(usuarioRole);
		return usuarioRole;
	}

	public void deleteUsuarioRole(int usuarioRoleId) {
		entityManager.remove(usuarioRoleId);	
	}

	public UsuarioRole getUsuarioRole(int usuarioRoleId) {
		String sql="select u from UsuarioRole u where u.idusuariorole="+usuarioRoleId;
		try {
			return (UsuarioRole)entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}

	public List<UsuarioRole> getUsuarioRoles() {
		List<UsuarioRole> usuarioroles;
		usuarioroles=entityManager.createQuery("select u from UsuarioRole u where u.idusuariorole").getResultList();
		return usuarioroles;
	}
	
}
