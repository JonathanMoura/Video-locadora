package negocio;
import interfaces.IRepositorioClientes;

public class CadastroCliente {
	private IRepositorioClientes cadastro;
	
	public CadastroCliente(IRepositorioClientes repositorio){
		cadastro = repositorio;
	}

	public void cadastrar(Cliente cliente){
		if(cliente != null){
			if(!cadastro.existe(cliente.getCPF())){
				cadastro.inserir(cliente);
			}
			else
				System.out.println("Cliente já cadastrado!");
		}
		else
			System.out.println("Cliente inválido");
	}
	
	public boolean existe(String CPF){
		return cadastro.existe(CPF);
	}
	
	public Cliente procurar(String CPF){
		return cadastro.procurar(CPF);
	}
	
	public void remover(String CPF){
		cadastro.remover(CPF);
	}
	
	public void atualizar(Cliente cliente){
		cadastro.atualizar(cliente);
	}
}
