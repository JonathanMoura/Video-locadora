package excecoes;

public class FilmeExistenteException extends Exception{
	public String getMessage(){
		return "Filme j� cadastrado";
	}
}
