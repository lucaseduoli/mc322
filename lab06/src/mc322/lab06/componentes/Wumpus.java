package mc322.lab06.componentes;

import mc322.lab06.Caverna;

public class Wumpus extends Componente {
    public Wumpus(Caverna caverna, int x, int y) {
        super(caverna, x, y, 4, 'W');
        for(int i = x-1; i <= x+1; i++)
            for(int j = y-1; j <= y+1; j++)
                if(i != x && j != y && i < 4 && j < 4 && i >= 0 && j>= 0) {
                    new Fedor(caverna, i, y); // no próprio construtor, o fedor é inserido na caverna
                    new Fedor(caverna, x, j);
                }
    }
}
