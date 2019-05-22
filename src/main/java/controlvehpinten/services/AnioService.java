package controlvehpinten.services;

import java.util.List;

import controlvehpinten.entity.Anio;

public interface AnioService {

	public Anio addAnio(Anio anio);
	public Anio updateAnio(Anio anio);
	public void deleteAnio(int anioId);
	public Anio getAnio(int anioId);
	public List<Anio> getAnios();
	
}
