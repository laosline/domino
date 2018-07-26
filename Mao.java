public class Mao extends Conjunto{

public class Mao extends Conjunto{
    private int maiorDuplo = -1;

    public Mao() {
        setNumPedras(0);
    }

    public void encontraMaiorDuplo (Pedra pedraComprada) {
        if (pedraComprada.getValor1() == pedraComprada.getValor2()) {
            maiorDuplo = pedraComprada.getValor1();
        }
    }

    public void compraPedra (Pedra pedraComprada){
        vetorPedras[numPedras] = pedraComprada;
        numPedras++;
    }

    public void compraPedraInicial (Pedra pedraComprada){
        compraPedra(pedraComprada);
        encontraMaiorDuplo(pedraComprada);
    }
}
