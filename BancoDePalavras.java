import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class BancoDePalavras {
    private List<String> palavras;
    private Random random;
    
    public BancoDePalavras() {
        random = new Random();
        inicializarPalavras();
    }
    
    private void inicializarPalavras() {
        palavras = new ArrayList<>(Arrays.asList(
            "programacao", "computador", "algoritmo", "software", "hardware",
            "internet", "tecnologia", "desenvolvimento", "brksedu", "sistema",
            "codigo", "linguagem", "java", "python", "javascript",
            "banco", "dados", "abobora", "servidor", "PARALELEPIPEDO",
            "orochinho", "usuario"
        ));
    }
    
    public String obterPalavraAleatoria() {
        int indice = random.nextInt(palavras.size());
        return palavras.get(indice).toLowerCase();
    }
    
    public void adicionarPalavra(String palavra) {
        if (palavra != null && !palavra.trim().isEmpty()) {
            palavras.add(palavra.toLowerCase().trim());
        }
    }
    
    public int getTotalPalavras() {
        return palavras.size();
    }
}