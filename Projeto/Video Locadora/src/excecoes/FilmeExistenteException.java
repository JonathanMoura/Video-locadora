package excecoes;

public class FilmeExistenteException extends Exception{
	public String getMessage(){
		return "Este filme j� est� cadastrado";
	}
}
