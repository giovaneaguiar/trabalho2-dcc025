public class Compra extends Transacao {

    private Integer precoUnit;
    private Fornecedor fornecedor;

    public Integer getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(Integer precoUnit) {
        this.precoUnit = precoUnit;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Compra(String dataCompra, Produto produto, Fornecedor fornecedor, int qtdeCompra, Integer precoUnit) {
        super(dataCompra, produto, qtdeCompra);
        this.fornecedor = fornecedor;
        this.precoUnit = precoUnit;
    }

    public String comprar(String produto, int qtdeCompra) {
            return "Teste";
    }
}
