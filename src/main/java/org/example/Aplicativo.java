package org.example;

public class Aplicativo {

    private Cliente cliente;
    private Atendente atendente;

    public void adicionarCliente(Cliente cliente) {
        this.cliente = cliente;
        cliente.setAplicativo(this);
    }

    public void adicionarAtendente(Atendente atendente) {
        this.atendente = atendente;
        atendente.setAplicativo(this);
    }

    public void enviarMensagemParaAtendente(String mensagem, Cliente remetente) {
        if (atendente != null) {
            atendente.receberMensagem(mensagem, remetente.getNome());
        } else {
            System.out.println("Nenhum atendente disponível para receber a mensagem.");
        }
    }

    public void enviarMensagemParaCliente(String mensagem, Atendente remetente) {
        if (cliente != null) {
            cliente.receberMensagem(mensagem, remetente.getNome());
        } else {
            System.out.println("Nenhum cliente disponível para receber a mensagem.");
        }
    }
}
