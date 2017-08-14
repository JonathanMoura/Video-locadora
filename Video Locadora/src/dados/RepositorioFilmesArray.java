package dados;
import negocio.Filme;
import interfaces.IRepositorioFilmes;

public class RepositorioFilmesArray implements IRepositorioFilmes{
	public static final int TAMANHO = 1000;
	private Filme[] repositorio;
	private int indice;
	private static RepositorioFilmesArray instance;
	
	public static RepositorioFilmesArray getInstance(){
		if(instance == null)
			instance = new RepositorioFilmesArray();
		
		return instance;
	}
	
	public RepositorioFilmesArray(){
		repositorio = new Filme[TAMANHO];
		indice = 0;
	}
	
	public int getIndice(String nome){
		int i = 0;
		if(indice == 0)
			return -1;
		while(!nome.equals(repositorio[i].getNome())){
			if(i >= indice){
				return indice;
			}
			i++;
			if(repositorio[i] == null)
				return -1;
		}
		return i;
	}
		
	public void inserir(Filme filme){
		this.repositorio[indice] = filme;
		indice++;
	}
	
	public boolean existe(String nome){
		int i = getIndice(nome);
		
		if(i == -1)
			return false;
		
		if(repositorio[i].getNome().equals(""))
			return false;
		else
			return true;
	}
	
	public Filme procurar(String nome){
		if(existe(nome))
			return repositorio[getIndice(nome)];
		return null;
	}
	
	public boolean remover(String nome){
		if(existe(nome)){
			int i = getIndice(nome);
			repositorio[i] = null;
			repositorio[i] = repositorio[indice - 1];
			repositorio[indice - 1] = null;
			indice--;
			return true;
		}
		else
			return false;
	}
	
	public boolean atualizar(Filme filme){
		String nome = filme.getNome();
		if(existe(nome)){
			repositorio[getIndice(nome)] = filme;
			return true;
		}else
			return false;
	}
}
