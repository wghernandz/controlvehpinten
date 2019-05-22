package controlvehpinten.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controlvehpinten.entity.Cliente;

@Repository("clienteDao")
@Transactional
public class ClienteDaoImpl implements ClienteDao {
	@PersistenceContext
	public EntityManager entityManager;
	
	public Cliente addCliente(Cliente cliente) {
		entityManager.persist(cliente);
		return cliente;
	}
	public Cliente updateCliente(Cliente cliente) {
		entityManager.merge(cliente);
		return cliente;
	}
	public void deleteCliente(int clienteId) {
		entityManager.remove(clienteId);
	}
	public Cliente getCliente(int clienteId) {
		String sql="select c from Cliente c where c.idcliente="+clienteId;
		try {
			return (Cliente)entityManager.createQuery(sql).getSingleResult();
		}
		catch(Exception e) {
			return null;
		}
	}
	public List<Cliente> getClientes(){
		List<Cliente> clientes;
		clientes=entityManager.createQuery("select c from Cliente c").getResultList();
		return clientes;
	}
	
	
}
