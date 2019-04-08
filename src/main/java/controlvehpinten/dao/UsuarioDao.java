package controlvehpinten.dao;

import java.util.List;

import controlvehpinten.entity.Usuario;

public interface UsuarioDao {
	
	public Usuario addUsuario(Usuario usuario);
	public Usuario updateUsuario(Usuario usuario);
	public void deleteUsuario(int usuarioId);
	public Usuario getUsuario(int usuarioId);
	public List<Usuario> getUsuarios();

}
