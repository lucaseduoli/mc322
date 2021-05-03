package mc322.lab05;

public class Dama {
    private char estado;
    private int posX, posY;


    Dama(char estado, int posX, int posY){
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
        int[] resposta = new int[14];
        resposta[0] = 0;

        if((posX != posXf) && (posY != posYf) && (posXf < 8) && (posXf >= 0) && (posYf < 8) && (posYf >= 0) &&
          (Tabuleiro.peoes[posYf][posXf].getEstado() == '-') && (Tabuleiro.damas[posYf][posXf].getEstado() == '-')){
            resposta = checaDiagonal(posXf, posYf, resposta);
        }
        else{
            System.out.println("ERRADO: Ultrapassou as bordas ou ta querendo ir pra onde ja tem gente ou ta querendo andar de lado");
        }
        return resposta;

    }

    int[] checaDiagonal(int posXf, int posYf, int[] resposta){
        int diferencaX = (posXf - posX);
        int diferencaY = (posYf - posY);

        if(Math.abs(diferencaX) == Math.abs(diferencaY)){
            int incrementoX = ((diferencaX > 0) ? 1 : -1);
            int incrementoY = ((diferencaY > 0) ? 1 : -1);

            int posXatual = (posX + incrementoX), posYatual = (posY + incrementoY);
            int posXn = 0, posYn = 0;
            boolean temPeca = false;

            while(posXatual != posXf){
                if((Tabuleiro.peoes[posYatual][posXatual].getEstado() != '-') && (Character.toUpperCase(Tabuleiro.peoes[posYatual][posXatual].getEstado()) != estado) ||
                  (Tabuleiro.damas[posYatual][posXatual].getEstado() != '-') && (Tabuleiro.damas[posYatual][posXatual].getEstado() != estado)) {
                    if (!temPeca) {
                        temPeca = true;
                        posXn = posXatual;
                        posYn = posYatual;
                    } else {
                        System.out.println("ERRADO: Tem 2 peças no caminho");
                        return resposta;
                    }
                } else if((Character.toUpperCase(Tabuleiro.peoes[posYatual][posXatual].getEstado()) == estado) || (Tabuleiro.damas[posYatual][posXatual].getEstado() == estado)){
                    System.out.println("ERRADO: ta querendo comer amigo");
                    return resposta;
                }
                posXatual += incrementoX;
                posYatual += incrementoY;
            }
            if(temPeca == true){
                resposta[0] = 2;
                resposta[1] = posYn;
                resposta[2] = posXn;
            } else {
                resposta[0] = 1;
            }
        }
        return resposta;
    }
}




