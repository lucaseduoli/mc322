package mc322.lab03;

public class Animacao {
    AquarioLombriga lomb;
    String acoes;
    Animacao(String strAnim){
        lomb = new AquarioLombriga(Integer.parseInt(strAnim.substring(0, 2)), Integer.parseInt(strAnim.substring(2, 4)), Integer.parseInt(strAnim.substring(4, 6)));
        acoes = strAnim.substring(6, strAnim.length());
    }
    String apresenta(){
        return lomb.apresenta();
    }
    void passo(){
        char comando = acoes.charAt(0);
        if(comando != '\n'){
            switch (comando) {
                case 'C' : lomb.crescer(); break;
                case 'M' : lomb.mover(); break;
                case 'V' : lomb.virar(); break;
            }
            acoes = acoes.substring(1, acoes.length());
        }
    }
    
}