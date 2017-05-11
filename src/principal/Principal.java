package principal;

import leitorarquivo.LeitorArquivo;
import java.io.IOException;
import mock.MockLeitorArquivo;

public class Principal {

    public static void y(String[] args) {

        // ler arquivo de processos
        MockLeitorArquivo arquivo = new MockLeitorArquivo("abc");
        Processo[] p = arquivo.getProcessos();

        // passar os processos para o escalonador
        EscalonadorRoundRobin rr = new EscalonadorRoundRobin(p, 4);
        rr.getEscalonamento();
        // executar o escalonamento
        //exibir os resultados

    }

    public static void main(String[] args) throws IOException {

        // ler arquivo de processos
        LeitorArquivo arquivo = new LeitorArquivo("C:\\Users\\Julio\\Desktop\\p2.txt");
        Processo[] p = arquivo.ler();

        // passar os processos para o escalonador
        EscalonadorRoundRobin rr = new EscalonadorRoundRobin(p, 4);
        rr.getEscalonamento();

    }
}
