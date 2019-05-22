package controlvehpinten.dao;

import java.util.List;

import controlvehpinten.entity.Registroestado;

public interface RegistroestadoDao {
	public Registroestado addRegistroestado(Registroestado registroestado);
	public Registroestado updateRegistroestado(Registroestado registroestado);
	public void deleteRegistroestado(int registroestadoId);
	public Registroestado getRegistroestado(int registroestadoId);
	public List<Registroestado> getRegistroestados();
}
