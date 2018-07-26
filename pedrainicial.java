public class pecainicial {

public Pedra igual (mao mao, pedra referencia, int jogador) // funcao que faz a checagem se existe pedra igual e se ela eh a maior
	{
		Pedra ( referencia); // pega valor da pedra referencia
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

public Pedra maior ( mao mao, pedra referencia, int jogador)
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




public pedra pedraInicial( mao mao1, mao mao2)
	{
		Pedra pedraIgual;	//variavel que seleciona pedra
		pedraIgual = new pedra();	// instancia objeto do tipo pedra
		pedraIgual = setValor1(-1);
		pedraIgual = setValor2(-1);   // inicia valor de pedra 
		int jogador = 0;		// variavel que vai dizer qual jogador comeca
		pedraIgual = igual( mao1, pedraIgual, 1);	// chama funcao igual que verifica se existe peca com valores iguais da mao 1
 		pedraIgual = igual ( mao2, pedraIgual, 2);
		if( pedraIgual.valor1 == -1)	//se nao achar peca igual, vai pra peca maior
			{
				pedraIgual = maior (mao1, 1);
				pedraigual = maior (mao2, 2);
			}
		if ( jogador == 1)
			{
				retiraPedra (mao1);
			}
		else if (jogador == 2)
			{
				retiraPedra (mao2);
			}
		/// atualizar Peca principal, preciso ver como faz isso
	}

}
