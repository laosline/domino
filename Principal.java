public class Principal{
	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		int rodada = mesa.comecarJogo();

		while(true){	
			mesa.jogada(rodada); 
			//rodada impar => vez do jogador 1
			//rodada par => vez do jogador 2
			rodada++;
		}
	}
	
}