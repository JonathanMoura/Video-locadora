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

	public void cadastrar(Cliente cliente) throws ClienteExistenteException, CampoVazioException{
			if(cliente.getNome().equals("")){
				CampoVazioException e = new CampoVazioException();
				throw e;
			}
			else if(cliente.getCPF().equals("")){
				CampoVazioException e = new CampoVazioException();
				throw e;
			}
			else if(cliente.getRG().equals("")){
				CampoVazioException e = new CampoVazioException();
				throw e;
			}
			else if(cliente.getEndereco().equals("")){
				CampoVazioException e = new CampoVazioException();
				throw e;
			}
			else if(cliente.getTelefone().equals("")){
				CampoVazioException e = new CampoVazioException();
				throw e;
			}
			if(existe(cliente.getCPF())) {
				ClienteExistenteException e = new ClienteExistenteException();
				throw e;
			}
			cadastro.getInstance().inserir(cliente);
	}
	
	public boolean existe(String CPF) {
		return cadastro.getInstance().existe(CPF);
	}
	
	public Cliente procurar(String CPF) throws CampoVazioException, ClienteNaoEncontradoException{
		Cliente cliente = new Cliente();
		if(CPF.equals("")){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		cliente = cadastro.getInstance().procurar(CPF); 
		
		if(cliente == null){
			ClienteNaoEncontradoException e = new ClienteNaoEncontradoException();
			throw e;
		}
		return cliente;
	}
	
	public void atualizar(Cliente cliente) throws CampoVazioException, ClienteNaoEncontradoException{
		if(cliente.getNome().equals("")){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		else if(cliente.getCPF().equals("")){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		else if(cliente.getRG().equals("")){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		else if(cliente.getEndereco().equals("")){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		else if(cliente.getTelefone().equals("")){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		if(!cadastro.getInstance().atualizar(cliente)){
			ClienteNaoEncontradoException e = new ClienteNaoEncontradoException();
			throw e;
		}
	}
	
	public void remover(String CPF) throws CPFVazioException, ClienteNaoEncontradoException{
		if(CPF.equals("")){
			CPFVazioException e = new CPFVazioException();
			throw e;
		}
		
		if(!cadastro.getInstance().remover(CPF)){
			ClienteNaoEncontradoException e = new ClienteNaoEncontradoException();
			throw e;
		}
	}
}
