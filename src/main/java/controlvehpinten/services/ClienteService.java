package controlvehpinten.services;

import java.util.List;

import controlvehpinten.entity.Cliente;

public interface ClienteService {
	public Cliente addCliente(Cliente cliente);
	public Cliente updateCliente(Cliente cliente);
	public void deleteCliente(int clienteId);
	public Cliente getCliente(int clienteId);
	public List<Cliente> getClientes();
}
