package mc322.lab06.componentes;

import mc322.lab06.Caverna;

public class Fedor extends Componente {
    public Fedor(Caverna caverna, int x, int y) {
        super(caverna, x, y, 2, 'f');
    }
    public int verificaAcao(char tipo, int x, int y){ return 2; }
}
