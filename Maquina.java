import java.util.*;

public class Maquina {
    private int escolha[] = new int[28];

    public int selecionar (Mao maoDaMaquina, Pedra principal)
    {
        int numero;
        int escolhido = -1;
        Random rand = new Random();
        numero = 0;
        for(int i = 0; i < maoDaMaquina.getNumPedras(); i++)
        {
            if (principal.getValor1()== maoDaMaquina.vetorPedras[i].getValor1() ||
                    principal.getValor1() == maoDaMaquina.vetorPedras[i].getValor2() ||
                    principal.getValor2() == maoDaMaquina.vetorPedras[i].getValor1() ||
                    principal.getValor2() == maoDaMaquina.vetorPedras[i].getValor2())
            {
                escolha[numero]= i;
                numero++;
            }
        }
        if (numero > 1)
            escolhido = escolha[rand.nextInt(numero)];
        else if (numero == 0)
            escolhido = maoDaMaquina.getNumPedras();
        if (numero == 1)
            escolhido = escolha[0];
        return escolhido;
    }
}


