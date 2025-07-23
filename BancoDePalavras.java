class BancoDePalavras {
    private List<String> palavras;
    private Random random;
    
    public BancoDePalavras() {
        random = new Random();
        inicializarPalavras();
    }
    
    private void inicializarPalavras() {
        palavras = Arrays.asList(
            "programacao", "computador", "algoritmo", "software", "hardware",
            "internet", "tecnologia", "desenvolvimento", "aplicativo", "sistema",
            "codigo", "linguagem", "java", "python", "javascript",
            "banco", "dados", "rede", "servidor", "cliente",
            "interface", "usuario", "design", "web", "mobile",
            "inteligencia", "artificial", "machine", "learning", "cloud",
            "seguranca", "criptografia", "firewall", "antivirus", "backup",
            "framework", "biblioteca", "funcao", "variavel", "objeto",
            "classe", "heranca", "polimorfismo", "encapsulamento", "abstração",
            "compilador", "interpretador", "debugger", "teste", "qualidade"
        );
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

