package dados;
import interfaces.IRepositorioFilmes;
import negocio.Filme;
import negocio.CelulaFilme;

public class RepositorioFilmesLista implements IRepositorioFilmes {
	private CelulaFilme primeira;
	private CelulaFilme ultima;
	private int tamanho;
	private static RepositorioFilmesLista repositorioInstance;
	
	public static RepositorioFilmesLista getInstance(){
		if(repositorioInstance == null)
			repositorioInstance = new RepositorioFilmesLista();
		
		return repositorioInstance;
	}
	
	public RepositorioFilmesLista(){
		tamanho = 0;
	}
	
	public void inserir(Filme filme){
		CelulaFilme nova = new CelulaFilme(this.primeira,filme);
		this.primeira = nova;
		
		if(tamanho == 0)
			this.ultima = this.primeira;
		tamanho++;
	}
	
	public boolean existe(String nome){ 
		if(procurar(nome) != null)
			return true;
		else
			return false;
	}
	
	public Filme procurar(String nome){
		CelulaFilme atual = primeira;

		while(nome != atual.getFilme().getNome()){
			atual = atual.getProx();
			if(atual.getProx() == null)
				return null;
		}
		return atual.getFilme();
	}
	
	public void remover(String nome){
		if(existe(nome)){
			CelulaFilme atual = primeira;
			CelulaFilme anterior = null;
			while(nome != atual.getFilme().getNome()){
				anterior = atual;
				atual = atual.getProx();
			}
			anterior.setProx(atual.getProx());
			atual.setProx(null);
			
			if(anterior.getProx() == null)
				this.ultima = anterior;
		}
		else
			System.out.println("Filme não encontrado");
	}
	
	public void atualizar(Filme filme){
		String nome = filme.getNome();
		if(existe(nome)){
			CelulaFilme atual = primeira;
			while(nome != atual.getFilme().getNome())
				atual = atual.getProx();
			atual.setFilme(filme);
		}
		else
			System.out.println("Filme não encontrado");
	}
}
