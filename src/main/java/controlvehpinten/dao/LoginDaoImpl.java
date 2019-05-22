package controlvehpinten.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import controlvehpinten.entity.Usuario;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
	
	@PersistenceContext
	public EntityManager entityManager;
	
	@Transactional
	public Usuario findUserInfo(String username) {
		String sql = "select u from Usuario u where u.username='"+username+"'";
		try{
			return (Usuario) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e){
		}
		return null;	
	}
	@Transactional
	public List<String> getUserRoles(String username){
		List<String> list;
		list=entityManager.createQuery("select r.nombrerole from Role r ").getResultList();
		return list;	
	}

}
