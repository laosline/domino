public class Conjunto{
    protected Pedra[] vetorPedras = new Pedra[28];
    protected int numPedras;

    public void retiraPedra(int posicao){
        vetorPedras[posicao] = vetorPedras[numPedras-1];
        vetorPedras[numPedras - 1] = null;
        numPedras--;
    }
	
	
    public void compraPedra (Pedra pedraComprada){
        vetorPedras[numPedras] = new Pedra (pedraComprada.getValor1(), pedraComprada.getValor2());
        numPedras++;
    }
	
	public void imprimePedras(){
		for (int i = 0;i<getNumPedras();i++){
			System.out.print(i+" = ");
			vetorPedras[i].imprimePedra();
		}
	}

    public int getNumPedras() {
        return numPedras;
    }

    public void setNumPedras(int numPedras) {
        this.numPedras = numPedras;
    }
}
