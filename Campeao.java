public class Campeao extends Exception{
	int jogador;
	public Campeao(int i){
		this.jogador = i;
	}
	public String getMessage(){
		return "O jogador ";
	}
	public String getMessage1(){
		return " ganhou o jogo";
	}
	public String getMessage2(){
		return "Parabéns Campeão!!!";
	}
	public int getCampeao(){
		if(jogador%2 != 0){
			return 1;
		}
		else {
			return 2;
		}
	}
}
