package Questões.Segunda;

import java.util.List;
import static Questões.Segunda.Ordenação.lerPostsDoArquivo;
import static Questões.Segunda.Ordenação.quicksort;

public class Play {

    public static void main(String[] args) {
        String caminhoArquivo = "src\\Arquivos\\Entrada\\2_Questão.txt";

        List<Post> posts = lerPostsDoArquivo(caminhoArquivo);

        quicksort(posts, 0, posts.size() - 1);

        for (Post post : posts) {
            System.out.println(post);
        }
    }
}

