package excecoes;

public class CampoVazioException extends Exception{
	public String getMessage(){
		return "Preencha o campo vazio";
	}
}
