public class Usadas extends Conjunto {

	public Usadas() {
		setNumPedras(0);
	}

	public void mostrarUsadas(){
		System.out.println("Pedras Usadas: ");
		super.imprimePedras();
		System.out.print("A ultima pedra jogada foi ");
		vetorPedras[getNumPedras()-1].imprimePedra();
		System.out.println();
	}
}