package negocio;

public class CelulaCliente {
	
	private CelulaCliente prox;
	private Cliente cliente;
	
	public CelulaCliente(CelulaCliente prox, Cliente cliente){
		this.prox = prox;
		this.cliente = cliente;
	}

	public CelulaCliente getProx() {
		return prox;
	}

	public void setProx(CelulaCliente prox) {
		this.prox = prox;
	}

	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
}
