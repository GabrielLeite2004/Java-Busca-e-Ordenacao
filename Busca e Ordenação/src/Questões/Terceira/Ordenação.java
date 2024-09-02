package Questões.Terceira;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ordenação {

    public static List<Integer> lerNumerosDoArquivo(String caminhoArquivo) {
        List<Integer> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                numeros.add(Integer.parseInt(linha.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numeros;
    }

    public static void quicksort(List<Integer> numeros, int inicio, int fim, int tamanhoLimite) {
        if (inicio < fim) {
            if (fim - inicio <= tamanhoLimite) {
                // Se o tamanho da sublista for menor ou igual ao limite, usar o Insertion Sort
                insertionSort(numeros, inicio, fim);
            } else {
                // Caso contrário, usar o Quicksort
                int indicePivot = particionar(numeros, inicio, fim);
                quicksort(numeros, inicio, indicePivot - 1, tamanhoLimite);
                quicksort(numeros, indicePivot + 1, fim, tamanhoLimite);
            }
        }
    }

    public static void partitionedInsertionSort(List<Integer> array, int inicio, int fim, int tamanhoMinimoParticao) {
        if (inicio < fim) {
            if (fim - inicio + 1 <= tamanhoMinimoParticao) {
                // Se o tamanho da partição for menor ou igual ao tamanho mínimo, aplicar o Insertion Sort
                insertionSort(array, inicio, fim);
            } else {
                // Caso contrário, dividir o array em partições e chamar recursivamente para ordenar cada partição
                int meio = (inicio + fim) / 2;
                partitionedInsertionSort(array, inicio, meio, tamanhoMinimoParticao);
                partitionedInsertionSort(array, meio + 1, fim, tamanhoMinimoParticao);
            }
        }
    }

    public static int particionar(List<Integer> numeros, int inicio, int fim) {
        int pivot = numeros.get(fim);
        int indiceMenor = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (numeros.get(j) <= pivot) {
                indiceMenor++;
                trocar(numeros, indiceMenor, j);
            }
        }
        trocar(numeros, indiceMenor + 1, fim);
        return indiceMenor + 1;
    }

    public static void trocar(List<Integer> numeros, int i, int j) {
        int temp = numeros.get(i);
        numeros.set(i, numeros.get(j));
        numeros.set(j, temp);
    }

    public static void insertionSort(List<Integer> numeros, int inicio, int fim) {
        for (int i = inicio + 1; i <= fim; i++) {
            int chave = numeros.get(i);
            int j = i - 1;
            while (j >= inicio && numeros.get(j) > chave) {
                numeros.set(j + 1, numeros.get(j));
                j--;
            }
            numeros.set(j + 1, chave);
        }
    }
}
