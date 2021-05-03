package mc322.lab05;

public class Peao {
     private char estado;
     private int posX, posY;


    Peao(char estado, int posX, int posY){
        this.estado = estado;
        this.posX = posX; //Aqui é Letra
        this.posY = posY; //Aqui é o numero

    }

    char getEstado(){
        return estado;
    }

    void setEstado(char estado){
        this.estado = estado;
    }

    int[] movimentoValido(int posXf, int posYf){
        int[] resposta = new int[3];
        resposta[0] = 0;
        int diferencaX = (posXf - posX);
        int diferencaY = (posYf - posY);

        if((posX != posXf) && (posY != posYf) && (posXf < 8) && (posXf >= 0) && (posYf < 8) && (posYf >= 0) &&
          (Tabuleiro.peoes[posYf][posXf].getEstado() == '-') && (Tabuleiro.damas[posYf][posXf].getEstado() == '-')){
            if(Math.abs(diferencaX) == 2 && (Math.abs(diferencaY) == 2)){
                int posXm = ((posXf + posX)/2), posYm = ((posYf + posY)/2);
                if(((Tabuleiro.peoes[posYm][posXm].getEstado() != '-') && (Tabuleiro.peoes[posYm][posXm].getEstado() != estado)) ||
                   ((Tabuleiro.damas[posYm][posXm].getEstado() != '-') && (Character.toLowerCase(Tabuleiro.damas[posYm][posXm].getEstado()) != estado))){
                    resposta[0] = 2;
                    resposta[1] = posYm;
                    resposta[2] = posXm;
                } else {
                    System.out.println("ERRADO: você nao pode comer amigos ou vento");
                }

            } else if (Math.abs(diferencaX) == 1 && (Math.abs(diferencaY) == 1) ) {
                if((diferencaY > 0 && estado == 'b') || (diferencaY < 0 && estado == 'p')) {
                    if ((Tabuleiro.peoes[posYf][posXf].estado == '-') &&
                            (Tabuleiro.damas[posYf][posXf].getEstado() == '-')) {
                        resposta[0] = 1;
                    } else {
                        System.out.println("ERRADO: você nao pode entrar nos outros");
                    }
                } else {
                    System.out.println("ERRADO: você nao pode andar pro outro lado");
                }
            } else {
                System.out.println("ERRADO: você nao é dama");
            }
        }
        else{
            System.out.println("ERRADO: ultrapassou as bordas ou ta querendo ir pra onde ja tem gente ou ta querendo andar de lado");
        }
        return resposta;

    }







}
