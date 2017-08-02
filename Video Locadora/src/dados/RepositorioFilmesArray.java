package dados;
import negocio.Filme;
import interfaces.IRepositorioFilmes;

public class RepositorioFilmesArray implements IRepositorioFilmes{
	public static final int TAMANHO = 1000;
	private Filme[] repositorio;
	private int indice;
	
	public RepositorioFilmesArray(){
		repositorio = new Filme[TAMANHO];
		indice = 0;
	}
	
	public int getIndice(String nome){
		int i = 0;
		while(nome != repositorio[i].getNome()){
			if(i > indice){
				System.out.println("Indice não encontrado");
				return indice;
			}
			i++;
		}
		return i;
	}
	
	public void inserir(Filme filme){
		this.repositorio[indice] = filme;
		indice++;
	}
	
	public boolean existe(String nome){
		int i = getIndice(nome);
		if(repositorio[i] == null)
			return false;
		else
			return true;
	}
	
	public Filme procurar(String nome){
		if(existe(nome))
			return repositorio[getIndice(nome)];
		else{
			System.out.println("Filme não encontrado");
			return null;
		}
	}
	
	public void remover(String nome){
		if(existe(nome)){
			int i = getIndice(nome);
			repositorio[i] = null;
			repositorio[i] = repositorio[indice - 1];
			repositorio[indice - 1] = null;
			indice--;
		}
	}
	
	public void atualizar(Filme filme){
		String nome = filme.getNome();
		
		if(existe(nome))
			repositorio[getIndice(nome)] = filme;
		else
			System.out.println("Filme não cadastrado");
	}
}
