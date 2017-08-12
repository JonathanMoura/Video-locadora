package negocio;
import dados.*;
import interfaces.*;
import excecoes.*;

public class Fachada {

	private CadastroCliente clientes;
	private CadastroFilme filmes;
	private static Fachada instance;
	
	public Fachada(){
		RepositorioClientesArray repositorioClientes = new RepositorioClientesArray();
		IRepositorioFilmes repositorioFilmes = new RepositorioFilmesLista();
		clientes = new CadastroCliente(repositorioClientes);
		filmes = new CadastroFilme(repositorioFilmes);
	}
	
	public static Fachada getInstance(){
		if(instance == null)
			instance = new Fachada();
		return instance;
	}
	
	public void cadastrarCliente(Cliente cliente) throws FilmeExistenteException {
		clientes.getInstance().cadastrar(cliente);
	}
	
	public Cliente procurarCliente(String CPF){
		return clientes.getInstance().procurar(CPF);
	}
	
	public void removerCliente(String CPF){
		clientes.getInstance().remover(CPF);
	}
	
	public void atualizarCliente(Cliente cliente){
		clientes.getInstance().atualizar(cliente);
	}
	
	public void cadastrarFilme(Filme filme) throws FilmeExistenteException  {
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
