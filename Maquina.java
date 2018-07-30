import java.util.*;


public class Maquina {
            int i;
            int escolha[] = new int[28];
            int numero=0;
            int escolhido=-1;
            Random rand = new Random();
            Pedra pedracompre = new Pedra();
            
            public int selecionar (Mao maoDaMaquina, Pedra principal)
                    {
                          numero=-1;
                          for( i=0;i< maoDaMaquina.numPedras;i++)
                                  {
                                       if( principal.getValor1()== maoDaMaquina.vetorPedras[i].getValor1() || // checa se a carta  e possivel
                                          principal.getValor1()== maoDaMaquina.vetorPedras[i].getValor2() ||
                                          principal.getValor2() == maoDaMaquina.vetorPedras[i].getValor1() ||
                                          principal.getValor2() == maoDaMaquina.vetorPedras[i].getValor2() )
                                          {
                                                escolha[numero]= i;    ///adiciona as cartas possiveis
                                                numero++;
                                          }
                                   }
                           if( numero >1)  //  se for maior que 1, retorna aleatoriamente
                              escolhido =  rand.nextInt(numero) +1;
                           return escolhido;
                      }
    /*         public void PoteMaquina ( int numero2)
                    {
                       if( numero2 == -1)   //caso de 
                              {
                                  pedraCompre = pote.vendePedra();
                                  maoDaMaquina.compraPedra ( pedraCompre);
                                  System.out.println (" Pedra comprada!\n");
                              } 
                      }  */
}
                                       
