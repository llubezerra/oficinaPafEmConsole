package paf;

public class PessoaFisica extends Cliente{

    private String cpf;

    public PessoaFisica(String cpf, String nome, String endereco, String telefone) {
        super(nome, endereco, telefone);
        this.cpf = cpf;
    }

    @Override
    public String getDocIndvdl(){
        return cpf;
    }
}
