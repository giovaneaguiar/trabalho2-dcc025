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

        //uso de exceção
        if (qtde < 0){
            throw new IllegalArgumentException("Esta quantidade não é válida");

        }
        if (dataTransacao == null){
            throw new IllegalArgumentException("Esta data de transação não é válida");
        }
        this.dataTransacao = dataTransacao;
        this.produto = produto;
        this.qtde = qtde;

    }


}
