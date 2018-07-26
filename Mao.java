public class Mao extends Conjunto{

    public Mao() {
        setNumPedras(0);
        compraInicial();
    }

    public void compraInicial(){
        for (int i = 0; i < 7; i++){
            compraPedraInicial();
        }
    }
    /** private int maiorDuplo = -1
        if (pedraComprada.getValor1() == pedraComprada.getValor2()){
                maiorDuplo = pedraComprada.getValor1();
        }**/
    public void compraPedra (Pedra pedraComprada){
        vetorPedras[numPedras] = pedraComprada;

        numPedras++;
    }
}
