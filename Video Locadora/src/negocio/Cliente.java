package negocio;

public class Cliente {
	
	private String nome;
	private String CPF;
	private String RG;
	private String endereco;
	private String telefone;
	
	public Cliente()
	{
		
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
}
