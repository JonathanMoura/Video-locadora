package negocio;
import dados.RepositorioFilmesLista;
import excecoes.*;
import interfaces.IRepositorioFilmes;

public class CadastroFilme {
	private RepositorioFilmesLista cadastro;
	private static CadastroFilme instance;
	
	public static CadastroFilme getInstance(){
		if(instance == null)
			instance = new CadastroFilme();
		
		return instance;
	}
	public CadastroFilme(){
		
	}
	
	public CadastroFilme(RepositorioFilmesLista repositorio){
		cadastro = repositorio;
	}
	
	public void cadastrar(Filme filme) {
			cadastro.getInstance().inserir(filme);
	}
	
	public boolean existe(String nome) throws CampoVazioException, FilmeNaoEncontradoException{
		return cadastro.getInstance().existe(nome);
	}
	
	public Filme procurar(String nome) throws CampoVazioException, FilmeNaoEncontradoException{
		return cadastro.getInstance().procurar(nome);
	}
	
	public void remover(String nome) throws CampoVazioException, FilmeNaoEncontradoException{
		cadastro.getInstance().remover(nome);
	}
	
	public void atualizar(Filme filme) throws CampoVazioException, FilmeNaoEncontradoException{
		cadastro.getInstance().atualizar(filme);
	}
}
