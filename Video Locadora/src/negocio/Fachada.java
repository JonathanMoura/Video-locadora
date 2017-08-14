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
		RepositorioFilmesArray repositorioFilmes = new RepositorioFilmesArray();
		clientes = new CadastroCliente(repositorioClientes);
		filmes = new CadastroFilme(repositorioFilmes);
	}
	
	public static Fachada getInstance(){
		if(instance == null)
			instance = new Fachada();
		return instance;
	}
	
	public void cadastrarCliente(Cliente cliente) throws CampoVazioException, ClienteExistenteException{
		clientes.getInstance().cadastrar(cliente);
	}
	
	public Cliente procurarCliente(String CPF) throws CampoVazioException, ClienteNaoEncontradoException{
		return clientes.getInstance().procurar(CPF);
	}
	
	public void removerCliente(String CPF) throws CPFVazioException, ClienteNaoEncontradoException{
		clientes.getInstance().remover(CPF);
	}
	
	public void atualizarCliente(Cliente cliente) throws CampoVazioException, ClienteNaoEncontradoException{
		clientes.getInstance().atualizar(cliente);
	}
	
	public void cadastrarFilme(Filme filme) throws CampoVazioException, FilmeExistenteException{
		filmes.getInstance().cadastrar(filme);
	}
	
	public Filme procurarFilme(String nome) throws CampoVazioException, FilmeNaoEncontradoException{
		return filmes.getInstance().procurar(nome);
	}
	
	public void removerFilme(String nome) throws NomeVazioException, FilmeNaoEncontradoException{
		filmes.getInstance().remover(nome);
	}
	
	public void atualizarFilme(Filme filme) throws CampoVazioException, FilmeNaoEncontradoException{
		filmes.getInstance().atualizar(filme);
	}
}