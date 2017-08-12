package negocio;

public class Filme {
	private String nome;
	private String genero;
	private int quantidade;
	private double valor;
	
	public Filme(){
		
	}
	
	public Filme(String nome, String genero, int quantidade, double valor){
		this.nome = nome;
		this.genero = genero;
		this.quantidade = quantidade;
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
	
	public int getQuantidade()
	{
		return this.quantidade;
	}
	
	public void setQuantidade(int quantidade)
	{
		this.quantidade = quantidade;
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
