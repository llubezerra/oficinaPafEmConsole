package paf;

public class ItemDoCupom {

    private int sequencial;
    private Produto produto;
    private double quantidade;
    private double descontoPercentual;

    public ItemDoCupom(int sequencial, Produto produto, double quantidade) {
        this.sequencial         = sequencial;
        this.produto            = produto;
        this.quantidade         = quantidade;
        this.descontoPercentual = 0;
    }

    public int getSequencial() {
        return sequencial;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public double getValor(){
        double valor = produto.getValorUnitario() * quantidade;
        return (valor - (valor * descontoPercentual));
    }

    public void setDescontoPercentual(double percentual){
        if(percentual > 0)
            descontoPercentual = percentual;
    }

    public double getDescontoPercentual() {
        return descontoPercentual;
    }
}
