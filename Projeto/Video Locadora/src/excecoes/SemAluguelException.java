package excecoes;

public class SemAluguelException extends Exception{
	public String getMessage(){
		return "N�o h� filmes locados";
	}
}
