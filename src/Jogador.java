public class Jogador {
    private String nomeJogador;
    private Carta[] mao = new Carta[2];
    private int index;
    private double aposta;


    public String getNomeJogador() {
        return nomeJogador;
    }
    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public Carta[] getMao() {
        return mao;
    }

    public void setMao(Carta[] mao) {
        this.mao[0] = mao[0];
        this.mao[1] = mao[1];
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public double getAposta() {
        return aposta;
    }

    public void setAposta(double aposta) {
        this.aposta = aposta;
    }

    public void imprimeMao() {
        System.out.print("[" + mao[0].getNome());
        System.out.print(mao[0].getNaipe() + "]");
        System.out.print("[" + mao[1].getNome());
        System.out.println(mao[1].getNaipe() + "]");
    }
}
