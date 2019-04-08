package controlvehpinten.dao;

import java.util.List;

import controlvehpinten.entity.Usuario;

public interface LoginDao {
	
	public Usuario findUserInfo(String username);
	
	public List<String> getUserRoles(String username);

}
