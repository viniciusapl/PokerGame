import java.util.Arrays;
import java.util.Scanner;

public class Mesa {
    Scanner sc = new Scanner(System.in);
    private double apostaTotal;
    private double ultimaAposta;
    private int qtdJogadores = 10;
    Carta[] cartasComunitarias = new Carta[5];
    private Baralho baralho = new Baralho();

    public double getAposta() {
        return apostaTotal;
    }
    public void setAposta(double apostaTotal) {
        this.apostaTotal = apostaTotal;
    }
    public int getQtdJogadores(int qtdJogadores) {
        return this.qtdJogadores;
    }
    public void setQtdJogadores(int qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }

    Jogador[] mesa = new Jogador[qtdJogadores];
    public Mesa(){
        for(int i = 0; i < qtdJogadores; i++){
            Jogador player = new Jogador();
            player.setIndex(i);
            player.setNomeJogador("Jogador " + (i+1));
            mesa[i] = player;
        }
    }

    public void distribuirCartas(){
        baralho.embaralha();
        for(int i = 0; i < mesa.length; i++){
            Carta[] mao = baralho.darCartas();
            Jogador player = new Jogador();
            player.setMao(mao);
            mesa[i].setMao(player.getMao());
        }
    }

    public void imprimeMao(){
        for(int i = 0; i < qtdJogadores; i++){
            Jogador player = new Jogador();
            player = mesa[i];
            System.out.println("Mão do " + player.getNomeJogador());
            player.imprimeMao();
        }
    }

    public void imprimeCartasComunitarias(){
        String nomeCarta1 = cartasComunitarias[0].getNome();
        String naipeCarta1 = cartasComunitarias[0].getNaipe();
        String nomeCarta2 = cartasComunitarias[1].getNome();
        String naipeCarta2 = cartasComunitarias[1].getNaipe();
        String nomeCarta3 = cartasComunitarias[2].getNome();
        String naipeCarta3 = cartasComunitarias[2].getNaipe();
        String nomeCarta4 = cartasComunitarias[3].getNome();
        String naipeCarta4 = cartasComunitarias[3].getNaipe();
        String nomeCarta5 = cartasComunitarias[4].getNome();
        String naipeCarta5 = cartasComunitarias[4].getNaipe();
        System.out.printf("[%s%s][%s%s][%s%s][%s%s][%s%s]", nomeCarta1, naipeCarta1, nomeCarta2, naipeCarta2, nomeCarta3,naipeCarta3, nomeCarta4, naipeCarta4, nomeCarta5, naipeCarta5);
    }

    public double apostar(int index){
        System.out.print("Qual valor deseja apostar?");
        double novaAposta = sc.nextDouble();
        apostaTotal += novaAposta;
        ultimaAposta = novaAposta;
        mesa[index].setAposta(ultimaAposta);
        System.out.println("Apostado!");
        return novaAposta;
    }

    public void pagar(int index){
        apostaTotal += ultimaAposta;
        mesa[index].setAposta(ultimaAposta);
        System.out.printf("Você  apostou o valor de R$%.2f", ultimaAposta);
    }

    public void correr(int index){
        System.out.println("iiiih, correu kkkk");
        mesa[index] = null;
    }


    public double jogar(int jogador){
        System.out.printf("%nJogador %d que você vai querer?%n", (jogador + 1));
        System.out.println("1 - Apostar");
        System.out.println("2 - Pagar");
        System.out.println("3 - Correr");

        int resposta = sc.nextInt();
        double valorAposta = 0;

        switch (resposta){
            case 1:
                valorAposta = apostar(jogador);
                break;

            case 2:
                pagar(jogador);
                valorAposta = -1;
                break;

            case 3:
                correr(jogador);
                valorAposta = -2;
                break;

            default:
                System.out.println("Opção inválida!");
        }
        return valorAposta;
    }



    public void poker(){
        int cont = 0;
        double[] jogadas = new double[mesa.length];
        double acao = 0;
        double valorAposta = 0;

        jogadas[0] = 1;

        while(Arrays.stream(jogadas).distinct().count() != 1) {
            cont = 0;
            for (int i = 0; i < mesa.length; i++) {
                if (mesa[cont] == null) {
                    jogadas[cont] = valorAposta;
                    cont++;
                } else {
                    acao = jogar(cont);
                    if (acao != -2 && acao != -1) {
                        valorAposta += acao;
                    } else if (acao == -2) {
                        mesa[cont] = null;
                    }
                    jogadas[cont] = valorAposta;
                    cont++;
                }
            }
            System.out.printf("Total apostado: R$%.2f %n", apostaTotal);
        }

        cartasComunitarias = baralho.virarCartas();
        imprimeCartasComunitarias();

        System.out.printf("%nQual o número do jogador que ganhou????");
        int resposta = sc.nextInt();
        System.out.printf("%nParabéns jogador %d!!!!%nVocê ganhou R$%.2f", resposta, apostaTotal);

    }
}