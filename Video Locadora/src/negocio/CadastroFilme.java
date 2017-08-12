package negocio;
import excecoes.*;
import interfaces.IRepositorioFilmes;

public class CadastroFilme {
	private IRepositorioFilmes cadastro;
	
	public CadastroFilme(IRepositorioFilmes repositorio){
		cadastro = repositorio;
	}
	
	public void cadastrar(Filme filme) throws FilmeExistenteException {
			cadastro.inserir(filme);
	}
	
	public boolean existe(String nome){
		return cadastro.existe(nome);
	}
	
	public Filme procurar(String nome){
		return cadastro.procurar(nome);
	}
	
	public void remover(String nome){
		cadastro.remover(nome);
	}
	
	public void atualizar(Filme filme){
		cadastro.atualizar(filme);
	}
}
