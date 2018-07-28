public class Principal{
	public static void main(String[] args) {
		try{
		Mesa mesa = new Mesa();
		int rodada = mesa.comecarJogo();

		while(true){	
			mesa.jogada(rodada); 
			//rodada impar => vez do jogador 1
			//rodada par => vez do jogador 2
			rodada++;
		}
		}catch(JogadorRuim e){
		System.out.println(e.getMessage());
		System.out.print(e.getMessage1());
		System.out.println(e.getnumPedras());
		System.out.println(e.getMessage2());
		System.out.println(e.geterrada());
	}
	}
	
}
