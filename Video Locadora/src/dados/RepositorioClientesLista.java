package dados;
import interfaces.IRepositorioClientes;
import negocio.CelulaCliente;
import negocio.Cliente;

public class RepositorioClientesLista implements IRepositorioClientes {
	private CelulaCliente primeira;
	private CelulaCliente ultima;
	private int tamanho;
	private static RepositorioClientesLista repositorioInstance;
	
	public static RepositorioClientesLista getInstance(){
		if(repositorioInstance == null)
			repositorioInstance = new RepositorioClientesLista();
		
		return repositorioInstance;
	}
	
	public RepositorioClientesLista(){
		tamanho = 0;
	}
	
	public void inserir(Cliente cliente){
		CelulaCliente nova = new CelulaCliente(this.primeira,cliente);
		this.primeira = nova;
		
		if(tamanho == 0)
			this.ultima = this.primeira;
		tamanho++;
	}
	
	public boolean existe(String CPF){ 
		if(procurar(CPF) != null)
			return true;
		else
			return false;
	}
	
	public Cliente procurar(String CPF){
		CelulaCliente atual = primeira;

		while(CPF != atual.getCliente().getCPF()){
			atual = atual.getProx();
			if(atual.getProx() == null)
				return null;
		}
		return atual.getCliente();
	}
	
	public void remover(String CPF){
		if(existe(CPF)){
			CelulaCliente atual = primeira;
			CelulaCliente anterior = null;
			while(CPF != atual.getCliente().getCPF()){
				anterior = atual;
				atual = atual.getProx();
			}
			anterior.setProx(atual.getProx());
			atual.setProx(null);
			
			if(anterior.getProx() == null)
				this.ultima = anterior;
		}
		else
			System.out.println("Cliente não encontrado");
	}
	
	public void atualizar(Cliente cliente){
		String CPF = cliente.getCPF();
		if(existe(CPF)){
			CelulaCliente atual = primeira;
			while(CPF != atual.getCliente().getCPF())
				atual = atual.getProx();
			atual.setCliente(cliente);
		}
		else
			System.out.println("Cliente não encontrado");
	}
}
