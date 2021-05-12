package mc322.lab06;

import mc322.lab06.componentes.*;

public class Sala {
    private boolean visitado;
    private Componente[] componentes;
    private int posUltimaCasa;
    private int posX, posY;

    public Sala(int posX, int posY){
        componentes = new Componente[5];
        visitado = false;
        posUltimaCasa = -1;
        this.posX = posX;
        this.posY = posY;
    }

    public char getPrimeiroComponente(){
        if(componentes[0] == null) {
            return (visitado ? '#' : '-');
        } else {
            return (visitado ? componentes[0].getTipo() : '-');
        }
    }

    public int insereComponente(Componente componente){
        if (componente.getTipo() == 'P')
            visitado = true;
        if(componentes[0] != null){
            int retorno = componente.verificaAcao(componentes[0].getTipo(), posX, posY);
            if(retorno == 1){
                componentes[0] = componente;
            } else if(retorno == 2){
                posUltimaCasa++;
                componentes[posUltimaCasa] = componente;
                ordenaVetor();
            }
            return retorno;
        } else {
            componente.verificaAcao('-', posX, posY);
            posUltimaCasa++;
            componentes[posUltimaCasa] = componente;
            ordenaVetor();
            return 2;
        }
    }

    private void ordenaVetor(){
        if(componentes[0] != null && componentes[1] != null) {
            int maximo = 0;
            for (int i = 0; i <= posUltimaCasa; i++)
                if (componentes[i].getPrioridade() > componentes[maximo].getPrioridade())
                    maximo = i;
            Componente aux = componentes[0];
            componentes[0] = componentes[maximo];
            componentes[maximo] = aux;
        }
    }

    public void removeHeroi() {
        for(int i = 0; i <= 1; i++)
            if (componentes[i] != null && componentes[i].getTipo() == 'P') {
                if (componentes[i + 1] != null)
                    componentes[i] = componentes[posUltimaCasa];
                else
                    componentes[i] = null;
                break;
            }
        componentes[posUltimaCasa] = null;
        posUltimaCasa--;
        ordenaVetor();
    }
    public void removePrimeiroComponente() {
        if (componentes[0] != null) {
            if (componentes[1] != null)
                componentes[0] = componentes[posUltimaCasa];
            else
                componentes[0] = null;
            componentes[posUltimaCasa] = null;
            posUltimaCasa--;
            ordenaVetor();
        }
    }
}
