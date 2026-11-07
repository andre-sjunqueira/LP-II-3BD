package edu.fatec.lp2.exercicio1.modelo;

import edu.fatec.lp2.exercicio1.mensagens.Mensagem;
import edu.fatec.lp2.exercicio1.mensagens.MsgAudio;
import edu.fatec.lp2.exercicio1.mensagens.MsgFoto;
import edu.fatec.lp2.exercicio1.mensagens.MsgTexto;

/**
 * Correções de design em relação ao diagrama:
 * - "contatos : Contatinho" e "mensagens : Mensagem" viraram arrays
 *   (Contatinho[] e Mensagem[]), pois o Whatsapp guarda vários de cada.
 * - Relação com Contatinho é AGREGAÇÃO: o contato existe fora do Whatsapp
 *   e é apenas adicionado a ele.
 * - Relação com Mensagem é COMPOSIÇÃO: as mensagens são criadas pelo
 *   próprio Whatsapp (métodos enviarTexto/Audio/Foto) e só existem dentro dele.
 */
public class Whatsapp {

    private Contatinho[] contatos;
    private Mensagem[] mensagens;
    private int qtdContatos;
    private int qtdMensagens;

    /** Os arrays são inicializados aqui, no construtor, com a capacidade informada. */
    public Whatsapp(int capacidadeContatos, int capacidadeMensagens) {
        this.contatos = new Contatinho[capacidadeContatos];
        this.mensagens = new Mensagem[capacidadeMensagens];
        this.qtdContatos = 0;
        this.qtdMensagens = 0;
    }

    public boolean adicionarContato(Contatinho contato) {
        if (qtdContatos >= contatos.length) {
            System.out.println("Agenda cheia! Não foi possível adicionar " + contato.getNome());
            return false;
        }
        contatos[qtdContatos++] = contato;
        return true;
    }

    public Mensagem enviarTexto(Contatinho destinatario, String texto) {
        return guardar(new MsgTexto(destinatario).sendMessage(texto));
    }

    public Mensagem enviarAudio(Contatinho destinatario, String arquivo, int duracao) {
        return guardar(new MsgAudio(destinatario, duracao).sendMessage(arquivo));
    }

    public Mensagem enviarFoto(Contatinho destinatario, String arquivo, int tamanho) {
        return guardar(new MsgFoto(destinatario, tamanho).sendMessage(arquivo));
    }

    /**
     * Só é possível porque sendMessage() retorna a própria instância:
     * a mensagem é criada, enviada e guardada numa única linha.
     */
    private Mensagem guardar(Mensagem mensagem) {
        if (!ehContato(mensagem.getDestinatario())) {
            System.out.println("Erro: " + mensagem.getDestinatario().getNome() + " não está nos contatos.");
            return null;
        }
        if (qtdMensagens >= mensagens.length) {
            System.out.println("Caixa de mensagens cheia!");
            return null;
        }
        mensagens[qtdMensagens++] = mensagem;
        return mensagem;
    }

    private boolean ehContato(Contatinho contato) {
        for (int i = 0; i < qtdContatos; i++) {
            if (contatos[i] == contato) {
                return true;
            }
        }
        return false;
    }

    public void listarContatos() {
        System.out.println("=== Contatos (" + qtdContatos + ") ===");
        for (int i = 0; i < qtdContatos; i++) {
            System.out.println((i + 1) + ". " + contatos[i]);
        }
    }

    public void listarMensagens() {
        System.out.println("=== Mensagens (" + qtdMensagens + ") ===");
        for (int i = 0; i < qtdMensagens; i++) {
            System.out.println(mensagens[i]); // chama o toString() de cada subclasse (polimorfismo)
        }
    }
}
