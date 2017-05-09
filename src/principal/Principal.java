package principal;

import filas.FilaProcessos;
import java.io.IOException;
import java.util.ArrayList;
import mock.MockLeitorArquivo;

public class Principal {

    public static void x(String[] args) {

        // ler arquivo de processos
        MockLeitorArquivo arquivo = new MockLeitorArquivo("abc");
        Processo[] p = arquivo.getProcessos();

        // passar os processos para o escalonador
        Escalonador rr = new Escalonador(p, 3);
        rr.getEscalonamento();
        // executar o escalonamento
        //exibir os resultados

    }

    public static void main(String[] args) throws IOException {

        // ler arquivo de processos
        LeitorArquivo arquivo = new LeitorArquivo("C:\\Users\\Julio\\Desktop\\processos.txt");
        Processo[] p = arquivo.ler();

        // passar os processos para o escalonador
        Escalonador rr = new Escalonador(p, 3);
        rr.getEscalonamento();

    }
}
