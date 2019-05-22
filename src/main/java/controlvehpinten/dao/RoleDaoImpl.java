package controlvehpinten.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.entity.Role;

@Repository("roleDao")
@Transactional
public class RoleDaoImpl implements RoleDao {
	@PersistenceContext
	public EntityManager entityManager;

	public Role addRole(Role role) {
		entityManager.persist(role);
		return role;
	}

	public Role updateRole(Role role) {
		entityManager.merge(role);
		return role;
	}

	public void deleteRole(int roleId) {
		entityManager.remove(roleId);
		
	}

	public Role getRole(int roleId) {
		String sql="select r from Role r where r.idrole="+roleId;
		try {
			return (Role)entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}

	public List<Role> getRoles() {
		List<Role> roles;
		roles=entityManager.createQuery("select r from Role r").getResultList();
		return roles;
	}
}
