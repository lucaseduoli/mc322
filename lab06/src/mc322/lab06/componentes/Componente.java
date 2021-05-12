package mc322.lab06.componentes;

import mc322.lab06.Caverna;

public class Componente {
    private Caverna caverna;
    private int posX, posY;
    private int prioridade;
    private char tipo;
    private boolean erro;
    public Componente(Caverna caverna, int x, int y, int prioridade, char tipo){
        this.posX = x;
        this.posY = y;
        this.caverna = caverna;
        this.prioridade = prioridade;
        this.tipo = tipo;
        if(caverna.insereComponente(x, y, this) == 0){
            erro = true;
        };
    }
    protected void setPosX(int x) { posX = x; }
    protected void setPosY(int y) { posY = y; }
    public int getPosX() { return posX; }
    public int getPosY() { return posY; }
    protected Caverna getCaverna() { return caverna; }
    public boolean getErro() { return erro; }
    public int getPrioridade(){
        return prioridade;
    }
    public char getTipo(){
        return tipo;
    }
    public int verificaAcao(char tipo, int x, int y){ return ((tipo == 'O' || tipo == 'B' || tipo == 'W') ? 0 : 2); }

}
