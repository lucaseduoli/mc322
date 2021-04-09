package mc322.lab03;

public class AquarioLombriga {
    int tamanhoAqua, tamanhoLomb, posicaoLomb, cabecaDireita;
    AquarioLombriga(int tamanhoAqua, int tamanhoLomb, int posicaoLomb){
        this.tamanhoAqua = tamanhoAqua;
        this.tamanhoLomb = tamanhoLomb;
        this.posicaoLomb = posicaoLomb;
        this.cabecaDireita = 1;
        if(this.tamanhoLomb > this.tamanhoAqua)
            this.tamanhoAqua = this.tamanhoLomb;
        if((this.posicaoLomb + this.tamanhoLomb - 1) > this.tamanhoAqua){
            posicaoLomb = 1;
        }
    }
    void crescer(){
        if(cabecaDireita == 1){
            if(posicaoLomb > 1)
                tamanhoLomb++;
                posicaoLomb--;
        } else {
            if(posicaoLomb + tamanhoLomb < tamanhoAqua){
                tamanhoLomb++;
            }
        }
    }
    void mover(){
        if(cabecaDireita == 1){
            if(posicaoLomb + tamanhoLomb <= tamanhoAqua)
                posicaoLomb++;
            else
                virar();
        } else {
            if(posicaoLomb > 1){
                posicaoLomb--;
            }
            else
                virar();
        }
    }
    void virar(){
        cabecaDireita = (cabecaDireita == 1 ? 0 : 1);
    }
    String apresenta(){
        int i;
        String aquario = "";
        for(i = 1; i < posicaoLomb; i++){
            aquario = aquario + "#";
        }
        if(cabecaDireita == 1){
            for(i = 1; i < tamanhoLomb; i++)
                aquario = aquario + "@";
            aquario = aquario + "O";
        } else {
            aquario = aquario + "O";
            for(i = 1; i < tamanhoLomb; i++)
                aquario = aquario + "@";
        }
        for(i = 1; i <= (tamanhoAqua - (posicaoLomb + tamanhoLomb - 1)) ; i++){
            aquario = aquario + "#";
        }
        return aquario;
    }
    
}
