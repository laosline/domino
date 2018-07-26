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
		pedraEscolhida = scan.nextInt();
		
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
		if(principal.getValor1() == pedraNova.getValor1())
			principal.setValor1() = pedraNova.getValor2();
		if(principal.getValor1() == pedraNova.getValor2())
			principal.setValor1() = pedraNova.getValor1();
		if(principal.getValor2() == pedraNova.getValor1())
			principal.setValor2() = pedraNova.getValor2();
		if(principal.getValor2() == pedraNova.getValor2())
			principal.setValor2() = pedraNova.getValor1();
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


public Pedra Igual (Mao mao, Pedra referencia, int jogador) // funcao que faz a checagem se existe pedra igual e se ela eh a maior
	{
		Pedra ( referencia); // pega valor da pedra referencia (essa classe deixou de existir)
		for (int i=0; i< mao.numpedra;i++) // checa todas as pecas
			{
				Pedra ( mao.PedraMao[i]); // pega valor da pedra, nao existe mais essa funcao
				if( mao.PedraMao[i].valor1 == mao.PedraMao[i].valor2)  // verifica se os valores das pedras sao iguais
					{
						if(mao.PedraMao[i].valor1 > referencia.valor1)  // checa se o valor da pedra igual e melhor
							{
								referencia = setValor1 ( mao.PedraMao[i].valor1); 
								referencia = setValor2 ( mao.PedraMao[i].valor2); // atualiza valor da pedra referencia
							}
					}
			}

		return referencia;


	}

public Pedra Maior ( mao mao, pedra referencia, int jogador)
	{
		Pedra ( referencia); // pega valor da pedra referencia
		int maiorPedra = referencia.valor1 + referencia.valor2;
		for (int i=0; i< mao.numpedra;i++) // checa todas as pecas
			{
				Pedra ( mao.PedraMao[i]); // nao existe mais essa funcao, pega valor da pedra
				if( (mao.PedraMao[i].valor1 + mao.PedraMao[i].valor2) > maiorPedra)  // verifica se a peca e maior
					{
						referencia = setValor1 ( mao.PedraMao[i].valor1); 
						referencia = setValor2 ( mao.PedraMao[i].valor2);	
					}
			}

		return referencia;			
	
	}




public pedra PedraInicial( mao mao1, mao mao2)
	{
		Pedra PedraIgual;	//variavel que seleciona pedra
		pedraIgual = new Pedra();	// instancia objeto do tipo pedra
		pedraIgual = setValor1(-1);
		pedraIgual = setValor2(-1);   // inicia valor de pedra 
		int jogador = 0;		// variavel que vai dizer qual jogador comeca
		pedraIgual = Igual( mao1, PedraIgual, 1);	// chama funcao igual que verifica se existe peca com valores iguais da mao 1
 		pedraIgual = Igual ( mao2, PedraIgual, 2);
		if( PedraIgual.valor1 == -1)	//se nao achar peca igual, vai pra peca maior
			{
				PedraIgual = Maior (mao1, 1);
				Pedraigual = Maior (mao2, 2);
			}
		if ( jogador == 1)
			{
				RetiraPedra (mao1);
			}
		else if (jogador == 2)
			{
				RetiraPedra (mao2);
			}
		/// atualizar Peca principal, preciso ver como faz isso
	}
