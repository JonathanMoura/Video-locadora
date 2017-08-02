package negocio;

public class Celula {
	
	private Celula prox;
	private ContaAbstrata conta;
	
	public Celula(Celula prox, ContaAbstrata conta){
		this.prox = prox;
		this.conta = conta;
	}

	public Celula getProx() {
		return prox;
	}

	public void setProx(Celula prox) {
		this.prox = prox;
	}

	public ContaAbstrata getConta() {
		return conta;
	}
	
	public void setConta(ContaAbstrata conta){
		this.conta = conta;
	}
}
