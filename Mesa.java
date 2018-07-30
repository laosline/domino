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
		return this.rodada;
	}
	
	public void jogada(int rodada) throws JogadorRuim,Campeao,DeuErro{
		int pedraEscolhida;
		Scanner scan = new Scanner(System.in);
		Pedra pedraComprada;
		
		System.out.print("[Pedra Principal] => ");
		principal.imprimePedra();
		System.out.println("\n");
		this.rodada = rodada;
		
		if(rodada%2 != 0){
			boolean jogadaInvalida = true;
			while (jogadaInvalida){
				usadas.mostrarUsadas();
				jogador2.qtdPedrasAdversario();
				pote.mostrarQtdPedras();
				jogador1.mostrarMao(1);
				pedraEscolhida = scan.nextInt();
				if (pedraEscolhida > jogador1.getNumPedras()) throw new JogadorRuim(jogador1.getNumPedras()+1,pedraEscolhida);
				else if (pedraEscolhida == jogador1.getNumPedras()){
					if (pote.numPedras == 0) throw new DeuErro();
					pedraComprada = pote.vendePedra();
					jogador1.compraPedra(pedraComprada);
					System.out.println("Pedra comprada!\n");
				}else if(pedraEscolhida < jogador1.getNumPedras()){
					jogadaInvalida = inserirPedra(jogador1.vetorPedras[pedraEscolhida]);
					if(jogadaInvalida == false){
						usadas.compraPedra(jogador1.vetorPedras[pedraEscolhida]);
						jogador1.retiraPedra(pedraEscolhida);
						clear();
					}
				}
			}
			if(jogador1.getNumPedras()==0)throw new Campeao(rodada);
		} else if(rodada%2 == 0){
			boolean jogadaInvalida = true;
			while (jogadaInvalida){
				usadas.mostrarUsadas();
				jogador1.qtdPedrasAdversario();
				pote.mostrarQtdPedras();
				jogador2.mostrarMao(2);
				pedraEscolhida = scan.nextInt();
				if (pedraEscolhida > jogador2.getNumPedras()) throw new JogadorRuim(jogador2.getNumPedras()+1,pedraEscolhida);
				else if (pedraEscolhida == jogador2.getNumPedras()){
					if (pote.numPedras == 0) throw new DeuErro();
					pedraComprada = pote.vendePedra();
					jogador2.compraPedra(pedraComprada);
					System.out.println("Pedra comprada!\n");
				}
				else if(pedraEscolhida < jogador2.getNumPedras()){
					jogadaInvalida = inserirPedra(jogador2.vetorPedras[pedraEscolhida]);
					if (jogadaInvalida == false){
						usadas.compraPedra(jogador2.vetorPedras[pedraEscolhida]);
						jogador2.retiraPedra(pedraEscolhida);
						clear();
					}	
				}
			}
			if(jogador2.getNumPedras()==0)throw new Campeao(rodada);
		}	
	}
	
	public boolean inserirPedra(Pedra pedraNova){
		boolean jogadaInvalida = false;
		if(principal.getValor1() == pedraNova.getValor1()){
			this.principal.setValor1(pedraNova.getValor2());
		} else if(principal.getValor1() == pedraNova.getValor2()){
			this.principal.setValor1(pedraNova.getValor1());
		} else if(principal.getValor2() == pedraNova.getValor1()){
			this.principal.setValor2(pedraNova.getValor2());
		} else if(principal.getValor2() == pedraNova.getValor2()){
			this.principal.setValor2(pedraNova.getValor1());
		} else {
			jogadaInvalida = true;
			System.out.println("Jogada Invalida!\n");
		}
		return jogadaInvalida;
	}
	
	public void clear (){
		for(int i=0; i<30; i++)
		System.out.println("\n");
	}
	public Pedra getPrincipal (){
		return principal;
	}
	
}