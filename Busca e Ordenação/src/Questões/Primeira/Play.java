package Questões.Primeira;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Questões.Primeira.Ordenação.ordenarMatriz;

public class Play {

    public static void main(String[] args) {
        String caminhoArquivo = "src\\Arquivos\\Entrada\\1_Questão.txt";

        List<int[]> linhasMatriz = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");

                int[] linhaMatriz = new int[partes.length];
                for (int i = 0; i < partes.length; i++) {
                    linhaMatriz[i] = Integer.parseInt(partes[i].trim());
                }

                linhasMatriz.add(linhaMatriz);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        int[][] matriz = linhasMatriz.toArray(new int[linhasMatriz.size()][]);
        ordenarMatriz(matriz);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
                if (j < matriz[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
