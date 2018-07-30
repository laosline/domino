import java.util.Random;

public class Pote extends Conjunto{

    public Pote() {
        setNumPedras(28);
        encherPote();
    }

    public void encherPote(){
        int posicao = 0;
        for (int i = 0; i < 7; i++){
            for (int j = i; j < 7; j++){
                vetorPedras[posicao] = new Pedra(i,j);
                posicao++;
            }
        }
    }
	
	public void mostrarQtdPedras(){
		if(getNumPedras() > 0) {	
			System.out.println("O pote possui " + getNumPedras() + " pedras.");
		}else{
			System.out.println("Pote vazio!!!");
		}
	}

    public Pedra vendePedra(){
		Random rand = new Random();
        int posicao = rand.nextInt(getNumPedras());
        Pedra pedraVendida = new Pedra (vetorPedras[posicao].getValor1(), vetorPedras[posicao].getValor2());
        retiraPedra(posicao);
        return pedraVendida;
    }
}