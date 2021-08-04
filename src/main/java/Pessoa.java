public class Pessoa {
    //Nome: Giovane Machado Aguiar
    //Matrícula: 201876019
    //Obrigado! <3

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome) {
        if (nome == null){
            throw new IllegalArgumentException("Nome nulo!");
        }
        this.nome = nome;
    }
}
