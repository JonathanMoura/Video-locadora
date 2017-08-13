package interfaces;
import excecoes.*;
import negocio.Cliente;

public interface IRepositorioClientes {
	
	public void inserir(Cliente cliente);
	public boolean existe(String CPF) throws ClienteNaoEncontradoException;
	public Cliente procurar(String CPF) throws ClienteNaoEncontradoException;
	public boolean remover(String CPF) throws ClienteNaoEncontradoException;
	public boolean atualizar(Cliente cliente) throws ClienteNaoEncontradoException;
}