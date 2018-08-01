public interface Jogo {

    int comecarJogo(int tipoDeJogo);

    void jogada(int rodada) throws JogadorRuim,Campeao,DeuErro;

    boolean inserirPedra(Pedra pedraNova);

    boolean passarVez();

    void escolhaDaPedra (int pedraEscolhida, Mao jogador) throws JogadorRuim, Campeao, DeuErro;

    Pedra getPrincipal();
}