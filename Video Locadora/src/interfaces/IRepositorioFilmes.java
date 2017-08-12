package interfaces;
import negocio.Filme;
import excecoes.*;

public interface IRepositorioFilmes {

	public void inserir(Filme filme) throws FilmeExistenteException, FilmeNaoEncontradoException;
	public boolean existe(String nome) throws FilmeNaoEncontradoException;
	public Filme procurar(String nome) throws FilmeNaoEncontradoException;
	public void remover(String nome) throws FilmeNaoEncontradoException;
	public void atualizar(Filme filme) throws FilmeNaoEncontradoException;	
}
