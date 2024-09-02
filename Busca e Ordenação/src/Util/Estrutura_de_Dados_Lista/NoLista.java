package Util.Estrutura_de_Dados_Lista;

class NoLista<TIPO> {
    String info;
    NoLista<TIPO> proximo;
    NoLista<TIPO> anterior;
    public NoLista(String elemento) {
        this.info = elemento;
        this.anterior = null;
        this.proximo = null;
    }
    public String getInfo() {
        return info;
    }
}