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
        if (cpf == null){
            throw new IllegalArgumentException("CPF Nulo!");
        }
        this.cpf = cpf;
    }
}
