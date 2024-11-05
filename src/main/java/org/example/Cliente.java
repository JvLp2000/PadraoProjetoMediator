package org.example;

public class Cliente {

    private String nome;
    private Aplicativo aplicativo;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void setAplicativo(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
    }

    public String getNome() {
        return nome;
    }

    public void enviarMensagem(String mensagem) {
        if (aplicativo != null) {
            System.out.println(nome + " (Cliente) enviou: " + mensagem);
            aplicativo.enviarMensagemParaAtendente(mensagem, this);
        } else {
            System.out.println("Aplicativo não disponível para enviar a mensagem.");
        }
    }

    public void receberMensagem(String mensagem, String remetente) {
        System.out.println(nome + " recebeu do atendente " + remetente + ": " + mensagem);
    }
}
