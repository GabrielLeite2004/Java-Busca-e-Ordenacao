package Questões.Terceira;

import java.util.List;

import static Questões.Terceira.Ordenação.*;

public class Play {

    public static void main(String[] args) {
        String caminhoArquivo = "src\\Arquivos\\Entrada\\3_Questão.txt";

        List<Integer> numeros = lerNumerosDoArquivo(caminhoArquivo);
        int tamanhoMinimoParticao = 1000;

        partitionedInsertionSort(numeros, 0, numeros.size() - 1, tamanhoMinimoParticao);

        for (int i = 0; i < numeros.size(); i++) {
            System.out.print(numeros.get(i));
            if (i < numeros.size() - 1) {
                System.out.print(";");
            }
        }
    }

}
