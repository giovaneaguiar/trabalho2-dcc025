
public class Venda extends Transacao {

    Cliente cliente;

    public Venda(String dataVenda, Cliente cliente, Produto produto, int qtdeVendida) {
        super(dataVenda, produto, qtdeVendida);
        if (cliente == null) {
            throw new NullPointerException("Cliente indisponível!");
        }
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    public boolean vender(Produto produto, int qtdeVendida) {
        if (produto.verificarEstoqueInsuficiente(qtdeVendida)) {
            produto.registrarHistorico("Estoque insuficiente!");
            return false;
        }
            produto.debitarEstoque(qtdeVendida);
            produto.registrarHistorico("Transacao: Vendido um " + produto.getNome());

             produto.calculaValorVenda(qtdeVendida);
            if (produto.verificarEstoqueBaixo()) {
                produto.registrarHistorico("Estoque baixo!");
                return true;
            }

            return false;

    }

}



