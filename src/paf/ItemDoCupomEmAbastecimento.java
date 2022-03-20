package paf;

public class ItemDoCupomEmAbastecimento extends ItemDoCupom{

    private int bomba;
    private int bico;

    public ItemDoCupomEmAbastecimento(int sequencial, int bomba, int bico, Produto produto, double quantidade) {
        super(sequencial, produto, quantidade);
        this.bomba = bomba;
        this.bico = bico;
    }

    public int getBomba(){
        return bomba;
    }

    public int getBico(){
        return bico;
    }
}
