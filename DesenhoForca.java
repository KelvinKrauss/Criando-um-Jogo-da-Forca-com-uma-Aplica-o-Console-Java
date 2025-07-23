public class DesenhoForca {
    private String[] estagios;
    
    public DesenhoForca() {
        inicializarDesenhos();
    }
    
    private void inicializarDesenhos() {
        estagios = new String[] {

            "   ┌─────┐\n" +
            "   │     │\n" +
            "   │      \n" +
            "   │      \n" +
            "   │      \n" +
            "   │      \n" +
            "───┴─────  ",
            
            "   ┌─────┐\n" +
            "   │     │\n" +
            "   │     ○\n" +
            "   │      \n" +
            "   │      \n" +
            "   │      \n" +
            "───┴─────  ",
            
            "   ┌─────┐\n" +
            "   │     │\n" +
            "   │     ○\n" +
            "   │     │\n" +
            "   │      \n" +
            "   │      \n" +
            "───┴─────  ",
            
            "   ┌─────┐\n" +
            "   │     │\n" +
            "   │     ○\n" +
            "   │    ╱│\n" +
            "   │      \n" +
            "   │      \n" +
            "───┴─────  ",
            
            "   ┌─────┐\n" +
            "   │     │\n" +
            "   │     ○\n" +
            "   │    ╱│╲\n" +
            "   │      \n" +
            "   │      \n" +
            "───┴─────  ",
            
            "   ┌─────┐\n" +
            "   │     │\n" +
            "   │     ○\n" +
            "   │    ╱│╲\n" +
            "   │    ╱ \n" +
            "   │      \n" +
            "───┴─────  ",
            
            "   ┌─────┐\n" +
            "   │     │\n" +
            "   │     o\n" +
            "   │    ╱│╲\n" +
            "   │    ╱ ╲\n" +
            "   │      \n" +
            "───┴─────  "
        };
    }
    
    public void desenhar(int estagio) {
        if (estagio >= 0 && estagio < estagios.length) {
            System.out.println(estagios[estagio]);
        }
    }
    
    public int getTotalEstagios() {
        return estagios.length;
    }
}