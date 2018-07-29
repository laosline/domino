public class Campeao extends Exception{
	int jogador;
	public campeao(int i){
		this.jogador = i;
	}
	public String getMessage(){
		return "O jogador";
	}
	public String getMessage1(){
		return " ganhou o jogo";
	}
	public String getMessage2(){
		return "Parabéns Campeão!!!";
	}
	public double getCampeao(){
		if(jogador%2 != 0){
			return "1"
		}
		if(jogador%2 == 0){
			return "2"
		}
	}
}
