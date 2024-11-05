package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AplicativoTest {

    private Aplicativo aplicativo;
    private Cliente cliente;
    private Atendente atendente;

    // Variáveis para capturar a saída do console
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setup() {
        // Redireciona a saída padrão para o ByteArrayOutputStream
        System.setOut(new PrintStream(outputStreamCaptor));

        aplicativo = new Aplicativo();
        cliente = new Cliente("João");
        atendente = new Atendente("Maria");

        aplicativo.adicionarCliente(cliente);
        aplicativo.adicionarAtendente(atendente);
    }

    @AfterEach
    void tearDown() {
        // Restaura a saída padrão do console após cada teste
        System.setOut(originalOut);
    }

    @Test
    void clienteDeveEnviarMensagemParaAtendente() {
        String mensagemCliente = "Olá, preciso de ajuda com meu pedido.";

        cliente.enviarMensagem(mensagemCliente);

        // Verifica se a saída contém a mensagem esperada
        String respostaEsperada = "Maria recebeu do cliente João: " + mensagemCliente;
        assertTrue(outputStreamCaptor.toString().contains(respostaEsperada));
    }

    @Test
    void atendenteDeveEnviarMensagemParaCliente() {
        String mensagemAtendente = "Claro, em que posso ajudar?";

        atendente.enviarMensagem(mensagemAtendente);

        // Verifica se a saída contém a mensagem esperada
        String respostaEsperada = "João recebeu do atendente Maria: " + mensagemAtendente;
        assertTrue(outputStreamCaptor.toString().contains(respostaEsperada));
    }

    @Test
    void mensagemSemAtendenteDisponivel() {
        // Remove o atendente para simular indisponibilidade
        aplicativo = new Aplicativo(); // Novo aplicativo sem atendente
        Cliente novoCliente = new Cliente("Carlos");
        aplicativo.adicionarCliente(novoCliente);

        novoCliente.enviarMensagem("Alguém pode me ajudar?");

        String respostaEsperada = "Nenhum atendente disponível para receber a mensagem.";
        assertTrue(outputStreamCaptor.toString().contains(respostaEsperada));
    }

    @Test
    void mensagemSemClienteDisponivel() {
        // Remove o cliente para simular indisponibilidade
        aplicativo = new Aplicativo(); // Novo aplicativo sem cliente
        Atendente novoAtendente = new Atendente("Ana");
        aplicativo.adicionarAtendente(novoAtendente);

        novoAtendente.enviarMensagem("Bem-vindo! Como posso ajudar?");

        String respostaEsperada = "Nenhum cliente disponível para receber a mensagem.";
        assertTrue(outputStreamCaptor.toString().contains(respostaEsperada));
    }
}

