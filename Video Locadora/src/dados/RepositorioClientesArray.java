package dados;
import negocio.Cliente;
import interfaces.IRepositorioClientes;

public class RepositorioClientesArray implements IRepositorioClientes {
	public static final int TAMANHO = 1000;
	private Cliente[] repositorio;
	private int indice;
	
	public RepositorioClientesArray(){
		this.repositorio = new Cliente[TAMANHO];
		indice = 0;
	}
	
	public int getIndice(String CPF){
		int i = 0;
		while(CPF != repositorio[i].getCPF()){
			if(i > indice){
				System.out.println("Indice não encontrado");
				return indice;
			}
			i++;
		}
		return i;
	}
	
	public void inserir(Cliente cliente){
		this.repositorio[indice] = cliente;
		indice++;
	}
	
	public boolean existe(String CPF){
		int i = getIndice(CPF);
		
		if(repositorio[i] == null)
			return false;
		else
			return true;
	}
	
	public Cliente procurar(String CPF){
		if(existe(CPF))
			return repositorio[getIndice(CPF)];
		else{
			System.out.println("Cliente não encontrado");
			return null;
		}
	}
	
	public void remover(String CPF){
		if(existe(CPF)){
			int i = getIndice(CPF);
			repositorio[i] = null;
			repositorio[i] = repositorio[indice - 1];
			repositorio[indice - 1] = null;
			indice--;
		}
		else
			System.out.println("Cliente não cadastrado");			
	}
	
	public void atualizar(Cliente cliente){
		String CPF = cliente.getCPF();
		if(existe(CPF))
			repositorio[getIndice(CPF)] = cliente;
		else
			System.out.println("Cliente não cadastrado");
	}
}
