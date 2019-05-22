package controlvehpinten.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.dao.ClienteDao;
import controlvehpinten.entity.Cliente;

@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService {
	@Autowired(required=true)
	@Qualifier("clienteDao")
	private ClienteDao clienteDao;

	@Override
	public Cliente addCliente(Cliente cliente) {
		return clienteDao.addCliente(cliente);
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		return clienteDao.updateCliente(cliente);
	}

	@Override
	public void deleteCliente(int clienteId) {
		clienteDao.deleteCliente(clienteId);
	}

	@Override
	public Cliente getCliente(int clienteId) {
		return clienteDao.getCliente(clienteId);
	}

	@Override
	public List<Cliente> getClientes() {
		return clienteDao.getClientes();
	}
}
