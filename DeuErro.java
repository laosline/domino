public class DeuErro extends Exception{
	private int numPedras;

	public DeuErro (int numPedras){
		this.numPedras = numPedras;
	}
		
	public String passarVez(){
		return "Para passar a vez, digite: ";
	}
		
	public int getNumPedras(){
		return numPedras;
	}
}
