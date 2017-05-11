package estruturasdedados;

import principal.Processo;

/**
 *
 * @author Julio
 */
public class ArrayDinamico {

    private Processo[] vet;
    private int tamanho = 2;
    private int posLivre = 0;

    public ArrayDinamico() {
        vet = new Processo[tamanho];
    }

    public void set(Processo x) {

        if (posLivre < tamanho) {
            vet[posLivre] = x;
            posLivre++;
        } else {
            aumentarVetor();
            vet[posLivre] = x;
            posLivre++;
        }

    }

    public Processo remove(int pos) {
        Processo aux = null;

        if (pos > -1 || pos < tamanho()) {

            aux = vet[pos];
            vet[pos] = null;

            reindexarVetor();
            posLivre--;

            return aux;
        } else {
            throw new ArrayIndexOutOfBoundsException("Indice inexistente");
        }
    }
    
    public Processo get(int pos) {
        Processo aux = null;

        if (pos > -1 || pos < tamanho()) {
            return vet[pos];
        } else {
            throw new ArrayIndexOutOfBoundsException("Indice inexistente");
        }
    }

    private void aumentarVetor() {
        
        Processo[] vetTemp = vet;
        int novoTamanho = this.tamanho + this.tamanho / 2;
        this.tamanho = novoTamanho;

        vet = new Processo[novoTamanho];

        for (int i = 0; i < vetTemp.length; i++) {
            vet[i] = vetTemp[i];
        }
    }

    private void reindexarVetor() {

        for (int i = 0; i < vet.length; i++) {
            if (vet[i] == null) {
                int aux = 0;
                for (int j = i; j < vet.length - 1; j++) {
                    if (vet[j + 1] != null) {
                        vet[i + aux] = vet[j + 1];
                        vet[j + 1] = null;
                        aux++;
                    }
                }
            }
        }
        diminuirVetor();
    }

    public void exibir() {
        for(int i = 0; i < vet.length && vet[i] != null; i++) {
            System.out.print(vet[i] + " ");
        }
        System.out.println("");
    }

    public int tamanho() {
        int tamanhoDinamico = 0;
        while (tamanhoDinamico < vet.length && vet[tamanhoDinamico] != null) {
            tamanhoDinamico++;
        }
        return tamanhoDinamico;
    }

    private void diminuirVetor() {
        Processo[] vetTemp = vet;

        if (tamanho() <= this.tamanho / 2) {
            this.tamanho = this.tamanho / 2;

            vet = new Processo[this.tamanho];

            for (int i = 0; i < vet.length; i++) {
                vet[i] = vetTemp[i];
            }
        }
    }
}
