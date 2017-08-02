package negocio;
import interfaces.IRepositorioFilmes;

public class CadastroFilme {
	private IRepositorioFilmes cadastro;
	
	public CadastroFilme(IRepositorioFilmes repositorio){
		cadastro = repositorio;
	}
	
	public void cadastrar(Filme filme){
		if(filme != null){
			if(!cadastro.existe(filme.getNome())){
				cadastro.inserir(filme);
			}
			else
				System.out.println("Filme ja cadastrado");
		}
		else
			System.out.println("Filme já cadastrado");
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
