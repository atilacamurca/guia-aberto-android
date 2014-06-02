package saudacao.app;

/* imports */

public class Requisicao {

	static InputStream instream;
	static JSONObject obj;
	static String resposta;
	private static final String URL = "http://10.0.2.2/contatos/index.php";
	
	public JSONObject obterResposta(String saudacao) {
      reset();
		enviar(saudacao);
		lerResposta();
		parseJSON();
		return obj;
	}
	
	private void enviar(String saudacao) {
		// enviar http request
	}
	
	private void lerResposta() {
		// ler resposta
	}
	
	private void parseJSON() {
		// cria json a partir da resposta
	}
   
   private void reset() {
		instream = null;
		obj = null;
		resposta = null;
	}
}