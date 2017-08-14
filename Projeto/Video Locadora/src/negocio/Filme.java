package negocio;

public class Filme {
	private String nome;
	private String genero;
	private int quantia;
	private double valor;
	
	public Filme(){
		
	}
	
	public Filme(String nome, String genero, int quantia, double valor){
		this.nome = nome;
		this.genero = genero;
		this.quantia = quantia;
		this.valor = valor;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getGenero()
	{
		return this.genero;
	}
	
	public void setGenero(String genero)
	{
		this.genero = genero;
	}
	
	public int getQuantia()
	{
		return this.quantia;
	}
	
	public void setQuantia(int quantia)
	{
		this.quantia = quantia;
	}
	
	public double getValor()
	{
		return this.valor;
	}
	
	public void setValor(double valor)
	{
		this.valor = valor;
	}
}
