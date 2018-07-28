import java.util.Random;

public class Pote extends Conjunto{
    protected Pedra[] vetorPedrasPote= new Pedra[28];
    private int numPedras;

    public Pote() {
        setNumPedras(28);
        encherPote();
    }



    public void encherPote(){
        int posicao = 0;
        for (int i = 0; i < 7; i++){
            for (int j = i; j < 7; j++){
                vetorPedrasPote[posicao] = new Pedra(i,j);
                System.out.println("Pedra Criada [" + posicao + "] " + i + " " + j);
                posicao++;
            }
        }
    }

    public Pedra vendePedra(){
	Random rand = new Random();
        int posicao = rand.nextInt(getNumPedras());
        Pedra pedraVendida = vetorPedrasPote[posicao];
        retiraPedra(posicao);
        return pedraVendida;
    }
}
