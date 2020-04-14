package app;

public class Pecas {
    //Mantem a contagem das peças
    static int n = 32;
    //Guarda o "tipo" da peça
    private char peca;
    
    public char getPeca(){
        return peca;
    }
    public void setPeca(char peca){
        this.peca = peca;
    }
    //valida movimento, recebe 2 peças e verifica as 3
    public boolean validaMovimento(Pecas p1, Pecas p2){
        if(p1.getPeca()=='P' && p2.getPeca()=='-'&& peca=='P')
            return true;
        else 
            return false;
    }
}