package excecoes;

public class FilmeNaoEncontradoException extends Exception {
	public String getMessage(){
		return "Filme n�o encontrado";
	}
}
