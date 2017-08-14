package negocio;
import dados.*;
import excecoes.*;
import interfaces.IRepositorioFilmes;

public class CadastroFilme {
	private RepositorioFilmesArray cadastro;
	private static CadastroFilme instance;
	
	public static CadastroFilme getInstance(){
		if(instance == null)
			instance = new CadastroFilme();
		
		return instance;
	}
	public CadastroFilme(){
		
	}
	
	public CadastroFilme(RepositorioFilmesArray repositorio){
		cadastro = repositorio;
	}
	
	public void cadastrar(Filme filme) throws CampoVazioException, FilmeExistenteException{
		if(filme.getNome().equals("")){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		else if(filme.getGenero().equals("")){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		else if(filme.getQuantia() == 0){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		else if(filme.getValor() == 0){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		if(existe(filme.getNome())) {
			FilmeExistenteException e = new FilmeExistenteException();
			throw e;
		}
			cadastro.getInstance().inserir(filme);
	}
	
	public boolean existe(String nome) {
		return cadastro.getInstance().existe(nome);
	}
	
	public Filme procurar(String nome) throws CampoVazioException, FilmeNaoEncontradoException{
		Filme filme = new Filme();
		if(nome.equals("")){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		filme = cadastro.getInstance().procurar(nome);
		if(filme == null){
			FilmeNaoEncontradoException e = new FilmeNaoEncontradoException();
			throw e;
		}
		return filme;
	}
	
	public void atualizar(Filme filme) throws CampoVazioException, FilmeNaoEncontradoException{
		if(filme.getNome().equals("")){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		else if(filme.getGenero().equals("")){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		else if(filme.getQuantia() == 0){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		else if(filme.getValor() == 0){
			CampoVazioException e = new CampoVazioException();
			throw e;
		}
		if(!cadastro.getInstance().atualizar(filme)){
			FilmeNaoEncontradoException e = new FilmeNaoEncontradoException();
			throw e;
		}
	}
	
	public void remover(String nome) throws NomeVazioException, FilmeNaoEncontradoException{
		if(nome.equals("")){
			NomeVazioException e = new NomeVazioException();
			throw e;
		}
		if(!cadastro.getInstance().remover(nome)){
			FilmeNaoEncontradoException e = new FilmeNaoEncontradoException();
			throw e;
		}
	}
}
