public class Pote {
    private Pedra[] vetorPedrasPote= new Pedra[28];
    private int numPedras;

    public Pote() {
        setNumPedras(28);
        encherPote();
    }



    public void encherPote(){
        int posicao = 0;
        for (int i = 0; i <= 6; i++){
            for (int j = i; j <= 6; j++){
                vetorPedrasPote[posicao] = new Pedra (i, j);
                System.out.println("Pedra Criada [" + posicao + "] " + i + " " + j);
                posicao++;
            }
        }
    }

    public void retiraPedra(int posicao){
        vetorPedrasPote[posicao] = vetorPedrasPote[numPedras-1];
        vetorPedrasPote[numPedras - 1] = null;
        numPedras--;
    }

    public Pedra vendePedra(){
        int posicao = (int)Math.random()*getNumPedras();
        Pedra pedraVendida = vetorPedrasPote[posicao];
        retiraPedra(posicao);
        return pedraVendida;
    }

    public int getNumPedras() {
        return numPedras;
    }

    public void setNumPedras(int numPedras) {
        this.numPedras = numPedras;
    }
}
