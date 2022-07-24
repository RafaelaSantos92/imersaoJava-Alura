import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

public static void main(String[] args) throws Exception {
		
	//IMDB
   //String url = "https://api.mocki.io/v2/549a5d8b/MostPopularMovies";
    //extratorDeConteudo extrator = new ExtratorDeConteudoImdb();

    //NASA
    String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
    extratorDeConteudo extrator = new extratorDeConteudoDaNasa();


	    	var http = new clienteHttp();
            String json = http.buscaDados(url);
        
	//exibir e manipular os dados 
    //extratorDeConteudoDaNasa extrator = new extratorDeConteudoDaNasa();
    List<conteudo> conteudos = extrator.extraiConteudos(json);
    var geradora = new geradoraDeFigurinhas();

        for (int i = 0; i < 3; i++){

                conteudo conteudo = conteudos.get(i);
   
                InputStream inputStream = new URL(conteudo.getUrlimagem()).openStream();
                String nomeArquivo ="saida/" + conteudo.getTitulo() + ".png";
   
                geradora.cria(inputStream, nomeArquivo);
                System.out.println(conteudo.getTitulo());
                System.out.println();
        }

     }
}

