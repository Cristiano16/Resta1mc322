package app;

public class Tabuleiro {
    //Cria uma matriz de paças
    private Pecas[][] tab;
    //Construtor para tabuleiro
    Tabuleiro(){
        //Define tamanho do tabuleiro
        tab = new Pecas[8][8];
        //Percorre a matriz posicionando a peça correta em cada posição
        int i, j;
        for(i = 0; i<8; i++){
            for(j = 0; j<8;j++){
                if(i==3 && j==4){
                    tab[i][j] = new Pecas(); 
                    tab[i][j].setPeca('-');
                }
                else if(j==0 && i!=7){
                    tab[i][j] = new Pecas(); 
                    tab[i][j].setPeca((char)(55-i));
                }
                else if(i==7 && j!=0){
                    tab[i][j] = new Pecas(); 
                    tab[i][j].setPeca((char)(96+j));
                }
                else if(i==2||i==3||i==4||j==3||j==4||j==5){
                    tab[i][j] = new Pecas(); 
                    tab[i][j].setPeca('P');
                }
                else {
                    tab[i][j] = new Pecas();
                    tab[i][j].setPeca(' ');
                }
            }
        }
    }
    //Metodo para execultar os movimentos no tabuleiro
    void movimento(String commands){
        //Converte os movimentos recebidos em coordenadas para a matriz
        int x1, x2, y1, y2;
        x1 = 7-((int)commands.charAt(1)-48);
        y1 = (int)commands.charAt(0)-96;
        x2 = 7-((int)commands.charAt(4)-48);
        y2 = (int)commands.charAt(3)-96;
        //Verifica se as peças nas coordenadas passadas respeitam as regras do jogo
        if(x1==x2 && Math.abs(y1-y2)==2 && tab[x1][y1].validaMovimento(tab[x1][((y1+y2)/2)], tab[x2][y2])){
            //Imprime o movimento que será realizado
            System.out.println("Source: "+ tab[7][y1].getPeca() + tab[(x1)][0].getPeca());
            System.out.println("Target: "+ tab[7][y2].getPeca() + tab[(x2)][0].getPeca());
            //Realiza troca das peças
            tab[x1][y1].setPeca('-');
            tab[x2][y2].setPeca('P');
            tab[x1][((y1+y2)/2)].setPeca('-');
            //Desconta uma peça do total de peças
            Pecas.n--;
            //Imprime o tabuleiro apos a modificação
            imprimir();
        }
        else if(y1==y2 && Math.abs(x1-x2)==2 && tab[x1][y1].validaMovimento(tab[((x1+x2)/2)][y1], tab[x2][y2])){
            //Imprime o movimento que será realizado
            System.out.println("Source: "+ tab[7][y1].getPeca() + tab[(x1)][0].getPeca());
            System.out.println("Target: "+ tab[7][y2].getPeca() + tab[(x2)][0].getPeca());
            //Realiza troca das peças
            tab[x1][y1].setPeca('-');
            tab[x2][y2].setPeca('P');
            tab[((x1+x2)/2)][y1].setPeca('-');
            //Desconta uma peça do total de peças
            Pecas.n--;
            //Imprime o tabuleiro apos a modificação
            imprimir();
        }
        //Trata os casos de um movimento na diagonal, tentar comer uma peça que já foi comida, tentar movimentar uma peça invalida ou ainda tentar comer mais de uma peça 
        else
            System.out.println("Movimento Inválido");
    }
    //Metodo para imprimir o tabuleiro
    void imprimir(){
        //Percorre a matriz imprimindo as peças
        int i, j;
        for(i = 0; i<8; i++){
            for(j = 0; j<8;j++){
                System.out.print(tab[i][j].getPeca() + "  ");
            }
            System.out.println("\n");
        }
        //Verificar se o jogador ganhou
        if(Pecas.n == 1)
        System.out.println("VICTORY ACHIEVED");
    }
}