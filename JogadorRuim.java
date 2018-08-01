public class JogadorRuim extends Exception{
	int numPedras, errada;
	public JogadorRuim(int numPedras,int errada){
		this.numPedras=numPedras;
		this.errada=errada;
	}
	public String getMessage(){
		return "Voce digitou um numero de pedra inexistente";
	}
	public String getMessage1(){
		return "Era de 0 ate ";
	}
	public String getMessage2(){
		return "E voce digitou: ";
	}
	public int getNumPedras(){
		return numPedras;
	}
	public int getErrada(){
		return errada;
	}
}
