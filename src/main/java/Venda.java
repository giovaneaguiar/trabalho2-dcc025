
public class Venda extends Transacao {

     public Cliente cliente;

    public Venda(String dataVenda, Cliente cliente, Produto produto, int qtdeVendida) {
        super(dataVenda, produto, qtdeVendida);
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
            System.out.println("Estoque insuficiente!");
            return false;
        }
            produto.debitarEstoque(qtdeVendida);

            System.out.println(produto.calculaValorVenda(qtdeVendida));

            if (produto.verificarEstoqueBaixo()) {
                System.out.println("Estoque baixo!");
                return true;
            }

            return false;

    }

}



