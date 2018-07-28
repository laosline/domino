public class Pedra
{
    private int valor1;
    private int valor2;

    public Pedra(int valor1, int valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public Pedra() { // utilizado apenas para a pedra principal ser inicializada
        this.valor1 = -1;
        this.valor2 = -1;
    }

    public void imprimePedra (){
        System.out.println("[" + getValor1() + "|" + getValor2() + "] ");
    }

    public int getValor1() {
        return valor1;
    }

    public void setValor1(int valor1) {
        this.valor1 = valor1;
    }

    public int getValor2() {
        return valor2;
    }

    public void setValor2(int valor2) {
        this.valor2 = valor2;
    }

}
