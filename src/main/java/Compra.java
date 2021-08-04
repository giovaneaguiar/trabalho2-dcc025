import org.jetbrains.annotations.NotNull;

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
        if(fornecedor == null){
            throw new NullPointerException("Valor de fornecedor indisponível");
        }
        if(precoUnit == null || precoUnit < 0)
            throw new IllegalArgumentException("Preço unitário indisponível");

        this.fornecedor = fornecedor;
        this.precoUnit = precoUnit;
    }

    public boolean comprar( Produto produto, int qtdeCompra) {
        if (produto.verificarEstoqueExcedente(qtdeCompra)) {
            produto.registrarHistorico("Excedente!");
            return false;
        }
        produto.creditarEstoque(qtdeCompra);
        produto.registrarHistorico("Transacao: Comprado " + produto.getNome());
        return true;


    }
}
