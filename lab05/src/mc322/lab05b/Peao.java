package mc322.lab05b;

public class Peao extends Peca {
    private char estado;
    private int posX, posY;


    public Peao(char estado, int posX, int posY){
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
        int[] resposta = new int[3];
        resposta[0] = 0;
        int diferencaX = (posXf - posX);
        int diferencaY = (posYf - posY);

        if((posX != posXf) && (posY != posYf) && (posXf < 8) && (posXf >= 0) && (posYf < 8) && (posYf >= 0) &&
          (tab.getPeca(posXf,posYf) == '-')){
            if(Math.abs(diferencaX) == 2 && (Math.abs(diferencaY) == 2)){
                int posXm = ((posXf + posX)/2), posYm = ((posYf + posY)/2);
                if(((tab.getPeca(posXm,posYm) != '-') && (Character.toLowerCase(tab.getPeca(posXm,posYm)) != estado))){
                    resposta[0] = 2;
                    resposta[1] = posYm;
                    resposta[2] = posXm;
                    posX = posXf;
                    posY = posYf;
                }
            } else if (Math.abs(diferencaX) == 1 && (Math.abs(diferencaY) == 1) ) {
                if((diferencaY > 0 && estado == 'b') || (diferencaY < 0 && estado == 'p')) {
                    if ((tab.getPeca(posXf,posYf) == '-') && (tab.getPeca(posXf,posYf) == '-')) {
                        resposta[0] = 1;
                        posX = posXf;
                        posY = posYf;
                    }
                }
            }
        }
        return resposta;

    }







}
