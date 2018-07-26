public class PedraInicial {

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

}
