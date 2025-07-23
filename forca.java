import java.util.*;

public class Forca {
    private String palavraSecreta;
    private StringBuilder palavraOculta;
    private Set<Character> letrasUsadas;
    private int tentativasErradas;
    private final int MAX_TENTATIVAS = 6;
    private BancoDePalavras bancoPalavras;
    private DesenhoForca desenhoForca;
    
    public Forca() {
        bancoPalavras = new BancoDePalavras();
        desenhoForca = new DesenhoForca();
        letrasUsadas = new HashSet<>();
        tentativasErradas = 0;
        inicializarJogo();
    }
    
    private void inicializarJogo() {
        palavraSecreta = bancoPalavras.obterPalavraAleatoria();
        palavraOculta = new StringBuilder();
        
        for (int i = 0; i < palavraSecreta.length(); i++) {
            palavraOculta.append("_ ");
        }
    }
    
    public ResultadoJogada tentarLetra(char letra) {

        if (letrasUsadas.contains(letra)) {
            return ResultadoJogada.LETRA_JA_USADA;
        }
        
        letrasUsadas.add(letra);
        

        if (palavraSecreta.contains(String.valueOf(letra))) {
            revelarLetra(letra);
            return ResultadoJogada.LETRA_CORRETA;
        } else {
            tentativasErradas++;
            return ResultadoJogada.LETRA_INCORRETA;
        }
    }
    
    private void revelarLetra(char letra) {
        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra) {
                palavraOculta.setCharAt(i * 2, letra);
            }
        }
    }
    
    public void exibirForca() {
        desenhoForca.desenhar(tentativasErradas);
    }
    
    public void exibirPalavraOculta() {
        System.out.println("Palavra: " + palavraOculta.toString().toUpperCase());
    }
    
    public void exibirLetrasUsadas() {
        if (letrasUsadas.isEmpty()) {
            System.out.println("Letras usadas: nenhuma");
        } else {
            List<Character> letrasOrdenadas = new ArrayList<>(letrasUsadas);
            Collections.sort(letrasOrdenadas);
            System.out.println("Letras usadas: " + letrasOrdenadas.toString()
                .replace("[", "").replace("]", "").toUpperCase());
        }
    }
    
    public boolean isJogoTerminado() {
        return isVitoria() || isDerrota();
    }
    
    public boolean isVitoria() {
        return !palavraOculta.toString().contains("_");
    }
    
    public boolean isDerrota() {
        return tentativasErradas >= MAX_TENTATIVAS;
    }
    
    public int getTentativasRestantes() {
        return MAX_TENTATIVAS - tentativasErradas;
    }
    
    public String getPalavraSecreta() {
        return palavraSecreta;
    }
}