package controlvehpinten.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.dao.ModeloDao;
import controlvehpinten.entity.Modelo;

@Service("modeloService")
@Transactional
public class ModeloServiceImpl implements ModeloService {
	@Autowired(required=true)
	@Qualifier("modeloDao")
	private ModeloDao modeloDao;
	@Override
	public Modelo addModelo(Modelo modelo) {
		return modeloDao.addModelo(modelo);
	}

	@Override
	public Modelo updateModelo(Modelo modelo) {
		return modeloDao.updateModelo(modelo);
	}

	@Override
	public void deleteModelo(int modeloId) {
		 modeloDao.deleteModelo(modeloId);
	}

	@Override
	public Modelo getModelo(int modeloId) {
		return modeloDao.getModelo(modeloId);
	}

	@Override
	public List<Modelo> getModelos() {
		return modeloDao.getModelos();
	}

	@Override
	public List<Modelo> getModelosxmarca(int idmarca) {
		return modeloDao.getModelosporMarca(idmarca);	
	}
	
}
