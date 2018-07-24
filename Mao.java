public class Mao {
    private Pedra[] vetorPedrasMao = new Pedra[28];
    private int numPedras;

    public Mao() {
        setNumPedras(0);
        compraInicial();
    }

    public void compraInicial(){
        for (int i = 0; i < 7; i++){
            compraPedra();
        }
    }

    public void compraPedra (){
        vetorPedrasMao[numPedras] = Pote.vendePedra();
        numPedras++;

    }
    public int getNumPedras() {
        return numPedras;
    }

    public void setNumPedras(int numPedras) {
        this.numPedras = numPedras;
    }
}
