package mc322.lab06.componentes;

import mc322.lab06.Caverna;

public class Brisa extends Componente {
    public Brisa(Caverna caverna, int x, int y) {
        super(caverna, x, y, 1, 'b');
    }
    public int verificaAcao(char tipo, int x, int y){ return 2; } // sobrescreve o padrão do verificaAcao, que retorna 0
}
