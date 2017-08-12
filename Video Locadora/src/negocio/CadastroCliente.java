package negocio;
import interfaces.IRepositorioClientes;
import dados.RepositorioClientesArray;

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

	public void cadastrar(Cliente cliente){
		if(cliente != null){
			if(!cadastro.getInstance().existe(cliente.getCPF())){
				cadastro.inserir(cliente);
			}
			else
				System.out.println("Cliente já cadastrado!");
		}
		else
			System.out.println("Cliente inválido");
	}
	
	public boolean existe(String CPF){
		return cadastro.getInstance().existe(CPF);
	}
	
	public Cliente procurar(String CPF){
		return cadastro.getInstance().procurar(CPF);
	}
	
	public void remover(String CPF){
		cadastro.getInstance().remover(CPF);
	}
	
	public void atualizar(Cliente cliente){
		cadastro.getInstance().atualizar(cliente);
	}
}
