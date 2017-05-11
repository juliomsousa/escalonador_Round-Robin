package mock;

import principal.Processo;

// classe para simular o recebimento dos processos através de um arquivo
public class MockLeitorArquivo {

    //                Processo(PID, duracao, chegada, io)
    private int[] vetp1 = {2, 4, 6, 8};
    Processo p1 = new Processo("p1", 9, 10, vetp1);

    private int[] vetp2 = {5};
    Processo p2 = new Processo("p2", 10, 4, vetp2);

    private int[] vetp3 = {2};
    Processo p3 = new Processo("p3", 5, 0, vetp3);

    private int[] vetp4 = {3, 6};
    Processo p4 = new Processo("p4", 7, 1, vetp4);

    private int[] vetp5 = {};
    Processo p5 = new Processo("p5", 2, 17, vetp5);

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
