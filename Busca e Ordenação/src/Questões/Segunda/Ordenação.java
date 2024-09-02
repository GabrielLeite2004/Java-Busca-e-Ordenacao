package Questões.Segunda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ordenação {


    public static List<Post> lerPostsDoArquivo(String caminhoArquivo) {
        List<Post> posts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                int idUsuario = Integer.parseInt(partes[0]);
                int idPost = Integer.parseInt(partes[1]);
                int likes = Integer.parseInt(partes[2]);
                int comentarios = Integer.parseInt(partes[3]);
                int compartilhamentos = Integer.parseInt(partes[4]);
                posts.add(new Post(idUsuario, idPost, likes, comentarios, compartilhamentos));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public static void quicksort(List<Post> posts, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivot = particionar(posts, inicio, fim);
            quicksort(posts, inicio, indicePivot - 1);
            quicksort(posts, indicePivot + 1, fim);
        }
    }

    public static int particionar(List<Post> posts, int inicio, int fim) {
        int pivot = posts.get(fim).getLikes();
        int indiceMenor = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (posts.get(j).getLikes() >= pivot) {
                indiceMenor++;
                trocar(posts, indiceMenor, j);
            }
        }
        trocar(posts, indiceMenor + 1, fim);
        return indiceMenor + 1;
    }

    public static void trocar(List<Post> posts, int i, int j) {
        Post temp = posts.get(i);
        posts.set(i, posts.get(j));
        posts.set(j, temp);
    }
}
