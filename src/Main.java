import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int jogadores;

        try {
            System.out.println("*** Bem-vindo ao poker do CASSINÃO! ***");
            System.out.println("Quantos jogadores irão jogar? (Precisamos de 2 a 10 jogadores!)");
            jogadores = sc.nextInt();
            if(jogadores <= 1 || jogadores > 10){
                throw new Exception("Numero de jogadores invalido");
            }
            Mesa mesa = new Mesa();
            mesa.setQtdJogadores(jogadores);

            mesa.distribuirCartas();
            mesa.imprimeMao();

            mesa.poker();
        } catch (Exception e){
            System.out.println("Número de jogadores não pode ser menor que 2 ou maior que 10");
        }
    }
}