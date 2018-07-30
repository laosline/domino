

public class Maquina {
            int i;
            int escolha = new vetor();
            int numero=0;
            Random rand = new Random():
            Pedra pedracompre;
            
            public int selecionar (Mao maoDaMaquina, Pedra principal)
                    {
                          numero=-1;
                          for( i=0;i< maoDaMaquina.numPedra;i++)
                                  {
                                       if( principal.valor1== maoDaMaquina.vetorPedras[i].getValor1() || // checa se a carta  e possivel
                                          principal.valor1== maoDaMaquina.vetorPedras[i].getValor2() ||
                                          principal.valor2 == maoDaMaquina.vetorPedras[i].getvalor1() ||
                                          principal.valor2 == maoDaMaquina.vetorPedras[i].getvalor2() )
                                          {
                                                escolha[numero]= i;    ///adiciona as cartas possiveis
                                                numero++;
                                          }
                                   }
                           if( numero >1)  //  se for maior que 1, retorna aleatoriamente
                              return rand = rand.nextInt(numero) +1;
                      }
             public void PoteMaquina ( int numero2)
                    {
                       if( numero2 == -1)   //caso de 
                              {
                                  pedraCompre = pote.vendePedra();
                                  maoDaMaquina.compraPedra ( pedraCompre);
                                  System.out.println (" Pedra comprada!\n);
                              } 
                      }
}
                                       
