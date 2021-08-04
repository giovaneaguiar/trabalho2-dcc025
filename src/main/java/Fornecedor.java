public class Fornecedor extends Pessoa{

    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Fornecedor(String nome, String cnpj) {
        super(nome);
        if ( cnpj == null){
            throw new IllegalArgumentException("CNPJ Nulo!");
        }
        this.cnpj = cnpj;
    }
}
