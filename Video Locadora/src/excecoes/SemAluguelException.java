package excecoes;

public class SemAluguelException extends Exception{
	public String getMessage(){
		return "Não há filmes locados";
	}
}
