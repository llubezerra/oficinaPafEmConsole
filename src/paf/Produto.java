package paf;

public class Produto {

    public enum UnidadeTipo{
        PESO, UNID, POTE, LATA, CX, PCT, BDJ;
    }
    private String barcode;
    private String descricao;
    private UnidadeTipo unidade;
    private double valorUnitario;

    public Produto(String barcode, String descricao, UnidadeTipo unidade, double valorUnitario){
        this.barcode        = barcode;
        this.descricao      = descricao;
        this.unidade        = unidade;
        this.valorUnitario  = valorUnitario;
    }

    public String getBarcode() {
        return barcode;
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
