package principal;

import estruturasdedados.ArrayDinamico;

public class Saida {

    private ArrayDinamico p = new ArrayDinamico();
    private String PID;
    private int duracao;
    private int chegada;
    private int[] io;

    public Saida() {

    }

    public void setSaida(Processo processo) {

        this.PID = processo.getPID();
        this.duracao = processo.getDur();
        this.chegada = processo.getChegada();
        Processo pr;
        p.set(new Processo(PID, duracao, chegada, io));

    }

    public void printSaida() {
        for (int i = 0; i < p.tamanho(); i++) {
            System.out.print(i + "\t|");
        }
        System.out.println();
        for (int i = 0; i < p.tamanho(); i++) {
            System.out.print(p.get(i).getPID() + "\t|");
            //System.out.print(i + " - " + p.get(i).getPID() + " t: " + p.get(i).getDur());
        }
    }

}
