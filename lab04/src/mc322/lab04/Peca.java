package mc322.lab04;

public class Peca {
    int posX, posY;
    boolean temPeca;


    Peca(int posY, int posX){

        this.posX = posX;
        this.posY = posY;
        temPeca = true;

    }


    void tirarPeca(){
        temPeca = false;

    }
    void colocarPeca(){
        temPeca = true;
    }

    char retornaPeca(){
        return (temPeca ? 'P' : '-');
    }
}
