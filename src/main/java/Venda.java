public class Venda extends Transacao {

    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Venda(Venda dataVenda, Cliente cliente, String produto, int tdeVendida) {
        super();

    }
}


