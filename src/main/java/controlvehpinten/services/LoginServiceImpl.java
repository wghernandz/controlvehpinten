package controlvehpinten.services;

import java.util.ArrayList;
import java.util.List;
import controlvehpinten.dao.LoginDao;
import controlvehpinten.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements UserDetailsService {
	
	@Autowired
	LoginDao loginDao;

	@Autowired
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao=loginDao;	
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario= loginDao.findUserInfo(username);
		
		
		if(usuario==null) {
			
			throw new UsernameNotFoundException("NO EXISTE USUARIO");
		}
		
		List<String> roles= loginDao.getUserRoles(username);
		System.out.println("valor"+usuario.getUsername());
		List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
		if(roles!=null) {
			for(String role:roles) {
				GrantedAuthority authority= new SimpleGrantedAuthority(role);
				
				grantList.add(authority);
			}	
		}
		
		UserDetails userDetails= new User(usuario.getUsername(),usuario.getPassword(),grantList);
		return userDetails;
	}

}
