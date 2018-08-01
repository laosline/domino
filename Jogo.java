public interface Jogo {
    public int comecarJogo(int tipoDeJogo);

    public void jogada(int rodada) throws JogadorRuim,Campeao,DeuErro;

    public boolean inserirPedra(Pedra pedraNova);

    public boolean passarVez();

    public void escolhaDaPedra (int pedraEscolhida, Mao jogador) throws JogadorRuim, Campeao, DeuErro;
   
    public Pedra getPrincipal();
}