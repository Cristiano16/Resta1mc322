//Cristiano Sampaio Pinheiro RA:256352
package app;

public class Main {
    public static void main(String[] args) {
        //Cria o tabuleiro de resta 1
        Tabuleiro resta1 = new Tabuleiro();
        //Imprime o estado inicial do tabuleiro
        System.out.println("Tabuleiro inicial");
        resta1.imprimir();    
        //Lê comandos e os tranforma em um vetor de strings
        CSVReader csv = new CSVReader();
        csv.setDataSource("/home/cristiano/Documents/resta.csv");
        String commands[] = csv.requestCommands();
        //Executa comandos no tabuleiro
        for(int i=0; i<commands.length; i++){
            resta1.movimento(commands[i]);
            //Encerra o loop caso o jogador ganhe
            if(Pecas.n==1)
                break;
        }
    }
}