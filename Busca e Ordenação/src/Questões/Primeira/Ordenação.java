package Questões.Primeira;

public class Ordenação {


    // Método para ordenar a matriz usando Merge Sort
    public static void ordenarMatriz(int[][] matriz) {
        int linhas = matriz.length;
        int cols = matriz[0].length;
        int[] temp = new int[linhas * cols];

        // Convertendo a matriz para uma matriz unidimensional
        int k = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < cols; j++) {
                temp[k++] = matriz[i][j];
            }
        }

        // Aplicando o algoritmo Merge Sort na matriz unidimensional
        mergeSort(temp, 0, temp.length - 1);

        // Reconstruindo a matriz ordenada
        k = 0;
        for (int i = linhas - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                matriz[i][j] = temp[k++];
            }
        }
    }

    // Implementação do algoritmo Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}
