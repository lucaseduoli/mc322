package mc322.lab06;

import mc322.lab06.componentes.*;

public class Caverna {
    private Sala[][] salas;

    public Caverna(){
        salas = new Sala[4][4];
        for (int i = 0; i <= 3; i++)
            for (int j = 0; j <= 3; j++)
                salas[i][j] = new Sala(j, i);
    }
    public int insereComponente(int posX, int posY, Componente componente){
        return salas[posY][posX].insereComponente(componente);
    }
    public char getPrimeiroComponente(int posX, int posY){
        return salas[posY][posX].getPrimeiroComponente();
    }
    public void removePrimeiroComponente(int posX, int posY){
        salas[posY][posX].removePrimeiroComponente();
    }
    public int executaMovimento(Componente heroi, int posXi, int posYi, int posXf, int posYf){
        int retorno = salas[posYf][posXf].insereComponente(heroi);
        if(retorno == 0)
            return 0;
        else {
            salas[posYi][posXi].removeHeroi();
            return retorno;
        }
    }
}
