package edu.fatec.lp2.exercicio1.mensagens;

import edu.fatec.lp2.exercicio1.modelo.Contatinho;

public class MsgFoto extends Mensagem {

    private int tamanho; // em KB

    public MsgFoto(Contatinho destinatario, int tamanho) {
        super(destinatario);
        this.tamanho = tamanho;
    }

    @Override
    public Mensagem sendMessage(String conteudo) {
        registrarEnvio(conteudo);
        return this;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return cabecalho() + " | Foto: " + getConteudo() + " (" + tamanho + " KB)";
    }
}
