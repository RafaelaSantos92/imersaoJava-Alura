import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		// fazer uma conexão HTTP e buscar os top 250 filmes
		String url = "https://alura-imdb-api.herokuapp.com/movies";
		URI endereco = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		// extrair só os dados que interessam (título, poster, classificação)
        var parser = new JsonParser();
		List<Map<String, String>> listaDeFIlmes = parser.parse(body);
        
		//exibir e manipular os dados 
        for (Map<String,String> filme : listaDeFIlmes) {
            System.out.println("\u001b[1m\u001b[38;2;255;255;255m \u001b[48;2;42;122;228mTitle:\u001b[m " + filme.get("title"));
            System.out.println("\u001b[1m\u001b[38;2;255;255;255m \u001b[48;2;42;122;228mPoster:\u001b[m" + filme.get("image"));
            System.out.println("\u001b[1m\u001b[38;2;255;255;255m \u001b[48;2;42;122;228mRating:\u001b[m" + filme.get("imDbRating"));
            String stars = "";
            for (int i = 0; i < Float.parseFloat(filme.get("imDbRating")); i++){
                stars += "*";
            }
            System.out.println(stars);
            System.out.println("\n");

        }
	}

}
