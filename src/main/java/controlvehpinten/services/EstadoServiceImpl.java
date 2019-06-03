package controlvehpinten.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.dao.EstadoDao;
import controlvehpinten.entity.Estado;
@Service("estadoService")
@Transactional
public class EstadoServiceImpl implements EstadoService {
	@Autowired(required=true)
	@Qualifier("estadoDao")
	private EstadoDao estadoDao;

	@Override
	public Estado addEstado(Estado estado) {
		return estadoDao.addEstado(estado);
	}

	@Override
	public Estado updateEstado(Estado estado) {
		return estadoDao.updateEstado(estado);
	}

	@Override
	public void deleteEstado(int estadoId) {
		estadoDao.deleteEstado(estadoId);		
	}

	@Override
	public Estado getEstado(int estadoId) {
		return estadoDao.getEstado(estadoId);
	}

	@Override
	public List<Estado> getEstados() {
		return estadoDao.getEstados();
	}

}
