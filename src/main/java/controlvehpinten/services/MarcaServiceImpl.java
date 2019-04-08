package controlvehpinten.services;

import controlvehpinten.dao.MarcaDao;
import controlvehpinten.entity.Marca;
import controlvehpinten.entity.Persona;
import controlvehpinten.entity.Usuario;
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
	
	public List<Marca> getMarcas(){
		return marcaDao.getMarcas();
	}
}
