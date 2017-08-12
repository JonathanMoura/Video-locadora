package negocio;

public class CelulaFilme {
	
	private CelulaFilme prox;
	private Filme filme;
	
	public CelulaFilme(){
		
	}
	
	public CelulaFilme(CelulaFilme prox, Filme filme){
		this.prox = prox;
		this.filme = filme;
	}

	public CelulaFilme getProx() {
		return prox;
	}

	public void setProx(CelulaFilme prox) {
		this.prox = prox;
	}

	public Filme getFilme() {
		return this.filme;
	}
	
	public void setFilme(Filme filme){
		this.filme = filme;
	}
}
