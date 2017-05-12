package leitorarquivo;

import estruturasdedados.ArrayDinamico;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import principal.Processo;

public class LeitorArquivo {

    private String endereco;

    public LeitorArquivo(String endereco) {
        this.endereco = endereco;
    }

    public Processo[] ler() throws LeituraArquivoException {
        BufferedReader br = null;
        Processo p;
        ArrayDinamico array = new ArrayDinamico();

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

                String[] row = line.split(";");
                if (row[3].equals("null")) {
                    row[3] = "-1";
                }

                String[] ioString = row[3].split(",");
                int[] io = new int[ioString.length];
                for (int i = 0; i < io.length; i++) {
                    io[i] = Integer.parseInt(ioString[i]);
                }

                p = new Processo(row[0], Integer.parseInt(row[1]), Integer.parseInt(row[2]), io);
                array.set(p);
                line = br.readLine();
            }

            br.close();

        } catch (FileNotFoundException e) {
            throw new LeituraArquivoException("Arquivo Nao Encontrado");
        } catch (IOException e) {
            throw new LeituraArquivoException("Erro de Entrada/Saida");
        }

        Processo[] processos = new Processo[array.tamanho()];

        for (int i = 0; i < array.tamanho(); i++) {
            processos[i] = array.get(i);
        }

        return processos;

    }
}
