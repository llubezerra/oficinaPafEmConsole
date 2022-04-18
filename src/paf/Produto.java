package paf;

public class Produto {

    public enum UnidadeTipo{
        PE, UN, PT, LT, CX, PCT, BDJ, LTR;
    }
    private String codigoDeBarras;
    private String descricao;
    private UnidadeTipo unidade;
    private double valorUnitario;

    public Produto(String codigoDeBarras, String descricao, UnidadeTipo unidade, double valorUnitario){
        this.codigoDeBarras = codigoDeBarras;
        this.descricao      = descricao;
        this.unidade        = unidade;
        this.valorUnitario  = valorUnitario;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public UnidadeTipo getUnidade() {
        return unidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }
}
