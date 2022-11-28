public class Baralho {

    int totalCartas = 52;
    Carta[] cartas = new Carta[totalCartas];

    public Baralho() {

        String nomes[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String naipes[] = {"♦", "♠", "♥", "♣"};
        int cont = 0;

        for (int i = 0; i < naipes.length; i++) {
            for (int j = 0; j < nomes.length ; j++) {
                Carta carta = new Carta();
                carta.setNome(nomes[j]);
                carta.setNaipe(naipes[i]);

                cartas[cont] = carta;
                cont++;
            }
        }
    }

    public void imprimeBaralho(){
        int cont = 0;
        for (int i = 0; i < totalCartas; i++) {
            while(cartas[cont] == null){
                cont++;
            }
            System.out.print(cartas[cont].getNome());
            System.out.println(cartas[cont].getNaipe());
            cont++;
        }
    }

    public void embaralha() {
        for (int i=0 ; i < totalCartas; i++) {
            Carta aux = cartas[i];
            int proxima = (int)(Math.random() * totalCartas);
            cartas[i] = cartas[proxima];
            cartas[proxima] = aux;
        }
    }

    public Carta[] darCartas(){
        Carta[] mao = new Carta[2];
        int cont = 0;
        Carta aux;

        for(int i = 0; i < 2; i++){
            while(cartas[cont]==null){
                cont++;
            }
            aux = cartas[cont];
            mao[i] = aux;
            cartas[cont] = null;
        }
        return mao;
    }

    public Carta[] virarCartas(){
        Carta[] cartasParaMesa = new Carta[5];
        int cont = 0;
        Carta aux;

        for(int i = 0; i < 5; i++){
            while(cartas[cont]==null){
                cont++;
            }
            aux = cartas[cont];
            cartasParaMesa[i] = aux;
            cartas[cont] = null;
        }
        return cartasParaMesa;
    }


    public boolean temCarta() {
        boolean resposta = false;
        for (int i = 0; i < totalCartas; i++) {
            if (cartas[i] != null) {
                resposta = true;
            }
        }
        return resposta;
    }
}
