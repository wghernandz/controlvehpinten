package controlvehpinten.dao;

import java.util.List;

import controlvehpinten.entity.Estado;

public interface EstadoDao {
	public Estado addEstado(Estado estado);
	public Estado updateEstado(Estado estado);
	public void deleteEstado(int estadoId);
	public Estado getEstado(int estadoId);
	public List<Estado> getEstados();
}
