package edu.fatec.lp2.exercicio1.app;

import edu.fatec.lp2.exercicio1.modelo.Contatinho;
import edu.fatec.lp2.exercicio1.modelo.Whatsapp;

public class Main {

    public static void main(String[] args) {
        Whatsapp whatsapp = new Whatsapp(10, 50);

        Contatinho maria = new Contatinho("Maria", "(12) 99111-2222");
        Contatinho joao = new Contatinho("João", "(12) 99333-4444");
        Contatinho estranho = new Contatinho("Desconhecido", "(11) 90000-0000");

        whatsapp.adicionarContato(maria);
        whatsapp.adicionarContato(joao);

        whatsapp.enviarTexto(maria, "Oi, Maria! Tudo bem?");
        whatsapp.enviarAudio(joao, "audio_001.opus", 42);
        whatsapp.enviarFoto(maria, "foto_praia.jpg", 2048);
        whatsapp.enviarTexto(estranho, "Esse não deve ser enviado"); // não está nos contatos

        System.out.println();
        whatsapp.listarContatos();
        System.out.println();
        whatsapp.listarMensagens();
    }
}
