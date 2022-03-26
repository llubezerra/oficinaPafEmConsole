package paf;

public class PessoaJuridica extends Cliente{

    private String cnpj;
    private String contato;

    public PessoaJuridica(String cnpj, String nome, String endereco, String telefone, String contato) {
        super(nome, endereco, telefone);
        this.cnpj       = cnpj;
        this.contato    = contato;
    }

    @Override
    public String getDocIndvdl(){
        return cnpj;
    }
    
    public String getContato() {
        return contato;
    }
}
