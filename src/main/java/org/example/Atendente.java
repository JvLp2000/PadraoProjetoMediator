package org.example;

public class Atendente {

    private String nome;
    private Aplicativo aplicativo;

    public Atendente(String nome) {
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
            System.out.println(nome + " (Atendente) enviou: " + mensagem);
            aplicativo.enviarMensagemParaCliente(mensagem, this);
        } else {
            System.out.println("Aplicativo não disponível para enviar a mensagem.");
        }
    }

    public void receberMensagem(String mensagem, String remetente) {
        System.out.println(nome + " recebeu do cliente " + remetente + ": " + mensagem);
    }
}
