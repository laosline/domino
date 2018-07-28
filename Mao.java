public class Mao extends Conjunto {
    protected int maiorDuplo = -1;

    public Mao() {
        setNumPedras(0);
    }

    public void encontraMaiorDuplo (Pedra pedraComprada) {
        if (pedraComprada.getValor1() == pedraComprada.getValor2()) {
		if (pedraComprada.getValor1()>this.maiorDuplo)
            		this.maiorDuplo = pedraComprada.getValor1();
        }
    }

    public void compraPedra (Pedra pedraComprada){
        vetorPedras[numPedras] = pedraComprada;
        numPedras++;
    }

    public void compraPedraInicial (){
	Pote pote = SinglePote.getPote(); 
	Pedra pedraComprada = pote.vendePedra();// pedras estão vindo vazias do pote
	compraPedra(pedraComprada);
        encontraMaiorDuplo(pedraComprada);
    }
}
