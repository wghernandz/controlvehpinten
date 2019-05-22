package controlvehpinten.dao;

import java.util.List;

import controlvehpinten.entity.Ingresovehiculo;

public interface IngresovehiculoDao {
	public Ingresovehiculo addIngresovehiculo(Ingresovehiculo ingresovehiculo);
	public Ingresovehiculo updateIngresovehiculo(Ingresovehiculo ingresovehiculo);
	public void deleteIngresovehiculo(int ingresovehiculoId);
	public Ingresovehiculo getIngresovehiculo(int ingresovehiculoId);
	public List<Ingresovehiculo> getIngresovehiculos();
}
