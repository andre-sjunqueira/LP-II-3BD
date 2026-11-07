package edu.fatec.lp2.exercicio1.mensagens;

import edu.fatec.lp2.exercicio1.modelo.Contatinho;

public class MsgAudio extends Mensagem {

    private int duracao; // em segundos

    public MsgAudio(Contatinho destinatario, int duracao) {
        super(destinatario);
        this.duracao = duracao;
    }

    @Override
    public Mensagem sendMessage(String conteudo) {
        registrarEnvio(conteudo);
        return this;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return cabecalho() + " | Áudio: " + getConteudo() + " (" + duracao + "s)";
    }
}
