public class Conjunto{
    protected Pedra[] vetorPedras = new Pedra[28];
    protected int numPedras;

    public void retiraPedra(int posicao)throws DeuErro{
	if((numPedras - 1) == (-1)) throw new DeuErro();
        vetorPedras[posicao] = vetorPedras[numPedras-1];
        vetorPedras[numPedras - 1] = null;
        numPedras--;
    }

    public int getNumPedras() {
        return numPedras;
    }

    public void setNumPedras(int numPedras) {
        this.numPedras = numPedras;
    }
}
