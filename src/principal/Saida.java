package principal;

import java.util.ArrayList;

public class Saida {

    private ArrayList<Processo> p = new ArrayList<>();
    private String PID;
    private int duracao;
    private int chegada;

    public Saida() {

    }

    public void setSaida(Processo processo) {

        this.PID = processo.getPID();
        this.duracao = processo.getDur();
        this.chegada = processo.getChegada();
        Processo pr;
        p.add(new Processo(PID, duracao, chegada));

    }

    public void printSaida() {
        for (int i = 0; i < p.size(); i++) {
            System.out.print(i + "\t|");
        }
        System.out.println();
        for (int i = 0; i < p.size(); i++) {
            System.out.print(p.get(i).getPID() + "\t|");
            //System.out.print(i + " - " + p.get(i).getPID() + " t: " + p.get(i).getDur());
        }
    }

}
