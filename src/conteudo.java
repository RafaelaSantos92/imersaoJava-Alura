import javax.swing.plaf.BorderUIResource.TitledBorderUIResource;

public class conteudo {

    private final String titulo; 
    private final String urlimagem;


    public conteudo(String titulo, String urlimagem) {
        this.titulo = titulo;
        this.urlimagem = urlimagem;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getUrlimagem() {
        return urlimagem;
    } 
    
}
