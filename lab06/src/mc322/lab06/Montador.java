package mc322.lab06;
import mc322.lab06.componentes.*;

public class Montador {
    private Heroi heroi;
    private Caverna caverna;
    private int erro;
    Componente componente;
    public Montador(String caminhoEntrada){
        erro = 0;
        caverna = new Caverna();
        heroi = new Heroi(caverna);
        int[] qtds = new int[3];
        for(int qtd : qtds)
            qtd = 0;
        CSVHandling csv = new CSVHandling();
        csv.setDataSource(caminhoEntrada);
        String[][] commands = csv.requestCommands();
        for (int i = 0; i <= 15; i++) {
            if(Character.getNumericValue(commands[i][0].charAt(0)) <= 4 && Character.getNumericValue(commands[i][0].charAt(0)) >= 1 &&
                    Character.getNumericValue(commands[i][0].charAt(2)) <= 4 && Character.getNumericValue(commands[i][0].charAt(2)) >= 1) {
                if (commands[i][0].equals("1:1")) {
                    if (!commands[i][1].equals("P")) {
                        erro = 1;
                        break;
                    }
                }
                if (commands[i][1].equals("P")) {
                    if (!commands[i][0].equals("1:1")) {
                        erro = 1;
                        break;
                    }
                }
                if (commands[i][1].equals("W") && Character.getNumericValue(commands[i][0].charAt(0)) <= 4 && Character.getNumericValue(commands[i][0].charAt(0)) >= 1) {
                    componente = new Wumpus(caverna, (Character.getNumericValue(commands[i][0].charAt(2)) - 1), (Character.getNumericValue(commands[i][0].charAt(0)) - 1));
                    if (componente.getErro()) {
                        erro = 1;
                        break;
                    }
                    qtds[0]++;
                }
                if (commands[i][1].equals("B")) {
                    componente = new Buraco(caverna, (Character.getNumericValue(commands[i][0].charAt(2)) - 1), (Character.getNumericValue(commands[i][0].charAt(0)) - 1));
                    if (componente.getErro()) {
                        erro = 1;
                        break;
                    }
                    qtds[1]++;
                }
                if (commands[i][1].equals("O")) {
                    componente = new Ouro(caverna, (Character.getNumericValue(commands[i][0].charAt(2)) - 1), (Character.getNumericValue(commands[i][0].charAt(0)) - 1));
                    if (componente.getErro()) {
                        erro = 1;
                        break;
                    }
                    qtds[2]++;
                }
            } else {
                erro = 1;
                break;
            }
        }
        if(qtds[0] != 1 || (qtds[1] != 2 && qtds[1] != 3) || qtds[2] != 1){
            erro = 1;
        }

    }
    public Heroi getHeroi(){
        return heroi;
    }
    public int getErro(){
        return erro;
    }
}
