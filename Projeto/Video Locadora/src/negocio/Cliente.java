package negocio;

public class Cliente {
	
	private String nome;
	private String CPF;
	private String RG;
	private String endereco;
	private String telefone;
	private String[] filmeAlugado;
	private String dataEntrega;
	
	public Cliente()
	{
		
	}
	
	public Cliente(String nome, String CPF, String RG, String endereco, String telefone){
		this.nome = nome;
		this.CPF = CPF;
		this.RG = RG;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getCPF()
	{
		return this.CPF;
	}
	
	public void setCPF(String CPF)
	{
		this.CPF = CPF;
	}
	
	public String getRG()
	{
		return this.RG;
	}
	
	public void setRG(String RG)
	{
		this.RG = RG;
	}
	
	public String getEndereco()
	{
		return this.endereco;
	}
	
	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}
	
	public String getTelefone()
	{
		return this.telefone;
	}
	
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}
	
	public String[] getFilmeAlugado()
	{
		return this.filmeAlugado;
	}
	
	public void setFilmeAlugado(String[] filmeAlugado)
	{
		this.filmeAlugado = filmeAlugado;
	}
	
	public String getDataEntrega()
	{
		return this.dataEntrega;
	}
	
	public void setDataEntrega(String dataEntrega)
	{
		this.dataEntrega = dataEntrega;
	}
}
