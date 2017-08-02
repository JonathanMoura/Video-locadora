package interfaces;
import negocio.Filme;

public interface IRepositorioFilmes {

	public void inserir(Filme filme);
	public boolean existe(String nome);
	public Filme procurar(String nome);
	public void remover(String nome);
	public void atualizar(Filme filme);	
}
