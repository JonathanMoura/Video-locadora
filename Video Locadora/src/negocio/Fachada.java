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
		RepositorioFilmesLista repositorioFilmes = new RepositorioFilmesLista();
		clientes = new CadastroCliente(repositorioClientes);
		filmes = new CadastroFilme(repositorioFilmes);
	}
	
	public static Fachada getInstance(){
		if(instance == null)
			instance = new Fachada();
		return instance;
	}
	
	public void cadastrarCliente(Cliente cliente) throws ClienteExistenteException{
		clientes.getInstance().cadastrar(cliente);
	}
	
	public Cliente procurarCliente(String CPF) throws ClienteNaoEncontradoException{
		return clientes.getInstance().procurar(CPF);
	}
	
	public void removerCliente(String CPF) throws ClienteNaoEncontradoException{
		clientes.getInstance().remover(CPF);
	}
	
	public void atualizarCliente(Cliente cliente) throws ClienteNaoEncontradoException{
		clientes.getInstance().atualizar(cliente);
	}
	
	public void cadastrarFilme(Filme filme) {
		filmes.getInstance().cadastrar(filme);
	}
	
	public Filme procurarFilme(String nome) throws CampoVazioException, FilmeNaoEncontradoException{
		return filmes.getInstance().procurar(nome);
	}
	
	public void removerFilme(String nome) throws CampoVazioException, FilmeNaoEncontradoException{
		filmes.getInstance().remover(nome);
	}
	
	public void atualizarFilme(Filme filme) throws CampoVazioException, FilmeNaoEncontradoException{
		filmes.getInstance().atualizar(filme);
	}
}