package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeitorArquivo {

    private String endereco;

    public LeitorArquivo(String endereco) {
        this.endereco = endereco;
    }

    //implementar metodo para ler arquivo e transforma-los em objetos
    public Processo[] ler() throws LeituraArquivoException {
        BufferedReader br = null;
        Processo p;
        ArrayList<Processo> array = new ArrayList<>();
        
        try {
            br = new BufferedReader(new FileReader(endereco));
            String line = br.readLine();
            
            if (line == null) {
                throw new LeituraArquivoException("Arquivo Vazio");
            }
            if (!line.contains(";")) {
                throw new LeituraArquivoException("Formato Invalido");
            }
            while (line != null) {
                // "," ou ";" de acordo com o arquivo
                String[] row = line.split(";");
                //System.out.println(row[0] + " - " + row[1] + " - " + row[2]);
                
                p = new Processo(row[0], Integer.parseInt(row[1]), Integer.parseInt(row[2]));
                array.add(p);
                line = br.readLine();
            }

            br.close();

        } catch (FileNotFoundException e) {
            throw new LeituraArquivoException("Arquivo Nao Encontrado");
        } catch (IOException e) {
            throw new LeituraArquivoException("Erro de Entrada/Saida");
        }
        
        Processo[] processos = new Processo[array.size()];
        
        for(int i = 0; i < array.size(); i++) {
            processos[i] = array.get(i);
        }
        
        return processos;
        
    }

    
    //                Processo(PID, duracao, chegada)
    Processo p1 = new Processo("p1", 5, 8);
    Processo p2 = new Processo("p2", 12, 0);
    Processo p3 = new Processo("p3", 10, 2);
    Processo p4 = new Processo("p4", 7, 10);
    Processo p5 = new Processo("p5", 9, 4);

    public Processo[] getProcessos() {
        Processo[] processos = lerArquivo();

        return processos;
    }

    //implementar metodo para ler arquivo e transforma-los em objetos
    private Processo[] lerArquivo() {
        Processo[] processos = {p1, p2, p3, p4, p5};

        return processos;
    }
}
