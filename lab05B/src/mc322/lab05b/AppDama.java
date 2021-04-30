package mc322.lab05b;

public class AppDama {
    public static String[] executaJogo(String caminhoEntrada, String caminhoSaida){
        CSVHandling csv = new CSVHandling();
        csv.setDataSource(caminhoEntrada);
        String[] commands = csv.requestCommands();
        int n = commands.length;
        String[] estadosVetor = new String[n+1];
        Tabuleiro tab = new Tabuleiro();
        System.out.println("Tabuleiro inicial:");
        tab.imprimirTabuleiro();
        estadosVetor[0] = tab.tabuleiroEmVetor();
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.println("Source: " + commands[i].substring(0, 2));
            System.out.println("Target: " + commands[i].substring(3, 5));
            tab.solicitaMovimento(commands[i]);
            tab.imprimirTabuleiro();
            estadosVetor[i+1] = tab.tabuleiroEmVetor();
            System.out.println();
        }
        tab.exportarArquivo(caminhoSaida);
        return estadosVetor;
    }
    public static void main(String[] args) {
        String caminhoEntrada = args[0];
        String caminhoSaida = args[1];
        String[] estados = executaJogo(caminhoEntrada, caminhoSaida);

    }
}

