package filas;

import principal.Processo;

public class FilaProcessos{

    private final Processo[] processos;
    private int primeiro;
    private int ultimo;
    private int total;

    public FilaProcessos(int tamanho) {
        processos = new Processo[tamanho];
        primeiro = 0;
        ultimo = 0;
        total = 0;
    }

    public void inserir(Processo processo) {
        if (isFull()) {
            throw new RuntimeException("Fila cheia!");
        }
        processos[ultimo] = processo;
        ultimo = (ultimo + 1) % processos.length; // resto da divisão, para fazer o valor retornar pra 0
        total++;
    }

    public Processo retirar() {
        if (isEmpty()) {
            throw new RuntimeException("Fila Vazia!");
        }
        Processo processo = processos[primeiro];
        primeiro = (primeiro + 1) % processos.length;
        total--;
        return processo;
    }

    public boolean isEmpty() {
        return total == 0;
    }

    public boolean isFull() {
        return total == processos.length; // se total == tamanho do vetor, está cheio
    }

    // metodo para exibir elementos da fila
    public void exibirFila() {
        if (isEmpty()) {
            throw new RuntimeException("Fila Vazia!");
        }
        Processo[] p = processos;
        int prim = primeiro;
        int ult = ultimo;
        int tt = total;
        
        System.out.print("FILA: ");
        while (tt != 0) {
            Processo processo = p[prim];
            prim = (prim + 1) % p.length;
            tt--;

            System.out.print(processo.toString() + " ");
        }
        System.out.println("");

    }
}
