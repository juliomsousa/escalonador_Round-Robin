package mock;

import principal.Processo;

// classe para simular o recebimento dos processos através de um arquivo
public class MockLeitorArquivo {

    //                Processo(PID, duracao, chegada)
    Processo p1 = new Processo("p1", 5, 8);
    Processo p2 = new Processo("p2", 12, 0);
    Processo p3 = new Processo("p3", 10, 2);
    Processo p4 = new Processo("p4", 7, 10);
    Processo p5 = new Processo("p5", 9, 4);

    public MockLeitorArquivo(String endereco) {
        // receber endereço de arquivo de leitura
    }

    public Processo[] getProcessos() {
        Processo[] processos = lerArquivo();

        return processos;
    }

    //implementar metodo para ler arquivo e transforma-los em objetos
    private Processo[] lerArquivo() {
        Processo[] processos = {p1, p2, p3, p4, p5};

        return processos;
    }
}
