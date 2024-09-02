package Util.Estrutura_de_Dados_Lista;


import Util.Gerenciador_de_Arquivos.Comandos;
public class ListaEncadeadaDupla implements Comandos {
    NoLista inicio;
    NoLista fim;
    int tamanho;

    public ListaEncadeadaDupla(){
        this(0);
    }

    ListaEncadeadaDupla(int tamanho){
        this.inicio = null;
        this.fim = null;
        this.tamanho = tamanho;
    }

    public void inserir(String k) {
        NoLista no = new NoLista(k);
        if(tamanho == 0){
            no.anterior = null;
            no.proximo = inicio;
            if(inicio != null){
                inicio.anterior = no;
            }
            inicio = no;
            if(tamanho == 0){
                fim = inicio;
            }
            tamanho++;
        } else {
            no.proximo = null;
            no.anterior = fim;
            if(fim != null){
                fim.proximo = no;
            }
            fim = no;
            if(tamanho == 0){
                inicio = fim;
            }
            tamanho++;
        }
    }

    public boolean Buscar(String info) {
        if (info == null || this.inicio == null) {
            System.out.println("Não possui essa informação");
            return false;
        }

        NoLista Buscado = new NoLista(info);
        NoLista Local = this.inicio;

        for (int i = 0; i < tamanho; i++) {
            String a = Buscado.getInfo().split(";", 2)[0].trim();
            String b = Local.getInfo().split(";", 2)[0].trim();
            if (a.equalsIgnoreCase(b)) {
                System.out.println("Possui esse elemento no índice " + i);
                return true;
            } else {
                Local = Local.proximo;
            }
        }

        System.out.println("Não possui esse elemento");
        return false;
    }


    public void imprimir() {
        String str = "(" + tamanho + ") ";
        NoLista local = inicio;
        while(local != null){
            if(local.getInfo() != null) {
                str += local.getInfo() + " ";
            }
            local = local.proximo;

        }
        System.out.println(str);
    }

    public void remover(String info) {
        NoLista Local = this.inicio;
        while (Local != null) {
            if (Local.getInfo().equals(info)) {
                break;
            }
            Local = Local.proximo;
        }
        if (Local != null) {
            if (Local.proximo == null) {
                this.fim = this.fim.anterior;
                tamanho--;
            } else if (Local.anterior == null) {
                inicio = inicio.proximo;
                inicio.anterior = null;
                tamanho--;
            } else {
                NoLista local = inicio;
                while (local != null) {
                    if (local.getInfo().equals(info)) {
                        break;
                    }
                    local = local.proximo;
                }
                if (local != null) {
                    local.proximo.anterior = local.anterior;
                    local.anterior.proximo = local.proximo;
                    tamanho--;
                } else {
                    System.out.println("informação inválida");
                }
            }
            System.out.println("Elemento Removido");
        } else {
            System.out.println("Elemento não encontrado");
        }
    }
}