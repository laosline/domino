public class Mao extends Conjunto {
    private int maiorDuplo = -1;
    private int maiorDuploIndice = -1;

    public Mao() {
        setNumPedras(0);
    }

    public void encontraMaiorDuplo (Pedra pedraComprada) {
        if (pedraComprada.getValor1() == pedraComprada.getValor2()) {
            if (pedraComprada.getValor1()>this.maiorDuplo)
                this.maiorDuplo = pedraComprada.getValor1();
        }
    }

    public void compraPedraInicial (int indice){
        Pote pote = SinglePote.getPote();
        Pedra pedraComprada = pote.vendePedra();
        int maior = this.maiorDuplo;

        compraPedra(pedraComprada);
        encontraMaiorDuplo(pedraComprada);
        if(this.maiorDuplo != maior){
            this.maiorDuploIndice = indice;
        }
    }

    public void qtdPedrasAdversario() {
        System.out.println("O outro jogador possui " + getNumPedras() + " pedras.");
    }

    public void mostrarMao(int numJogador){
        System.out.println("\nJogador " + numJogador + ": \nVoce tem " + getNumPedras() + " pedras.\n");
        System.out.println("Digite o numero da pedra que voce deseja jogar: \n");
        super.imprimePedras();
        System.out.println(getNumPedras()+" = Comprar nova Pedra.");
        System.out.println(getNumPedras()+1 +" = Passar a vez (funciona somente se o pote estiver vazio).\n");
    }

    public int getMaiorDuplo() {
        return maiorDuplo;
    }

    public void setMaiorDuplo(int maiorDuplo) {
        this.maiorDuplo = maiorDuplo;
    }

    public int getMaiorDuploIndice() {
        return maiorDuploIndice;
    }

    public void setMaiorDuploIndice(int maiorDuploIndice) {
        this.maiorDuploIndice = maiorDuploIndice;
    }
}
