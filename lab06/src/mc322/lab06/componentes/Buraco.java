package mc322.lab06.componentes;

import mc322.lab06.Caverna;

public class Buraco extends Componente {
    public Buraco(Caverna caverna, int x, int y) {
        super(caverna, x, y, 4, 'B');
        for(int i = x-1; i <= x+1; i++)
            for(int j = y-1; j <= y+1; j++)
                if(i != x && j != y && i < 4 && j < 4 && i >= 0 && j>= 0) {
                    new Brisa(caverna, i, y); // no próprio construtor, o fedor é inserido na caverna
                    new Brisa(caverna, x, j);
                }
    }
}
