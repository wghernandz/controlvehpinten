package controlvehpinten.services;

import controlvehpinten.dao.MarcaDao;
import controlvehpinten.entity.Marca;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("marcaService")
@Transactional
public class MarcaServiceImpl implements MarcaService {
	@Autowired(required=true)
	@Qualifier("marcaDao")
	private MarcaDao marcaDao;
	
	public Marca addMarca(Marca marca) {
		return marcaDao.addMarca(marca);
	}
	public Marca updateMarca(Marca marca) {
		return marcaDao.updateMarca(marca);
	}
	public void deleteMarca(int marcaId) {
		marcaDao.deleteMarca(marcaId);
	}
	public Marca getMarca(int marcaId) {
		return marcaDao.getMarca(marcaId);
	}
	
	public List<Marca> getMarcas(){
		return marcaDao.getMarcas();
	}
}
