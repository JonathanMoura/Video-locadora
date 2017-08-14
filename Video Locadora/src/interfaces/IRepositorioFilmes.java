package interfaces;
import negocio.Filme;

public interface IRepositorioFilmes {

	public void inserir(Filme filme);
	public boolean existe(String nome);
	public Filme procurar(String nome);
	public boolean remover(String nome);
	public boolean atualizar(Filme filme);	
}
