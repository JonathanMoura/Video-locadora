package excecoes;

public class ClienteExistenteException extends Exception{
	public String getMessage(){
		return "Cliente já cadastrado";
	}
}
