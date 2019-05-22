package controlvehpinten.dao;

import java.util.List;

import controlvehpinten.entity.Asesor;

public interface AsesorDao {

	public Asesor addAsesor(Asesor asesor);
	public Asesor updateAsesor(Asesor asesor);
	public void deleteAsesor(int asesorId);
	public Asesor getAsesor(int asesorId);
	public List<Asesor> getAsesores();
	
}
