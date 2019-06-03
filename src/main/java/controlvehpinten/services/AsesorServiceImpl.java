package controlvehpinten.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.dao.AsesorDao;
import controlvehpinten.entity.Asesor;

@Service("asesorService")
@Transactional
public class AsesorServiceImpl implements AsesorService {
	@Autowired(required=true)
	@Qualifier("asesorDao")
	private AsesorDao asesorDao;

	@Override
	public Asesor addAsesor(Asesor asesor) {
		return asesorDao.addAsesor(asesor);
	}

	@Override
	public Asesor updateAsesor(Asesor asesor) {
		return asesorDao.updateAsesor(asesor);
	}

	@Override
	public void deleteAsesor(int asesorId) {
		asesorDao.deleteAsesor(asesorId);
	}

	@Override
	public Asesor getAsesor(int asesorId) {
		return asesorDao.getAsesor(asesorId);
	}

	@Override
	public List<Asesor> getAsesors() {
		return asesorDao.getAsesores();
	}
}
