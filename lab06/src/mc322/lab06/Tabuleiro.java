package mc322.lab06;

public class Tabuleiro {
    private Pecas[][] pecas;
    private boolean erro, erroAtual;

    public Tabuleiro() {
        pecas = new Pecas[8][8];
        erro = false;
        for (int i = 0; i <= 7; i++)
            for (int j = 0; j <= 7; j += 2)
                if (i > 4 || i < 3) {
                    if (i % 2 != 0)
                        pecas[i][j + 1] = new Peao((i > 4 ? 'p' : 'b'), j + 1, i);
                    else
                        pecas[i][j] = new Peao((i > 4 ? 'p' : 'b'), j, i);
                }
    }

    public char getPeca(int x, int y){
        char estado;
        if (pecas[y][x] == null)
            estado = '-';
        else
            estado = pecas[y][x].getCor();

        return estado;
    }

    public String tabuleiroEmVetor(){
        String matrizStr = "";
        for(int i = 7; i >= 0; i--){
            for(int j = 0; j <= 7; j++){
                matrizStr = matrizStr + getPeca(j, i);
            }
            matrizStr = matrizStr + '\n';
        }
        return matrizStr;
    }
    public void imprimirTabuleiro(){
        if(erroAtual == false) {
            for (int i = 7; i >= 0; i--) {
                System.out.print(i + 1);
                for (int j = 0; j <= 7; j++) {
                    System.out.print(" " + getPeca(j, i));
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        } else {
            System.out.println("Movimento invalido!");
        }
    }
    public void solicitaMovimento(String comando){
        int posXi = comando.charAt(0) - 'a';
        int posYi = comando.charAt(1) - '1';
        int posXf = comando.charAt(3) - 'a';
        int posYf = comando.charAt(4) - '1';
        int[] resposta;
        erroAtual = false;

        if(getPeca(posXi, posYi) == '-'){
            resposta = new int[1];
            resposta[0] = 0;
        } else {
            resposta = pecas[posYi][posXi].movimentoValido(posXf, posYf, this);
        }
        if(resposta[0] != 0){
            if(resposta[0] == 1){
                pecas[posYf][posXf] = pecas[posYi][posXi];
                pecas[posYi][posXi] = null;
            } else if(resposta[0] == 2){
                int posYm = resposta[1];
                int posXm = resposta[2];
                pecas[posYf][posXf] = pecas[posYi][posXi];
                pecas[posYi][posXi] = null;
                pecas[posYm][posXm] = null;
            }
            if((getPeca(posXf, posYf) == 'b' && posYf == 7) || (getPeca(posXf, posYf) == 'p' && posYf == 0)){
                pecas[posYf][posXf] = new Dama(Character.toUpperCase(getPeca(posXf, posYf)), posXf, posYf);
            }
        } else {
            erro = true;
            erroAtual = true;
        }
    }
    public void exportarArquivo(String caminho){
        String[] estadoFinal;
        int letraASCII;
        char letra;
        int numero;
        String estadoAtual = "";
        if(erro == false) {
            estadoFinal = new String[64];
            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
                    letraASCII = 'a' + i;
                    numero = j + 1;
                    letra = (char) letraASCII;
                    estadoAtual = "" + letra + numero + (getPeca(i, j) == '-' ? "_" : getPeca(i, j));
                    estadoFinal[((i * 8) + j)] = estadoAtual;
                }
            }
        } else {
            estadoFinal = new String[1];
            estadoFinal[0] = "erro";
        }

        CSVHandling csv = new CSVHandling();
        csv.setDataExport(caminho);
        csv.exportState(estadoFinal);
    }
}
