package controlvehpinten.services;

import java.util.List;

import controlvehpinten.entity.Modelo;

public interface ModeloService {
	public Modelo addModelo(Modelo modelo);
	public Modelo updateModelo(Modelo modelo);
	public void deleteModelo(int modeloId);
	public Modelo getModelo(int modeloId);
	public List<Modelo> getModelos();
	public List<Modelo> getModelosxmarca(int idmarca);
}
