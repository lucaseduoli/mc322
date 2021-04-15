package mc322.lab04;

public class Tabuleiro {
    Peca[][] matriz;

    Tabuleiro(){
        matriz = new Peca[7][7];
        for(int i = 0; i <= 6; i++){
            if(i < 2 || i > 4)
                for(int j = 0; j <= 6; j++){
                    if(j < 2 || j > 4)
                        matriz[i][j] = null;
                    else
                        matriz[i][j] = new Peca(i, j);
                }
            else
                for(int j = 0; j <= 6; j++)
                    matriz[i][j] = new Peca(i, j);
        }
        matriz[3][3].tirarPeca();
    }
    String transformaMatriz(){
        String matrizStr = "";
        for(int i = 0; i <= 6; i++){
            for(int j = 0; j <= 6; j++){
                if(matriz[i][j] == null)
                    matrizStr = matrizStr + ' ';
                else
                    matrizStr = matrizStr + matriz[i][j].retornaPeca();
            }
            matrizStr = matrizStr + '\n';
        }
        return matrizStr;
    }
    void mostraMatriz(){
        for(int i = 0; i <= 6; i++){
            System.out.print(i+1);
            for(int j = 0; j <=6; j++){
                if(matriz[i][j] == null)
                    System.out.print("  ");
                else
                    System.out.print(" " + String.valueOf(matriz[i][j].retornaPeca()));
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g");
    }
    void executaComando(String comando){
        int inicioX = comando.charAt(0) - 'a';
        int inicioY = comando.charAt(1) - '1';
        int fimX = comando.charAt(3) - 'a';
        int fimY = comando.charAt(4) - '1';

        if(inicioX > 6 || inicioX < 0 || fimX > 6 || fimX < 0 || inicioY > 6 || inicioY < 0 || fimY > 6 || fimY < 0 ||
           matriz[inicioY][inicioX] == null || matriz[fimY][fimX] == null || !matriz[inicioY][inicioX].temPeca || matriz[fimY][fimX].temPeca){
            System.out.println("VOCÊ ULTRAPASSOU AS BORDAS, PRESTE ATENÇÃO !!!");
        } else{
            if(inicioX == fimX){
                if(Math.abs(inicioY-fimY) == 2){
                    int novoY = (Math.abs(inicioY+fimY)/2);
                    if(matriz[novoY][fimX].temPeca) {
                        matriz[inicioY][inicioX].tirarPeca();
                        matriz[novoY][fimX].tirarPeca();
                        matriz[fimY][fimX].colocarPeca();
                    } else
                        System.out.println("NÃO TEM PEÇA PARA COMER !!!");
                }
            } else if(inicioY == fimY){
                if(Math.abs(inicioX-fimX) == 2){
                    int novoX = (Math.abs(inicioX+fimX)/2);
                    if(matriz[fimY][novoX].temPeca) {
                        matriz[inicioY][inicioX].tirarPeca();
                        matriz[fimY][novoX].tirarPeca();
                        matriz[fimY][fimX].colocarPeca();
                    } else
                        System.out.println("NÃO TEM PEÇA PARA COMER !!!");
                }
            } else {
                System.out.println("VOCÊ NÃO PODE PULAR NA DIAGONAL !!!");
            }
        }
    }
}
