package controlvehpinten.services;

import java.util.List;

import controlvehpinten.entity.Usuario;

public interface UsuarioService {
	public Usuario addUsuario(String nombreuser);
	public Usuario updateUsuario(int usuarioId,String usuarioName, String country);
	/*public void deleteUsuario( usuarioId);*/
	public Usuario getUsuario(int usuarioId);
	public List<Usuario> getUsuarios();
}
