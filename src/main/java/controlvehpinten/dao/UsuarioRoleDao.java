package controlvehpinten.dao;

import java.util.List;

import controlvehpinten.entity.UsuarioRole;

public interface UsuarioRoleDao {
	public UsuarioRole addUsuarioRole(UsuarioRole usuarioRole);
	public UsuarioRole updateUsuarioRole(UsuarioRole usuarioRole);
	public void deleteUsuarioRole(int usuarioRoleId);
	public UsuarioRole getUsuarioRole(int usuarioRoleId);
	public List<UsuarioRole> getUsuarioRoles();
}
