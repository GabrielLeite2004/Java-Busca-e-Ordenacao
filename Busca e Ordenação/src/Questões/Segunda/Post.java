package Questões.Segunda;

class Post {
    private int idUsuario;
    private int idPost;
    private int likes;
    private int comentarios;
    private int compartilhamentos;

    public Post(int idUsuario, int idPost, int likes, int comentarios, int compartilhamentos) {
        this.idUsuario = idUsuario;
        this.idPost = idPost;
        this.likes = likes;
        this.comentarios = comentarios;
        this.compartilhamentos = compartilhamentos;
    }

    public int getLikes() {
        return likes;
    }

    @Override
    public String toString() {
        return idUsuario + ";" + idPost + ";" + likes + ";" + comentarios + ";" + compartilhamentos;
    }
}
