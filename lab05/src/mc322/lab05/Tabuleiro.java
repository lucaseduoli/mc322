package mc322.lab05;

public class Tabuleiro {
    static Peao[][] peoes;
    static Dama[][] damas;

    Tabuleiro(){
        peoes = new Peao[8][8];
        damas = new Dama[8][8];
        for(int i = 0; i <= 7; i++){
            for(int j = 0; j <= 7; j += 2){
                damas[i][j] = new Dama('-', j, i);
                damas[i][j+1] = new Dama('-', j+1, i);
                if(i > 4 || i < 3){
                    if(i % 2 != 0){
                        peoes[i][j] = new Peao('-', j, i);
                        peoes[i][j+1] = new Peao((i > 4 ? 'p' : 'b'), j+1, i);
                    } else {
                        peoes[i][j] = new Peao((i > 4 ? 'p' : 'b'), j, i);
                        peoes[i][j+1] = new Peao('-', j+1, i);
                    }
                } else {
                    peoes[i][j] = new Peao('-', j, i);
                    peoes[i][j+1] = new Peao('-', j+1, i);
                }
            }
        }
    }
    String transformaMatriz(){
        String matrizStr = "";
        for(int i = 7; i >= 0; i--){
            for(int j = 0; j <= 7; j++){
                if((peoes[i][j].getEstado() == '-') && (damas[i][j].getEstado() == '-'))
                    matrizStr = matrizStr + '-';
                else
                    matrizStr = matrizStr + ((peoes[i][j].getEstado() == '-') ? damas[i][j].getEstado() : peoes[i][j].getEstado());
            }
            matrizStr = matrizStr + '\n';
        }
        return matrizStr;
    }
    void mostraMatriz(){
        for(int i = 7; i >= 0; i--){
            System.out.print(i+1);
            for(int j = 0; j <=7; j++){
                if((peoes[i][j].getEstado() == '-') && (damas[i][j].getEstado() == '-'))
                    System.out.print(" -");
                else
                    System.out.print(" " + ((peoes[i][j].getEstado() == '-') ? damas[i][j].getEstado() : peoes[i][j].getEstado()));
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
    void executaComando(String comando){
        int posXi = comando.charAt(0) - 'a';
        int posYi = comando.charAt(1) - '1';
        int posXf = comando.charAt(3) - 'a';
        int posYf = comando.charAt(4) - '1';
        int[] resposta;

        if(peoes[posYi][posXi].getEstado() != '-'){
            resposta = peoes[posYi][posXi].movimentoValido(posXf, posYf);
            if(resposta[0] != 0){
                if(resposta[0] == 1){
                    peoes[posYf][posXf].setEstado(peoes[posYi][posXi].getEstado());
                    peoes[posYi][posXi].setEstado('-');
                } else if(resposta[0] == 2){
                    int posYm = resposta[1];
                    int posXm = resposta[2];
                    peoes[posYf][posXf].setEstado(peoes[posYi][posXi].getEstado());
                    peoes[posYi][posXi].setEstado('-');

                    if(peoes[posYm][posXm].getEstado() != '-') // se tiver peça no peoes
                        peoes[posYm][posXm].setEstado('-');
                    else
                        damas[posYm][posXm].setEstado('-');
                }
                if((peoes[posYf][posXf].getEstado() == 'b' && posYf == 7) || (peoes[posYf][posXf].getEstado() == 'p' && posYf == 0)){
                    damas[posYf][posXf].setEstado(Character.toUpperCase(peoes[posYf][posXf].getEstado()));
                    peoes[posYf][posXf].setEstado('-');
                }
            }

        } else if (damas[posYi][posXi].getEstado() != '-'){
            resposta = damas[posYi][posXi].movimentoValido(posXf, posYf);
            if(resposta[0] == 1){
                damas[posYf][posXf].setEstado(damas[posYi][posXi].getEstado());
                damas[posYi][posXi].setEstado('-');
            } else if(resposta[0] == 2){
                int posYm = resposta[1];
                int posXm = resposta[2];
                damas[posYf][posXf].setEstado(damas[posYi][posXi].getEstado());
                damas[posYi][posXi].setEstado('-');
                if(peoes[posYm][posXm].getEstado() != '-') // se tiver peça no peoes
                    peoes[posYm][posXm].setEstado('-');
                else
                    damas[posYm][posXm].setEstado('-');
            }
        }
    }
}
