package principal;

public class Processo {
    
    private String PID;
    private final int tempoInicial;
    private int duracao;   
    private int chegada;
    private int[] io;
    

    public Processo(String PID, int duracao, int chegada, int[] io) {
        this.PID = PID;
        this.tempoInicial = duracao;
        this.duracao = duracao;
        this.chegada = chegada;
        this.io = io;
    }

    public int getTempoInicial() {
        return tempoInicial;
    }
    
    public String getPID() {
        return this.PID;
    }
    
    public int getChegada() {
        return this.chegada;
    }
    
    public int getDur() {
        return this.duracao;
    }
    public void setDur(int dur) {
        this.duracao = dur;
    }
    
    public int[] getIo() {
        return this.io;
    }

    @Override
    public String toString() {
        //return "Processo{" + "PID = " + PID + ", duracao = " + duracao + ", chegada = " + chegada + '}';
        return PID + "(" + duracao + ")";
    }

    void ioDone(int i) {
        this.io[i] = -1;
    }
    
    
}
