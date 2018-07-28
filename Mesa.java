import java.util.*;

public class Mesa{
	protected Pedra principal = new Pedra();
	protected Mao jogador1 = new Mao();
	protected Mao jogador2 = new Mao();
	private int rodada;
	Pote pote = SinglePote.getPote(); 

	public int comecarJogo(){
		
		for(int i = 0;i<7;i++){
			jogador1.compraPedraInicial();
			jogador2.compraPedraInicial();
		} 
		if(jogador1.maiorDuplo > jogador2.maiorDuplo){
			this.rodada = 1;
			principal.setValor1(jogador1.maiorDuplo);
			principal.setValor2(jogador1.maiorDuplo);
		}else if(jogador1.maiorDuplo < jogador2.maiorDuplo){
			this.rodada = 2;
			principal.setValor1(jogador2.maiorDuplo);
			principal.setValor2(jogador2.maiorDuplo);
		}else{
			Random rand = new Random();
        		this.rodada = rand.nextInt(1);
			if(rodada%2 != 0){
				principal.setValor1(jogador1.maiorDuplo);
				principal.setValor2(jogador1.maiorDuplo);
			} else 	if(rodada%2 == 0){
				principal.setValor1(jogador2.maiorDuplo);
				principal.setValor2(jogador2.maiorDuplo);
			}
		}
		// arrumar uma forma de tirar da mão do usuario o duplo
		return this.rodada;
	}
	
	public void jogada(int rodada){
		int pedraEscolhida;
		Scanner scan = new Scanner(System.in);
		Pedra pedraComprada;
		System.out.println("[Pedra Principal] => ["+principal.getValor1()+"|"+principal.getValor2()+"]");
		
		this.rodada = rodada;
		mostrarMao();
		pedraEscolhida = scan.nextInt();

		if(rodada%2 != 0){
			if (pedraEscolhida == jogador1.getNumPedras()+1){
				pedraComprada = pote.vendePedra();
				jogador1.compraPedra(pedraComprada);
			}
			inserirPedra(jogador1.vetorPedras[pedraEscolhida]);
			jogador1.retiraPedra(pedraEscolhida);
		} else if(rodada%2 == 0){
			if (pedraEscolhida == jogador2.getNumPedras()+1){
				pedraComprada = pote.vendePedra();
				jogador2.compraPedra(pedraComprada);
			}
			inserirPedra(jogador2.vetorPedras[pedraEscolhida]);
			jogador2.retiraPedra(pedraEscolhida);
		}	
		clear();
	}
	
	public void inserirPedra(Pedra pedraNova){
		if(principal.getValor1() == pedraNova.getValor1())
			principal.setValor1(pedraNova.getValor2());
		if(principal.getValor1() == pedraNova.getValor2())
			principal.setValor1(pedraNova.getValor1());
		if(principal.getValor2() == pedraNova.getValor1())
			principal.setValor2(pedraNova.getValor2());
		if(principal.getValor2() == pedraNova.getValor2())
			principal.setValor2(pedraNova.getValor1());
		// caso contrario, jogada invalida
	}
	
	public void clear (){
		for(int i=0; i<10; i++)
		System.out.println("\n");
	}
	public Pedra getPrincipal (){
		return principal;
	}

	public void mostrarMao(){
		int i;
		if(rodada != 0){
			for (i = 0;i<jogador1.numPedras;i++){
				jogador1.vetorPedras[i].imprimePedra();
			}
		} else 	
		if(rodada == 0){
			for (i = 0;i<jogador1.numPedras;i++){
				jogador1.vetorPedras[i].imprimePedra();
			}
		}
	}
}