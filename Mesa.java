import java.util.*;

public class Mesa {
    private int rodada;
    private int tipoDeJogo;
    private int contadorEmpates = 0;
    private boolean jogadaInvalida;
    private Pedra principal;
    protected Mao jogador1 = new Mao();
    protected Mao jogador2 = new Mao();
    protected Usadas usadas = new Usadas();
    protected Maquina IA = new Maquina();
    protected Pote pote = SinglePote.getPote();

    public int comecarJogo(int tipoDeJogo){
        this.tipoDeJogo = tipoDeJogo;
        Scanner scan = new Scanner(System.in);
        int pedraEscolhida;
        clear();
        for(int i = 0;i<7;i++){
            jogador1.compraPedra(i);
            jogador2.compraPedra(i);
        }

        if(jogador1.getMaiorDuplo() > jogador2.getMaiorDuplo()){ // decide qual jogador comeca atraves do maior duplo na mao inicial
            this.rodada = 2;
            principal = new Pedra(jogador1.getMaiorDuplo(),jogador1.getMaiorDuplo()); // gera uma pedra principal atraves do maiorDuplo armazenado no Mao
            usadas.compraPedra(principal);
            jogador1.retiraPedra(jogador1.getMaiorDuploIndice()); // retira a pedra atrav�s do seu indice no vetor
            System.out.print("O jogador 1 iniciou o jogo com a pedra ");
            principal.imprimePedra();
        } else if(jogador1.getMaiorDuplo() < jogador2.getMaiorDuplo()){
            this.rodada = 1;
            principal = new Pedra(jogador2.getMaiorDuplo(),jogador2.getMaiorDuplo());
            usadas.compraPedra(principal);
            jogador2.retiraPedra(jogador2.getMaiorDuploIndice());
            System.out.print("O jogador 2 iniciou o jogo com a pedra ");
            principal.imprimePedra();
        } else{ // caso nenhum dos jogadores tenham duplos, eh decidido aleatoriamente (pior caso possivel, quase nunca acontece)
            Random rand = new Random();
            this.rodada = rand.nextInt(2)+1;
            if(rodada%2 != 0){
                semDuplos(jogador1);
            } else if(rodada%2 == 0){
                semDuplos(jogador2);
            }
        }
        return this.rodada;
    }

    public void jogada(int rodada) throws JogadorRuim,Campeao,DeuErro{
        int pedraEscolhida;

        Scanner scan = new Scanner(System.in);
        this.rodada = rodada; // rodada do Mesa eh atualizada de acordo com o rodada do Principal

        if(rodada%2 != 0){ // rodadas impares sao do jogador1
            jogadaInvalida = true;
            while (jogadaInvalida){
                usadas.mostrarUsadas(); // imprime as pedras retiradas pelos dois jogadores
                jogador2.qtdPedrasAdversario(); // imprime quantas pedras o adversario tem
                pote.mostrarQtdPedras(); // imprime quantas pedras sobraram no pote disponiveis para comprar
                System.out.print("\n[Pedra Principal] => ");
                principal.imprimePedra(); // imprime a pedra principal
                jogador1.mostrarMao(1); // imprime as pedras na mao do jogador
                pedraEscolhida = scan.nextInt(); // jogador decide qual pedra jogar
                escolhaDaPedra(pedraEscolhida, jogador1);
            }
            if(jogador1.getNumPedras()==0)throw new Campeao(rodada);
        } else if(rodada%2 == 0){ // rodadas pares sao do jogador2
            jogadaInvalida = true;
            while (jogadaInvalida){
                usadas.mostrarUsadas();
                jogador1.qtdPedrasAdversario();
                pote.mostrarQtdPedras();
                System.out.print("[Pedra Principal] => ");
                principal.imprimePedra(); // imprime a pedra principal
                jogador2.mostrarMao(2);
                if (tipoDeJogo == 0){
                    pedraEscolhida = IA.selecionar (jogador2, principal);
                    if(pedraEscolhida == jogador2.getNumPedras() && pote.getNumPedras()==0){
                        pedraEscolhida = jogador2.getNumPedras() + 1;
                    }
                }
                else {
                    pedraEscolhida = scan.nextInt();
                }
                escolhaDaPedra(pedraEscolhida, jogador2);
            }
            if(jogador2.getNumPedras()==0) throw new Campeao(rodada); // lanca o campeao
        }
    }

    public boolean inserirPedra(Pedra pedraNova){
        boolean jogadaInvalida = false;
        if (!(tipoDeJogo==0 && rodada%2==0)) {
            if ((principal.getValor1() == pedraNova.getValor1() && principal.getValor2() == pedraNova.getValor2()) || (principal.getValor1() == pedraNova.getValor2() && principal.getValor2() == pedraNova.getValor1())) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Digite o lado que voce deseja jogar a pedra: 0 = " + principal.getValor1() + "\n1 = " + principal.getValor2());
                int lado = scan.nextInt();
                if (lado == 0) {
                    if (principal.getValor1() == pedraNova.getValor1()) {
                        principal.setValor1(pedraNova.getValor2());
                    } else {
                        principal.setValor1(pedraNova.getValor1());
                    }
                    return jogadaInvalida;
                } else if (lado == 1) {
                    if (principal.getValor2() == pedraNova.getValor1()) {
                        principal.setValor2(pedraNova.getValor2());
                    } else {
                        principal.setValor2(pedraNova.getValor1());
                    }
                    return jogadaInvalida;
                } else {
                    jogadaInvalida = true;
                }

            }
        }
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

    public boolean passarVez(){
        if(rodada%2 != 0){
            System.out.println("Jogador 1 passou a vez!");

        } else {
            System.out.println("Jogador 2 passou a vez!");

        }
        this.rodada++;
        clear();
        this.contadorEmpates++;
        if(this.contadorEmpates>2) throw new DeuEmpate();
        return false;
    }

    public void clear (){
        for(int i=0; i<30; i++)
            System.out.println("\n");
    }

    public void escolhaDaPedra (int pedraEscolhida, Mao jogador) throws JogadorRuim, Campeao, DeuErro
    {
        jogadaInvalida = true;
        Pedra pedraComprada;
        if (pedraEscolhida > jogador.getNumPedras()+1) throw new JogadorRuim(jogador.getNumPedras()+1,pedraEscolhida); // caso o jogador digite um numero maior que o numero de Pedras, o jogo retorna um erro e faz com que ele jogue novamente
        else if (pedraEscolhida == jogador.getNumPedras()){ // caso o jogador digite um numero igual ao numPedras, ele compra pedra
            if (pote.getNumPedras() == 0) throw new DeuErro();
            pedraComprada = pote.vendePedra();// recebe uma pedra do Pote
            jogador.compraPedra(pedraComprada);// coloca essa pedra no Mao
            System.out.println("Pedra comprada!\n");
        } else if(pedraEscolhida < jogador.getNumPedras()){ // o jogador escolhe uma pedra para colocar na principal
            jogadaInvalida = inserirPedra(jogador.vetorPedras[pedraEscolhida]); // insere a pedra na mesa, substituindo a principal, retorna um boolean para caso a jogada seja inv�lida, ele repete a mesma jogada
            if(jogadaInvalida == false){ // jogada acaba se a jogada for v�lida
                usadas.compraPedra(jogador.vetorPedras[pedraEscolhida]);
                jogador.retiraPedra(pedraEscolhida);
                contadorEmpates = 0;
                clear();
            }
        } else if(pedraEscolhida == jogador.getNumPedras()+1){
            if(pote.getNumPedras() == 0){
                jogadaInvalida = passarVez();
            }
        }
    }

    public void semDuplos (Mao jogador){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nenhum dos jogadores possuem duplos, escolha um numero entre 0 e 7 para decidir qual pedra ira comecar: ");
        int pedraEscolhida = scan.nextInt();
        if (pedraEscolhida > jogador.getNumPedras());
        principal = jogador.vetorPedras[pedraEscolhida];
        jogador.retiraPedra(pedraEscolhida);
    }

    public Pedra getPrincipal (){
        return principal;
    }
}