public class SinglePote{
    	public static Pote instancia;
	protected SinglePote() {
    	}
 
    	public static Pote getPote() {
        	if (instancia == null)
        		instancia = new Pote();
        	return instancia;
    	}
}