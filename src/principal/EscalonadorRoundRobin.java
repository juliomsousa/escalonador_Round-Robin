package principal;

import estruturasdedados.FilaProcessos;

public class EscalonadorRoundRobin {

    private Processo[] lista = null;
    private int quantum = 0;
    private FilaProcessos fila = null;
    private final int duracao;

    public EscalonadorRoundRobin(Processo[] processos, int quantum) {
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
        System.out.println("Duração do escalonamento: " + getDuracao(lista) + "\n"); // debug
        // para cada tempo
        do {

            // exibir tempo atual
            System.out.print("Tempo " + tempo + " ");

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

                    // condição de I/O
                    if (hasIo(cpu)) {
                        System.out.println("Operação de I/O " + cpu.getPID());
                        fila.inserir(cpu);
                        cpu = fila.retirar();
                        limite = quantum;
                    }

                    if (!fila.isEmpty()) {
                        System.out.println("");
                        fila.exibirFila(); // debug
                    } else {
                        System.out.println("\nFILA VAZIA");
                    }

                    System.out.println("CPU: " + cpu.getPID() + "(" + cpu.getDur() + ")"); // debug

                    cpu.setDur(cpu.getDur() - 1);
                    limite--;

                    if (limite == 0 && cpu.getDur() != 0) {
                        System.out.println("Fim do quantum " + cpu.getPID());
                        fila.inserir(cpu);
                    }
                    if (cpu.getDur() == 0) {
                        System.out.println("Fim do processo " + cpu.getPID());
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

    private boolean hasIo(Processo p) {
        int io = p.getTempoInicial() - p.getDur();

        for (int i = 0; i < p.getIo().length; i++) {
            if (p.getIo()[i] == io) {
                p.ioDone(i);
                return true;
            }
        }
        return false;
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
