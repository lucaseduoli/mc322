package mc322.lab06.componentes;

import java.util.Random;
import mc322.lab06.Caverna;

public class Heroi extends Componente {
    private int qtdFlechas;
    private int qtdOuro;
    private boolean flechaEquipada;

    public Heroi(Caverna caverna){
        super(caverna, 0, 0, 3, 'P');
        qtdFlechas = 1;
        qtdOuro = 0;
        flechaEquipada = false;

    }

    public int getOuro(){ return qtdOuro; }
    public int getFlechas(){ return qtdFlechas; }
    public char getPrimeiroComponente(int x, int y) { return getCaverna().getPrimeiroComponente(x, y); }

    public int equipaFlecha(){
        if(qtdFlechas > 0) {
            flechaEquipada = true;
            qtdFlechas--;
            return 1;
        } else return 0;
    }
    private void desequipaFlecha(){ flechaEquipada = false; }

    public int achaOuro(){
        if(getCaverna().getPrimeiroComponente(getPosX(), getPosY()) == 'O'){
            qtdOuro++;
            getCaverna().removePrimeiroComponente(getPosX(), getPosY());
            return 1;
        }
        return 0;
    }

    public int[] executaMovimento(char movimento){
        int[] vetor = new int[3];
        int posXf = getPosX(), posYf = getPosY();
        if(movimento == 'w') {
            if (posYf - 1 >= 0)
                posYf--;
            else{
                vetor[0] = -1;
                return vetor;
            }
        } else if(movimento == 'a') {
            if (posXf - 1 >= 0)
                posXf--;
            else{
                vetor[0] = -1;
                return vetor;
            }
        } else if(movimento == 's') {
            if (posYf + 1 <= 3)
                posYf++;
            else{
                vetor[0] = -1;
                return vetor;
            }
        } else if(movimento == 'd') {
            if (posXf + 1 <= 3)
                posXf++;
            else{
                vetor[0] = -1;
                return vetor;
            }
        }
        int retorno = getCaverna().executaMovimento(this, getPosX(), getPosY(), posXf, posYf);
        if(retorno == 3)
            vetor[0] = 1;
        else if(retorno == 1)
            vetor[2] = 1;
        if(flechaEquipada){
            vetor[1] = 1;
            desequipaFlecha();
        }
        return vetor;
    }

    public int verificaAcao(char tipo, int x, int y){
        int resposta;
        Random aleatorio = new Random();
        int chance = aleatorio.nextInt(2);
        if(tipo == 'W')
            if (flechaEquipada) {
                if (chance == 1)
                    resposta = 1;
                else
                    resposta = 3;
            } else {
                resposta = 3;
            }
        else if(tipo == 'B'){
            resposta = 3;
        } else{
            resposta = 2;
        }
        setPosX(x);
        setPosY(y); //seta a nova posição
        return resposta;
    }
}
