import java.util.List;

public class Produto {

    private String nome;
    private int qtdeEstoque;
    private float precoUnit;
    private int estoqueMinimo;

    public void setPrecoUnit(float precoUnit) {
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

    public float getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(Integer precoUnit) {
        this.precoUnit = precoUnit;
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
                   float precoUnit,
                   int estoqueMinimo,
                   int estoqueMaximo) {
        //construtor
        this.nome = nome;
        this.qtdeEstoque = qtdeEstoque;
        this.precoUnit = precoUnit;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;

        Produto produto1 = new Produto("iPhone 12", 5, 5000, 2, 10);
    }

    public void registrarHistorico(Transacao transacao) {
    }

    public void exibirHistorico() {
    }

    public int debitarEstoque(int qtdeEstoque) {
        return this.qtdeEstoque;
    }

    public int creditarEstoque(int qtdeEstoque) {
        return this.qtdeEstoque;
    }

    public boolean verificarEstoqueBaixo() {
        if (qtdeEstoque < estoqueMinimo) {
            return true;
        }
        return false;
    }

    public boolean verificarEstoqueInsuficiente() {

    }

    public boolean verificarEstoqueExcedente() {

    }

    public float calculaValorVenda(int qtdeEstoque) {
        return this.precoUnit * this.qtdeEstoque;

    }

    public void vender() {


    }

    public void comprar() {

    }


}
