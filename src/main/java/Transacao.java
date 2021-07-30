public class Transacao {

    private String dataTransacao;
    private int qtde;
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Transacao(String dataTransacao, Produto produto, int qtde) {
        this.dataTransacao = dataTransacao;
        this.produto = produto;
        this.qtde = qtde;
    }


}
