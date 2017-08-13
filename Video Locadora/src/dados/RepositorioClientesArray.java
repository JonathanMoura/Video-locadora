package dados;
import negocio.Cliente;
import interfaces.IRepositorioClientes;
import excecoes.*;

public class RepositorioClientesArray implements IRepositorioClientes {
	public static final int TAMANHO = 1000;
	private Cliente[] repositorio;
	private int indice;
	private static RepositorioClientesArray instance;
	
	public static RepositorioClientesArray getInstance(){
		if(instance == null)
			instance = new RepositorioClientesArray();
		
		return instance;
	}
	
	public RepositorioClientesArray(){
		this.repositorio = new Cliente[TAMANHO];
		indice = 0;
	}
	
	public int getIndice(String CPF) {
		int i = 0;
		if(repositorio[0] == null)
			return -1;
		while(CPF != repositorio[i].getCPF()){
			if(i > indice){
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
	
	public boolean existe(String CPF) {
		int i = getIndice(CPF);
		
		if(i == -1)
			return false;
		
		if(repositorio[i] == null)
			return false;
		else
			return true;
	}
	
	public Cliente procurar(String CPF) {
		if(existe(CPF))
			return repositorio[getIndice(CPF)];
		return null;
	}
	
	public boolean remover(String CPF) {
		if(existe(CPF)){
			int i = getIndice(CPF);
			repositorio[i] = null;
			repositorio[i] = repositorio[indice - 1];
			repositorio[indice - 1] = null;
			indice--;
			return true;
		}
		else
			return false;			
	}
	
	public boolean atualizar(Cliente cliente) {
		String CPF = cliente.getCPF();
		if(existe(CPF)){
			repositorio[getIndice(CPF)] = cliente;
			return true;
		}else
			return false;
	}
}
