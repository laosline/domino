public class Mesa{
	private Pedra principal;
	private Pote pote = new Pote();
	private Mao jogador1 = new Mao();
	private Mao jogador2 = new Mao();
	
	public Pedra getPrincipal (){
		return principal;
	}

	public void clear();

	public void mostrarMao();
	
}

public void imprimePedra (Pedra pedra){
	System.out.println("[" + pedra.getValor1() + "|" + pedra.getValor2() + "]");
}