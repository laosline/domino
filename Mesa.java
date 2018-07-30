import java.util.*;

public class Mesa{
	protected Pedra principal;
	protected Mao jogador1 = new Mao();
	protected Mao jogador2 = new Mao();
	protected Usadas usadas = new Usadas();
	private int rodada;
	Pote pote = SinglePote.getPote(); 

	public int comecarJogo(){
		clear();
		for(int i = 0;i<7;i++){
			jogador1.compraPedraInicial(i);		
			jogador2.compraPedraInicial(i);
		} 

		if(jogador1.maiorDuplo > jogador2.maiorDuplo){
			this.rodada = 2;
			principal = new Pedra(jogador1.maiorDuplo,jogador1.maiorDuplo);
			usadas.compraPedra(principal);
			jogador1.retiraPedra(jogador1.maiorDuploIndice);
			System.out.print("O jogador 1 iniciou o jogo com a pedra ");
			principal.imprimePedra();
		}else if(jogador1.maiorDuplo < jogador2.maiorDuplo){
			this.rodada = 1;
			principal = new Pedra(jogador2.maiorDuplo,jogador2.maiorDuplo);
			usadas.compraPedra(principal);
			jogador2.retiraPedra(jogador2.maiorDuploIndice);
			System.out.print("O jogador 2 iniciou o jogo com a pedra ");
			principal.imprimePedra();
		}else{
			Random rand = new Random();
        		this.rodada = rand.nextInt(2)+1;
			if(rodada%2 != 0){
				principal = new Pedra(jogador1.maiorDuplo,jogador1.maiorDuplo);
			} else 	if(rodada%2 == 0){
				principal = new Pedra(jogador2.maiorDuplo,jogador2.maiorDuplo);
			}
		}
		// arrumar uma forma de tirar da mao do usuario o duplo
		return this.rodada;
	}
	
	public void jogada(int rodada) throws JogadorRuim,Campeao{
		int pedraEscolhida;
		Scanner scan = new Scanner(System.in);
		Pedra pedraComprada;
		
		System.out.print("[Pedra Principal] => ");
		principal.imprimePedra();
		System.out.println("\n");
		this.rodada = rodada;

		if(rodada%2 != 0){
			usadas.mostrarUsadas();
			jogador2.qtdPedrasAdversario();
			pote.mostrarQtdPedras();
			jogador1.mostrarMao(1);
			pedraEscolhida = scan.nextInt();
			if (pedraEscolhida > jogador1.getNumPedras()+1) throw new JogadorRuim(jogador1.getNumPedras()+1,pedraEscolhida);
			if (pedraEscolhida == jogador1.getNumPedras()+1){ //NAO ESTOU CONSEGUINDO COMPRAR PEDRAS NOVAS
				pedraComprada = pote.vendePedra();
				jogador1.compraPedra(pedraComprada);
			}
			inserirPedra(jogador1.vetorPedras[pedraEscolhida]);
			usadas.compraPedra(jogador1.vetorPedras[pedraEscolhida]);
			jogador1.retiraPedra(pedraEscolhida); // A PEDRA EH RETIRADA DE QUALQUER JEITO, RETIRAR ELA DENTRO DO inserirPedra(Pedra);
			clear();
			if(jogador1.getNumPedras()==0)throw new Campeao(rodada);
		} else if(rodada%2 == 0){
			usadas.mostrarUsadas();
			jogador1.qtdPedrasAdversario();
			pote.mostrarQtdPedras();
			jogador2.mostrarMao(2);
			pedraEscolhida = scan.nextInt();
			if (pedraEscolhida > jogador2.getNumPedras()+1) throw new JogadorRuim(jogador2.getNumPedras()+1,pedraEscolhida);
			if (pedraEscolhida == jogador2.getNumPedras()+1){
				pedraComprada = pote.vendePedra();
				jogador2.compraPedra(pedraComprada);
			}
			inserirPedra(jogador2.vetorPedras[pedraEscolhida]);
			usadas.compraPedra(jogador2.vetorPedras[pedraEscolhida]);
			jogador2.retiraPedra(pedraEscolhida);
			clear();
			if(jogador2.getNumPedras()==0)throw new Campeao(rodada);
		}	
	}
	
	public void inserirPedra(Pedra pedraNova){
		if(principal.getValor1() == pedraNova.getValor1()){
			this.principal.setValor1(pedraNova.getValor2());
		} else if(principal.getValor1() == pedraNova.getValor2()){
			this.principal.setValor1(pedraNova.getValor1());
		} else if(principal.getValor2() == pedraNova.getValor1()){
			this.principal.setValor2(pedraNova.getValor2());
		} else if(principal.getValor2() == pedraNova.getValor2()){
			this.principal.setValor2(pedraNova.getValor1());
		}
		// caso contrario, jogada invalida
	}
	
	public void clear (){
		for(int i=0; i<30; i++)
		System.out.println("\n");
	}
	public Pedra getPrincipal (){
		return principal;
	}
	
}
