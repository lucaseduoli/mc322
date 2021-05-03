package mc322.lab05b;

public class Dama extends Peca {
    private char estado;
    private int posX, posY;


    public Dama(char estado, int posX, int posY){
        this.estado = estado;
        this.posX = posX; //Aqui é Letra
        this.posY = posY; //Aqui é o numero

    }

    public char getCor(){
        return estado;
    }

    public void setCor(char estado){
        this.estado = estado;
    }

    public int[] movimentoValido(int posXf, int posYf, Tabuleiro tab){
        int[] resposta = new int[14];
        resposta[0] = 0;

        if((posX != posXf) && (posY != posYf) && (posXf < 8) && (posXf >= 0) && (posYf < 8) && (posYf >= 0) &&
          (tab.getPeca(posXf,posYf) == '-')){
            resposta = checaDiagonal(posXf, posYf, resposta,tab);
        }
        return resposta;

    }

    private int[] checaDiagonal(int posXf, int posYf, int[] resposta, Tabuleiro tab){
        int diferencaX = (posXf - posX);
        int diferencaY = (posYf - posY);

        if(Math.abs(diferencaX) == Math.abs(diferencaY)){
            int incrementoX = ((diferencaX > 0) ? 1 : -1);
            int incrementoY = ((diferencaY > 0) ? 1 : -1);

            int posXatual = (posX + incrementoX), posYatual = (posY + incrementoY);
            int posXn = 0, posYn = 0;
            boolean temPeca = false;

            while(posXatual != posXf){
                if((tab.getPeca(posXatual, posYatual) != '-') && (Character.toUpperCase(tab.getPeca(posXatual, posYatual)) != estado)){
                    if (!temPeca) {
                        temPeca = true;
                        posXn = posXatual;
                        posYn = posYatual;
                    } else {
                        return resposta;
                    }
                } else if((Character.toUpperCase(tab.getPeca(posXatual,posYatual)) == estado)){
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
            posX = posXf;
            posY = posYf;
        }
        return resposta;
    }
}




