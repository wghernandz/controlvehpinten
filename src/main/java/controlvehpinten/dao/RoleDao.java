package controlvehpinten.dao;

import java.util.List;

import controlvehpinten.entity.Role;

public interface RoleDao {
	public Role addRole(Role role);
	public Role updateRole(Role role);
	public void deleteRole(int roleId);
	public Role getRole(int roleId);
	public List<Role> getRoles();
}
