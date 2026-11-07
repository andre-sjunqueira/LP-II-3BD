# LP II — Exercícios de POO em Java

Projeto único com os exercícios da disciplina, cada um em seu próprio pacote.

## Estrutura

```
src/main/java/edu/fatec/lp2/
├── exercicio1/
│   ├── app/        Main.java (classe executável)
│   ├── modelo/     Whatsapp.java, Contatinho.java
│   └── mensagens/  Mensagem.java (abstrata), MsgTexto.java, MsgAudio.java, MsgFoto.java
└── exercicio2/
    ├── app/        Main.java (classe executável)
    ├── modelo/     Supermercado.java, Produto.java
    └── compra/     Calculavel.java (interface), ItemCompra.java, ListaCompra.java
```

## Exercício 1 — Whatsapp

Como executar: abra o projeto na IDE (IntelliJ, Eclipse, NetBeans ou VS Code reconhecem o `pom.xml`) e rode `edu.fatec.lp2.exercicio1.app.Main`.

Pelo terminal, sem Maven:

```bash
javac -d out $(find src -name "*.java")
java -cp out edu.fatec.lp2.exercicio1.app.Main
```
