public class Mao extends Conjunto {
    protected int maiorDuplo = -1;
    protected int maiorDuploIndice = -1;

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
        vetorPedras[numPedras] = new Pedra (pedraComprada.getValor1(), pedraComprada.getValor2());
        numPedras++;
    }

    public void compraPedraInicial (int indice){
		Pote pote = SinglePote.getPote(); 
		Pedra pedraComprada = pote.vendePedra();
		int maior = this.maiorDuplo;

		compraPedra(pedraComprada);
        	encontraMaiorDuplo(pedraComprada);
		if(this.maiorDuplo != maior){
			this.maiorDuploIndice = indice;
		}
    }
}
