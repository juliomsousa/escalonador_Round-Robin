package principal;

import filas.FilaProcessos;

public class Escalonador {

    private Processo[] lista = null;
    private int quantum = 0;
    private FilaProcessos fila = null;
    private final int duracao;

    public Escalonador(Processo[] processos, int quantum) {
        this.lista = processos;
        this.quantum = quantum;
        fila = new FilaProcessos(lista.length);
        this.duracao = getDuracao(processos);
    }

    public void getEscalonamento() {
        Saida s = new Saida(); // objeto para formatar a saida

        int tempo = 0;
        Processo p = null;
        Processo cpu = null;

        int limite = 0;
        System.out.println("Duração do escalonamento: " + getDuracao(lista)); // 
        // para cada tempo
        do {

            // exibir tempo atual
            System.out.println("Tempo " + tempo + "\n");

            // verificar lista de processos
            for (Processo proc : lista) {
                if (proc.getChegada() == tempo) {
                    System.out.println("Chegada do processo: " + proc.getPID());
                    p = proc;
                    fila.inserir(p);
                }
            }

            //execucao
            // obtem o processo da fila para executar
            if (limite == 0 && !fila.isEmpty()) {
                cpu = fila.retirar();
                limite = quantum;
            }

            if (limite > 0) {
                s.setSaida(cpu); // debug

                if (cpu.getDur() != 0) {
                    System.out.println("CPU: " + cpu.getPID() + "(" + cpu.getDur() + ")"); // debug

                    if (!fila.isEmpty()) {
                        fila.exibirFila(); // debug
                    } else {
                        System.out.println("FILA VAZIA");
                    }

                    cpu.setDur(cpu.getDur() - 1);
                    limite--;

                    if (limite == 0 && cpu.getDur() != 0) {
                        fila.inserir(cpu);
                    }
                    if (cpu.getDur() == 0) {
                        limite = 0;
                    }
                } else {
                    limite = 0;
                }

            }
            System.out.println("-------------------------------------");
            tempo++;

        } while (tempo < duracao);

        s.printSaida();

        System.out.println("\n+++++++++++ FIM DA SIMULAÇÃO ++++++++++++\n");
    }

    private int getDuracao(Processo[] listaProcessos) {
        int duracao = 0;
        for (Processo pr : listaProcessos) {
            duracao += pr.getDur();
        }

        return duracao;
    }

    private void printObj(Processo p) {
        System.out.println("PID: " + p.getPID());
        System.out.println("Chegada: " + p.getChegada());
        System.out.println("Tempo: " + p.getDur());
    }

    private void printLista(Processo[] processos) {
        for (Processo p : processos) {
            printObj(p);
        }
    }

    private void printTempo(Processo p, int tempo) {
        System.out.println("Tempo: " + tempo);
        System.out.println("CPU: " + p.getPID() + "(" + p.getDur() + ")");

    }
}
