package controlvehpinten.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.dao.IngresovehiculoDao;
import controlvehpinten.entity.Ingresovehiculo;
@Service("ingresovehiculoService")
@Transactional
public class IngresovehiculoServiceImpl implements IngresovehiculoService {
	@Autowired(required=true)
	@Qualifier("ingresovehiculoDao")
	private IngresovehiculoDao ingresovehiculoDao;
	
	
	@Override
	public Ingresovehiculo addIngresovehiculo(Ingresovehiculo ingresovehiculo) {
		return ingresovehiculoDao.addIngresovehiculo(ingresovehiculo);
	}

	@Override
	public Ingresovehiculo updateIngresovehiculo(Ingresovehiculo ingresovehiculo) {
		return ingresovehiculoDao.updateIngresovehiculo(ingresovehiculo);
	}

	@Override
	public void deleteIngresovehiculo(int ingresovehiculoId) {
		ingresovehiculoDao.deleteIngresovehiculo(ingresovehiculoId);
		
	}

	@Override
	public Ingresovehiculo getIngresovehiculo(int ingresovehiculoId) {
		return ingresovehiculoDao.getIngresovehiculo(ingresovehiculoId);
	}

	@Override
	public List<Ingresovehiculo> getIngresovehiculos() {
		return ingresovehiculoDao.getIngresovehiculos();
	}

}
