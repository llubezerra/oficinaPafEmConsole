package paf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CupomEmAbastecimento extends Cupom{

    private List<ItemDoCupomEmAbastecimento> itensAbastecimento;

    public CupomEmAbastecimento(Empresa empresa, Cliente cliente,
                                Usuario usuario) {
        super(empresa, cliente, usuario);
        itensAbastecimento = new ArrayList<ItemDoCupomEmAbastecimento>();
    }

    public void addItem(int bomba, int bico, Produto produto, double quantidade) {
        this.itensAbastecimento.add(new ItemDoCupomEmAbastecimento(++seqDeItens, bomba, bico, produto, quantidade));
    }

    public List<ItemDoCupomEmAbastecimento> getItensAbastecimento() {
        return Collections.unmodifiableList(itensAbastecimento);
    }

    public ItemDoCupomEmAbastecimento getUltimoItem() {
        return itensAbastecimento.get(itensAbastecimento.size() -1);
    }

}
