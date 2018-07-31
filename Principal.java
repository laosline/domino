import java.util.Scanner;

public class Principal{
	public static void main(String[] args) {
		try{
		System.out.println("Tutorial: Este é um jogo de Domino simples feito para dois jogadores, sendo possivel jogar contra outra pessoa ou contra o computador. No inicio, cada jogador ira comecar com 7 pedras que deverao ser jogadas de acordo com a Pedra Principal colocada na mesa, que representa as duas pontas.");
		System.out.println("O jogador que possuir a maior pedra de indices iguais inicia o jogo automaticamente. Caso nenhum dos jogadores possua um duplo, o jogo e iniciado aleatoriamente.");
		System.out.println("Em sua vez de jogar, voce podera selecionar uma pedra de sua mao que possua um dos valores iguais a um dos valores da Pedra Principal posta na mesa, ou comprar uma nova pedra, digitando o valor de sua escolha.");
		System.out.println("O jogo termina com a vitoria do jogador que esvaziar a mao, ou com empate, caso o pote fique vazio.\n");
		System.out.println("Iniciando jogo de DOMINO!\n");
		System.out.println("Digite a opcao de jogo: \n0 - PVC\n1 - PVP\n");
		Scanner scan = new Scanner (System.in);
        int tipoDeJogo = scan.nextInt();
        Mesa mesa = new Mesa();
		int rodada = mesa.comecarJogo(tipoDeJogo);

		while(true){
			try{
			mesa.jogada(rodada); 
			//rodada impar => vez do jogador 1
			//rodada par => vez do jogador 2
			rodada++;
			}catch(DeuErro e){
				System.out.println(e);
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
		}catch(DeuEmpate e){
			System.out.println(e.acabarJogo());
		}
	}
	
}
