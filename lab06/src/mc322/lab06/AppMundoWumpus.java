package mc322.lab06;

public class AppMundoWumpus {
    public static void main(String[] args) {
        if(args.length == 1) {
            String caminhoEntrada = args[0];
            boolean reinicia;
            do {
                reinicia = false;
                Montador montador = new Montador(caminhoEntrada);
                if (montador.getErro() == 0) {
                    ControleJogo controle = new ControleJogo(montador.getHeroi());
                    if (controle.executaJogo() == 1) {
                        reinicia = true;
                        System.out.println();
                    }
                } else {
                    System.out.println("Erro na montagem da caverna! Cheque as regras do jogo e o .csv!");
                }
            } while (reinicia);
        } else {
            System.out.println("Digite um argumento válido na execução do programa!");
        }
    }
}
