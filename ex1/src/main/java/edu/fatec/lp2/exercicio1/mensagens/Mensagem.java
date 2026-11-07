package edu.fatec.lp2.exercicio1.mensagens;

import edu.fatec.lp2.exercicio1.modelo.Contatinho;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe abstrata base de todas as mensagens.
 * Não pode ser instanciada diretamente: só MsgTexto, MsgAudio e MsgFoto.
 */
public abstract class Mensagem {

    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm:ss");

    private Contatinho destinatario;
    private String horaEnvio;
    private String conteudo;

    protected Mensagem(Contatinho destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * Envia a mensagem com o conteúdo informado.
     * Cada tipo de mensagem implementa do seu jeito, e todas devolvem
     * a própria instância (return this), o que permite encadear chamadas:
     * {@code Mensagem m = new MsgTexto(contato).sendMessage("Oi!");}
     */
    public abstract Mensagem sendMessage(String conteudo);

    /**
     * Correção de design: no diagrama é "toString(): void", mas em Java
     * toString() sobrescreve o método de Object e precisa retornar String.
     */
    @Override
    public abstract String toString();

    /**
     * Parte comum do envio, reaproveitada pelas subclasses:
     * guarda o conteúdo e registra a hora do envio.
     */
    protected void registrarEnvio(String conteudo) {
        this.conteudo = conteudo;
        this.horaEnvio = LocalTime.now().format(FORMATO_HORA);
    }

    /** Cabeçalho comum usado no toString() das subclasses. */
    protected String cabecalho() {
        return "[" + horaEnvio + "] Para " + destinatario.getNome();
    }

    public Contatinho getDestinatario() {
        return destinatario;
    }

    public String getHoraEnvio() {
        return horaEnvio;
    }

    public String getConteudo() {
        return conteudo;
    }
}
