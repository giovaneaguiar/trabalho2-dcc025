public class Cliente extends Pessoa {

    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cliente(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;

        Cliente cliente1 = new Cliente("Giovane", "05926307732");
    }
}
