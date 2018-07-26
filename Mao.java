public class Mao extends Conjunto{

    public Mao() {
        setNumPedras(0);
        compraInicial();
    }

    public void compraInicial(){
        for (int i = 0; i < 7; i++){
            compraPedra();
        }
    }

    public void compraPedra (Pedra pedraComprada){
        vetorPedras[numPedras] = pedraComprada;
        numPedras++;
    }
}
