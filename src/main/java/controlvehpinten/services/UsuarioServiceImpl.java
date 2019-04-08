package controlvehpinten.services;

import controlvehpinten.dao.UsuarioDao;
import controlvehpinten.entity.Persona;
import controlvehpinten.entity.Usuario;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired(required=true)
	@Qualifier("usuarioDAO")
	private UsuarioDao usuarioDAO;
	
	@Transactional
	public Usuario addUsuario(String usuarioName) {
		Persona pnueva=new Persona();
		pnueva.setPrimernombre("elias");
		pnueva.setPrimerapellido("chavez");
		//System.out.println("Customer Service create invoked:"+usuarioName);
		Usuario usuario  = new Usuario();
		usuario.setPersona(pnueva);
		usuario.setIdusuario(2);
		usuario.setUsername("willian");
		usuario.setPassword("willian");
		usuario = usuarioDAO.addUsuario(usuario);
		return usuario;
	}
	@Transactional
	public Usuario updateUsuario(int usuarioId,String usuarioName, String country) {
		Persona pnueva=new Persona();
		pnueva.setPrimernombre("elias");
		pnueva.setPrimerapellido("chavez");
		
		System.out.println("Cusomer Service Update invoked:"+usuarioName);
		//System.out.println("Customer Service create invoked:"+usuarioName);
				Usuario usuario  = new Usuario();
				usuario.setPersona(pnueva);
				usuario.setIdusuario(2);
				usuario.setUsername("willian");
				usuario.setPassword("willian");
				usuario = usuarioDAO.updateUsuario(usuario);
		return usuario;
	}

	public Usuario getUsuario(int usuarioId) {
		return usuarioDAO.getUsuario(usuarioId);
	}

	public List<Usuario> getUsuarios() {
		return usuarioDAO.getUsuarios();
	}
	
}
