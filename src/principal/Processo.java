package principal;

public class Processo {
    
    private String PID;
    private int duracao;
    private int chegada;
    //private int[] operacaoIO;

    public Processo(String PID, int duracao, int chegada) {
        this.PID = PID;
        this.duracao = duracao;
        this.chegada = chegada;
        //this.operacaoIO = operacaoIO;
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

    @Override
    public String toString() {
        return "Processo{" + "PID = " + PID + ", duracao = " + duracao + ", chegada = " + chegada + '}';
    }
    
    
}
