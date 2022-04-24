package paf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cupom {

    private Empresa empresa;
    private Cliente cliente;
    protected int seqDeItens;
    List<ItemDoCupom> itens;
    private Usuario usuario;

    public Cupom(Empresa empresa, Cliente cliente, Usuario usuario) {
        this.empresa    = empresa;
        this.cliente = ((cliente != null) ? cliente : new PessoaFisica("", "", "", ""));
        this.seqDeItens = 0;
        this.itens      = new ArrayList<ItemDoCupom>();
        this.usuario    = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void addItem(Produto produto, double quantidade){
        this.itens.add(new ItemDoCupom(++seqDeItens, produto, quantidade));
    }

    public List<ItemDoCupom> getItens(){
        return Collections.unmodifiableList(itens);
        //Collections: protege a lista e o sequencial
    }

    public ItemDoCupom getUltimoItem(){
        return itens.get(itens.size() -1);
    }

    public double getValorTotal(){
        double total = 0;
        for(ItemDoCupom i : itens)
            total += i.getValor();

        return total;
    }

}
