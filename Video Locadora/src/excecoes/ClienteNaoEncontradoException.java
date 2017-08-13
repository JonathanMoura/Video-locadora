package excecoes;

public class ClienteNaoEncontradoException extends Exception{
	public String getMessage(){
		return "Cliente não encontrado";
	}
}
