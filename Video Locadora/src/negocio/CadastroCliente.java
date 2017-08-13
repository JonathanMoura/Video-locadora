package negocio;
import interfaces.IRepositorioClientes;
import dados.RepositorioClientesArray;
import excecoes.*;

public class CadastroCliente {
	private RepositorioClientesArray cadastro;
	private static CadastroCliente instance;
	
	public static CadastroCliente getInstance(){
		if(instance == null)
			instance = new CadastroCliente();
		
		return instance;
	}
	
	public CadastroCliente(){
		
	}
	
	public CadastroCliente(RepositorioClientesArray repositorio){
		cadastro = repositorio;
	}

	public void cadastrar(Cliente cliente) throws ClienteExistenteException{
		if(cadastro.getInstance().existe(cliente.getCPF())){
			ClienteExistenteException e = new ClienteExistenteException();
			throw e;
		}
		else
			cadastro.inserir(cliente);
	}
	
	public boolean existe(String CPF) {
		return cadastro.getInstance().existe(CPF);
	}
	
	public Cliente procurar(String CPF) throws ClienteNaoEncontradoException{
		Cliente cliente = new Cliente();
		
		cliente = cadastro.getInstance().procurar(CPF); 
		
		if(cliente == null){
			ClienteNaoEncontradoException e = new ClienteNaoEncontradoException();
			throw e;
		}
		return cliente;
	}
	
	public void remover(String CPF) throws ClienteNaoEncontradoException{
		if(!cadastro.getInstance().remover(CPF)){
			ClienteNaoEncontradoException e = new ClienteNaoEncontradoException();
			throw e;
		}
	}
	
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException{
		if(!cadastro.getInstance().atualizar(cliente)){
			ClienteNaoEncontradoException e = new ClienteNaoEncontradoException();
			throw e;
		}
	}
}
