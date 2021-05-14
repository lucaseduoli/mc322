package mc322.lab06;
import mc322.lab06.componentes.*;
import java.util.Scanner;

public class ControleJogo {
    private int qtdPontos;
    private Heroi heroi;
    private String player;
    private int[] vetor;


    public ControleJogo(Heroi heroi){
        qtdPontos = 0;
        this.heroi = heroi;
    }
    public int executaJogo(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Digite o nome do player:");
        player = keyboard.nextLine();
        imprimeEstado(0);
        char comando = keyboard.nextLine().charAt(0);

        while( comando != 'q'){
            if( comando == 'w' || comando == 'a' || comando == 's' || comando == 'd') {
                if(heroi.getPrimeiroComponente(heroi.getPosX(), heroi.getPosY()) != 'O') {
                    vetor = heroi.executaMovimento(comando);
                    if (vetor[0] != -1) {
                        qtdPontos -= 15;
                        if (vetor[0] == 1)
                            qtdPontos -= 1000;
                        if (vetor[1] == 1)
                            qtdPontos -= 100;
                        if (vetor[2] == 1)
                            qtdPontos += 500;
                    }
                    if (heroi.getPosX() == 0 && heroi.getPosY() == 0 && heroi.getOuro() > 0) {
                        qtdPontos += 1000;
                        vetor[0] = 2;
                    }
                    imprimeEstado(vetor[0]); //argumento indica se morreu ou não, se for 1, morreu, se for 0, não
                    if (vetor[0] == 1 || vetor[0] == 2) {
                        System.out.println();
                        System.out.println("Se quiser sair, digite 'q', do contrário, digite qualquer outro caractere.");
                        comando = keyboard.nextLine().charAt(0);
                        return (comando == 'q' ? 0 : 1);
                    }
                    if (vetor[2] == 1) {
                        System.out.println("Você matou o Wumpus!!!");
                    }
                } else {
                    imprimeEstado(0);
                    System.out.println("Você deve pegar o ouro antes de andar!");
                }
            } else if ( comando == 'k'){
                int retorno = heroi.equipaFlecha();
                imprimeEstado(0);
                if(retorno == 1)
                    System.out.println("Você equipou a flecha!");
                else
                    System.out.println("Você não possui flecha para equipar!");
            } else if ( comando == 'c'){
                if(heroi.achaOuro() == 1) {
                    imprimeEstado(0);
                    System.out.println("Você encontrou o ouro!");
                } else {
                    imprimeEstado(0);
                    System.out.println("Não tem ouro aqui!");
                }
            } else {
                System.out.println("Digite um comando válido!");
            }
            comando = keyboard.nextLine().charAt(0);
            }
        imprimeEstado(0);
        System.out.println("Volte sempre !");
        return 0;
    }
    private void imprimeEstado(int codigo){
        for (int i = 0; i <= 3; i++) {
            System.out.print(i + 1);
            for (int j = 0; j <= 3; j++) {
                System.out.print(" " + heroi.getPrimeiroComponente(j, i));
            }
            System.out.println();
        }
        System.out.println("  1 2 3 4");
        System.out.println();
        System.out.println("Player: " + player);
        System.out.println("Flechas: " + heroi.getFlechas());
        System.out.println("Ouros com o jogador: " + heroi.getOuro());
        System.out.println("Score: " + qtdPontos);
        if(codigo == 1){
            System.out.println("Voce perdeu =( ...");
        } else if (codigo == 2){
            System.out.println("Voce ganhou =D !!!");
        } else if (codigo == -1){
            System.out.println("Seu movimento ultrapassou as bordas!");
        }
    }

}
