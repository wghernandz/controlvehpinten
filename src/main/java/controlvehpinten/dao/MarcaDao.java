package controlvehpinten.dao;

import java.util.List;

import controlvehpinten.entity.Marca;

public interface MarcaDao {
	
	public Marca addMarca(Marca marca);
	public Marca updateMarca(Marca marca);
	public void deleteMarca(int marcaId);
	public Marca getMarca(int marcaId);
	public List<Marca> getMarcas();

}
