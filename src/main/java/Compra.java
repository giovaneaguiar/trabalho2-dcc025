public class Compra {

    private Integer precoUnit;

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

    private Fornecedor fornecedor;

    public Compra(String dataCompra, String produto, String fornecedor, int qtdeCompra, Integer precoUnit) {

    }

    public String comprar(String produto, int qtdeCompra) {
            return "Teste";
    }
}
