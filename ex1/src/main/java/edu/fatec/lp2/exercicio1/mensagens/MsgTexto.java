package edu.fatec.lp2.exercicio1.mensagens;

import edu.fatec.lp2.exercicio1.modelo.Contatinho;

public class MsgTexto extends Mensagem {

    private int numChar;

    public MsgTexto(Contatinho destinatario) {
        super(destinatario);
    }

    @Override
    public Mensagem sendMessage(String conteudo) {
        registrarEnvio(conteudo);
        this.numChar = conteudo.length(); // calculado a partir do texto enviado
        return this;
    }

    public int getNumChar() {
        return numChar;
    }

    @Override
    public String toString() {
        return cabecalho() + " | Texto: \"" + getConteudo() + "\" (" + numChar + " caracteres)";
    }
}
