import java.util.*;

enum ResultadoJogada {
    LETRA_CORRETA,
    LETRA_INCORRETA,
    LETRA_JA_USADA
}

public class JogoDaForca {
    private Scanner scanner;
    private Forca forca;
    private boolean jogarNovamente;
    
    public JogoDaForca() {
        scanner = new Scanner(System.in);
        jogarNovamente = true;
    }
    
    public void iniciar() {
        exibirBoasVindas();
        
        while (jogarNovamente) {
            forca = new Forca();
            jogarPartida();
            perguntarSeQuerJogarNovamente();
        }
        
        exibirDespedida();
        scanner.close();
    }
    
    private void exibirBoasVindas() {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║              Bem vindo!            ║");
        System.out.println("║          Jogo da Forca Java        ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println();
    }
    
    private void jogarPartida() {
        while (!forca.isJogoTerminado()) {
            exibirEstadoAtual();
            processarJogada();
        }
        
        exibirResultadoFinal();
    }
    
    private void exibirEstadoAtual() {
        System.out.println("\n" + "=".repeat(50));
        forca.exibirForca();
        System.out.println();
        forca.exibirPalavraOculta();
        System.out.println();
        forca.exibirLetrasUsadas();
        System.out.println("Tentativas restantes: " + forca.getTentativasRestantes());
        System.out.println("=".repeat(50));
    }
    
    private void processarJogada() {
        System.out.print("\nDigite uma letra: ");
        String entrada = scanner.nextLine().toLowerCase().trim();
        
        if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
            System.out.println(" digite apenas uma letra válida!");
            return;
        }
        
        char letra = entrada.charAt(0);
        ResultadoJogada resultado = forca.tentarLetra(letra);
        
        switch (resultado) {
            case LETRA_CORRETA:
                System.out.println("A letra '" + letra + "' está na palavra!");
                break;
            case LETRA_INCORRETA:
                System.out.println("A letra '" + letra + "' não está na palavra.");
                break;
            case LETRA_JA_USADA:
                System.out.println("Você já tentou a letra '" + letra + "'!");
                break;
        }
    }
    
    private void exibirResultadoFinal() {
        System.out.println("\n" + "=".repeat(50));
        forca.exibirForca();
        System.out.println();
        
        if (forca.isVitoria()) {
            System.out.println("ganho");
            System.out.println("A palavra era: " + forca.getPalavraSecreta().toUpperCase());
        } else {
            System.out.println(" Its over...");
            System.out.println("A palavra era: " + forca.getPalavraSecreta().toUpperCase());
        }
        System.out.println("=".repeat(50));
    }
    
    private void perguntarSeQuerJogarNovamente() {
        System.out.print("\nDeseja jogar novamente? (s/n): ");
        String resposta = scanner.nextLine().toLowerCase().trim();
        jogarNovamente = resposta.equals("s") || resposta.equals("sim");
    }
    
    private void exibirDespedida() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("  ║        obrigado por jogar            ║");
        System.out.println("  ║                                      ║");
        System.out.println("  ╚══════════════════════════════════════╝");
    }
    
    public static void main(String[] args) {
        JogoDaForca jogo = new JogoDaForca();
        jogo.iniciar();
    }
}
