package interfaces;
import negocio.Filme;
import excecoes.*;

public interface IRepositorioFilmes {

	public void inserir(Filme filme);
	public boolean existe(String nome) throws CampoVazioException, FilmeNaoEncontradoException;
	public Filme procurar(String nome) throws CampoVazioException, FilmeNaoEncontradoException;
	public void remover(String nome) throws CampoVazioException, FilmeNaoEncontradoException;
	public void atualizar(Filme filme) throws CampoVazioException, FilmeNaoEncontradoException;	
}
