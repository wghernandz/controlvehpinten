package controlvehpinten.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.dao.AnioDao;
import controlvehpinten.entity.Anio;

@Service("anioService")
@Transactional
public class AnioServiceImpl implements AnioService {
	@Autowired(required=true)
	@Qualifier("anioDao")
	private AnioDao anioDao;

	@Override
	public Anio addAnio(Anio anio) {
		return anioDao.addAnio(anio);
	}

	@Override
	public Anio updateAnio(Anio anio) {
		return anioDao.updateAnio(anio);
	}

	@Override
	public void deleteAnio(int anioId) {
		anioDao.deleteAnio(anioId);
	}

	@Override
	public Anio getAnio(int anioId) {
		return anioDao.getAnio(anioId);
	}

	@Override
	public List<Anio> getAnios() {
		return anioDao.getAnios();
	}
	
}
