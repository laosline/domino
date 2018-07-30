import java.util.Scanner;

public class Principal{
	public static void main(String[] args) {
		try{
		System.out.println("Iniciando jogo!\n\nDigite a opcao de jogo: \n0 - PVC\n1 - PVP\n");
		Scanner scan = new Scanner (System.in);
        int tipoDeJogo = scan.nextInt();
        Mesa mesa = new Mesa();
		int rodada = mesa.comecarJogo(tipoDeJogo);

		while(true){
			try{
			System.out.println("Rodada = "+rodada);
			mesa.jogada(rodada); 
			//rodada impar => vez do jogador 1
			//rodada par => vez do jogador 2
			rodada++;
			}catch(DeuErro e){
				System.out.println(e.passarVez());
				System.out.println(e.getNumPedras());
			}catch(JogadorRuim e){
				System.out.println(e.getMessage());
				System.out.print(e.getMessage1());
				System.out.println(e.getnumPedras());
				System.out.println(e.getMessage2());
				System.out.println(e.geterrada());
			}
		}
		}catch(Campeao e){
			System.out.print(e.getMessage());
			System.out.print(e.getCampeao());
			System.out.println(e.getMessage1());
			System.out.println(e.getMessage2());
		}
	}
	
}
