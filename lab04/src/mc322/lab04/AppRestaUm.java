package mc322.lab04;

public class AppRestaUm {
    public static String[] executaJogo(String caminho){
        CSVReader csv = new CSVReader();
        csv.setDataSource(caminho);
        String commands[] = csv.requestCommands();
        int n = commands.length;
        String[] estados = new String[n+1];
        Tabuleiro tab = new Tabuleiro();
        System.out.println("Tabuleiro inicial:");
        tab.mostraMatriz();
        estados[0] = tab.transformaMatriz();
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.println("Source: " + commands[i].substring(0, 2));
            System.out.println("Target: " + commands[i].substring(3, 5));
            tab.executaComando(commands[i]);
            tab.mostraMatriz();
            estados[i+1] = tab.transformaMatriz();
            System.out.println();
        }
        return estados;
    }
    public static void main(String[] args) {
        String source = "db/arq001.csv";
        String[] estados = executaJogo(source);
        System.out.println("Vetores retornados pela função:");
        for(int i = 0; i < estados.length; i++){
            System.out.println(estados[i]);
        }

    }
}
