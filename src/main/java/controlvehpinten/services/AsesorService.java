package controlvehpinten.services;

import java.util.List;

import controlvehpinten.entity.Asesor;

public interface AsesorService {
	public Asesor addAsesor(Asesor asesor);
	public Asesor updateAsesor(Asesor asesor);
	public void deleteAsesor(int asesorId);
	public Asesor getAsesor(int asesorId);
	public List<Asesor> getAsesors();
}
