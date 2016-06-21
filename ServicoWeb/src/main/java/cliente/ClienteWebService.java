package cliente;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import modelo.EntidadeAdocao;
import service.Pessoa;

public class ClienteWebService {

	public static void main(String[] args) {		
		Client cli = ClientBuilder.newClient();
//		String st = cli.target("http://localhost:8080/ServicoWeb/resource/WebService/hello").request().get(String.class);
//		System.out.println(st);
//		
//		WebTarget target=cli.target("http://localhost:8080/ServicoWeb/resource/WebService/soma");
//		Integer soma=target.queryParam("valor1", 10).queryParam("valor2", 520).request().get(Integer.class);
//		System.out.println(soma);	
		
		
		List<Pessoa> lista = cli.target("http://localhost:8080/ServicoWeb/resource/WebService/listaString").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Pessoa>>() {});
			for(Pessoa c:lista){
				System.out.println("Nome: "+c.getNome());
			}
		System.out.println("Tamanho Lista: "+lista.size());
	
	}	
}
