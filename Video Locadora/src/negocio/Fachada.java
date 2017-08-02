package negocio;
import dados.*;
import interfaces.*;

public class Fachada {

	private CadastroCliente clientes;
	private CadastroFilme filmes;
	private static Fachada instance;
	
	public Fachada(){
		IRepositorioClientes repositorioClientes = new RepositorioClientesArray();
		IRepositorioFilmes repositorioFilmes = new RepositorioFilmesLista();
		clientes = new CadastroCliente(repositorioClientes);
		filmes = new CadastroFilme(repositorioFilmes);
	}
	
	public static Fachada getInstance(){
		if(instance == null)
			instance = new Fachada();
		return instance;
	}
	
	public void cadastrarCliente(Cliente cliente){
		clientes.cadastrar(cliente);
	}
	
	public Cliente procurarCliente(String CPF){
		return clientes.procurar(CPF);
	}
	
	public void removerCliente(String CPF){
		clientes.remover(CPF);
	}
	
	public void atualizarCliente(Cliente cliente){
		clientes.atualizar(cliente);
	}
	
	public void cadastrarFilme(Filme filme){
		filmes.cadastrar(filme);
	}
	
	public Filme procurarFilme(String nome){
		return filmes.procurar(nome);
	}
	
	public void removerFilme(String nome){
		filmes.remover(nome);
	}
	
	public void atualizarFilme(Filme filme){
		filmes.atualizar(filme);
	}
}
