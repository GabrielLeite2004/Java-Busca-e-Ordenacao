package Util.Gerenciador_de_Arquivos;

public interface Comandos<T> {
    void inserir(String elemento);
    void remover (String elemento);
    boolean Buscar (String elemento);
    void imprimir();

}