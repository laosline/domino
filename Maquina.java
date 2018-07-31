import java.util.*;

public class Maquina {
    int i;
    int escolha[] = new int[28];
    int numero=0;
    int escolhido=-1;
    Random rand = new Random();

    public int selecionar (Mao maoDaMaquina, Pedra principal)
    {
        numero=0;
        for(i=0; i < maoDaMaquina.getNumPedras(); i++)
        {
            if( principal.getValor1()== maoDaMaquina.vetorPedras[i].getValor1() || // checa se a carta  e possivel
                    principal.getValor1() == maoDaMaquina.vetorPedras[i].getValor2() ||
                    principal.getValor2() == maoDaMaquina.vetorPedras[i].getValor1() ||
                    principal.getValor2() == maoDaMaquina.vetorPedras[i].getValor2() )
            {
                escolha[numero]= i;    // adiciona as cartas possiveis
                numero++;
            }
        }
        if (numero > 1)  //  se for maior que 1, retorna aleatoriamente
            {
        		escolhido = escolha[rand.nextInt(numero)];
            }
        if (numero == 0)
        {
        	escolhido = maoDaMaquina.getNumPedras(); // algum valor que sei que e impossivel e force ele comprar peca
        }
        if (numero == 1)
        {
        	escolhido = escolha[0];
        }
        return escolhido;
    }
}


