package interfaces;
import negocio.Cliente;

public interface IRepositorioClientes {
	
	public void inserir(Cliente cliente);
	public boolean existe(String CPF);
	public Cliente procurar(String CPF);
	public void remover(String CPF);
	public void atualizar(Cliente cliente);
}