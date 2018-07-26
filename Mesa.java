import abrirJanela;
import java.util.*;

public class Mesa {
	private Pedra principal;
	private Pote pote = new Pote();
	private Mao jogador1 = new Mao();
	private Mao jogador2 = new Mao();
	private int rodada;

	public int comecarJogo(){
		// checagem
		// setar o jogador da rodada (1 ou 2)
		return rodada;
	}
	
	public void jogada(int rodada){
		int pedraEscolhida;
		Scanner scan = new Scanner();
		
		this.rodada = rodada;
		mostrarMao();
		pedraEscolhida = Scan.nextInt();
		
		if(rodada%2 != 0){
			if (pedraEscolhida == jogador1.getNumePedras()+1)
				jogador1.compraPedra(pote.retiraPedra());
			inserirPedra(jogador1.vetorPedra[pedraEscolhida]);
			jogador1.retiraPedra(pedraEscolhida);
		} else if(rodada%2 == 0){
			if (pedraEscolhida == jogador2.getNumePedras()+1)
				jogador2.compraPedra(pote.retiraPedra());
			inserirPedra(jogador2.vetorPedra[pedraEscolhida]);
			jogador2.retiraPedra(pedraEscolhida);
		}	
	}
	
	public void inserirPedra(Pedra pedraNova){
		if(principal.getValor1 == pedraNova.getValor1)
			principal.setValor1 = pedraNova.getValor2;
		if(principal.getValor1 == pedraNova.getValor2)
			principal.setValor1 = pedraNova.getValor1;
		if(principal.getValor2 == pedraNova.getValor1)
			principal.setValor2 = pedraNova.getValor2;
		if(principal.getValor2 == pedraNova.getValor2)
			principal.setValor2 = pedraNova.getValor1;
		// caso contrario, jogada invalida
	}

	public Pedra getPrincipal (){
		return principal;
	}

	public void mostrarMao(){
		if(rodada != 0)
			abrirJanela.abrir(jogador1.imprimirMao());
		if(rodada == 0)
			abrirJanela.abrir(jogador2.imprimirMao());
	}
}
