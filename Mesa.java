public class Mesa {
	private Pedra principal;
	private Pote pote = new Pote();
	private Mao jogador1 = new Mao();
	private Mao jogador2 = new Mao();
	private int rodada = 1;

	public void comecarJogo(){
		//checagem
		// setar o jogador da rodada (1 ou 2)
	}
	
	public void jogada(){
		mostrarMao();	
	}
	
	public Pedra getPrincipal (){
		return principal;
	}

	public void clear(){
		for(int i=0;i<10;i++)
			System.out.println("\n");
	}

	public void mostrarMao(){
		if(rodada == 1)
			abrirJanela.abrir(jogador1.imprimirMao());
		if(rodada == 2)
			abrirJanela.abrir(jogador2.imprimirMao());
	}
}