package excecoes;

public class ClienteExistenteException extends Exception{
	public String getMessage(){
		return "Este cliente j� est� cadastrado";
	}
}
