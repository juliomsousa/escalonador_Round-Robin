package principal;

import filas.FilaProcessos;
import mock.MockLeitorArquivo;

public class Principal {

    public static void main(String[] args) {

        // ler arquivo de processos
        MockLeitorArquivo arquivo = new MockLeitorArquivo("abc");
        Processo[] p = arquivo.getProcessos();

        // passar os processos para o escalonador
        Escalonador rr = new Escalonador(p, 3);
        rr.getEscalonamento();
        // executar o escalonamento
        //exibir os resultados

    }

}
