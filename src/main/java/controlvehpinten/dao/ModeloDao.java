package controlvehpinten.dao;

import java.util.List;

import controlvehpinten.entity.Modelo;

public interface ModeloDao {
	public Modelo addModelo(Modelo modelo);
	public Modelo updateModelo(Modelo modelo);
	public void deleteModelo(int modeloId);
	public Modelo getModelo(int modeloId);
	public List<Modelo> getModelos();
	public List<Modelo> getModelosporMarca(int idmarca);
}
