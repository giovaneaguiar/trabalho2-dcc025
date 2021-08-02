import java.util.List;

public class Produto {

    private String nome;
    private int qtdeEstoque;
    private Integer precoUnit;
    private int estoqueMinimo;

    public Integer getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(Integer precoUnit) {
        this.precoUnit = precoUnit;
    }

    public List<String> getHistorico() {
        return historico;
    }

    public void setHistorico(List<String> historico) {
        this.historico = historico;
    }

    private int estoqueMaximo;

    private List<String> historico;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(int estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public Produto(String nome,
                   int qtdeEstoque,
                   Integer precoUnit,
                   int estoqueMinimo,
                   int estoqueMaximo) {
        this.nome = nome;
        this.qtdeEstoque = qtdeEstoque;
        this.precoUnit = precoUnit;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
    }

    public void registrarHistorico(Transacao transacao) {

    }

    public void exibirHistorico() {
    }

    public void debitarEstoque(int quantidade) {

        this.qtdeEstoque = qtdeEstoque - quantidade;
    }

    public void creditarEstoque(int quantidade) {

         this.qtdeEstoque = qtdeEstoque + quantidade;
    }

    public boolean verificarEstoqueBaixo() {
        if (qtdeEstoque < estoqueMinimo) {
            return true;
        }
        return false;
    }

    public boolean verificarEstoqueInsuficiente(int quantidade) {
     if ( this.qtdeEstoque > quantidade){
         return true;
     }
     return false;
    }

    public boolean verificarEstoqueExcedente(int quantidade) {
        if ( (this.qtdeEstoque + quantidade) > this.estoqueMaximo){
            return true;
        }
        return false;
    }

    public float calculaValorVenda(int quantidade) {
        return this.precoUnit * quantidade;

    }

    public void vender(String dataVenda, Cliente cliente, int qtdeVendida) {
         Venda venda = new Venda("02/05/2000", cliente, this, 90 );
         //this serve para passar o proprio objeto
        if(venda.vender(this, qtdeVendida)){
            //registrar venda no historico
            registrarHistorico(venda);

        }
    }


    public void comprar(String dataCompra, Fornecedor fornecedor, int qtdeCompra, Integer precoUnit) {
        Compra compra = new Compra(dataCompra, this, fornecedor, qtdeCompra, precoUnit);
        //this serve para passar o proprio objeto
        if(compra.comprar(this,qtdeCompra)){
            //registrar compra no historico
            registrarHistorico(compra);

        }
    }


}
