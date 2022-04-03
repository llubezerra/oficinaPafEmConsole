package paf;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private List<Produto> produtosBD;

    public ProdutoDAO() {
        produtosBD = new ArrayList<Produto>();

        produtosBD.add(new Produto("7891", "Café 3 Corações", Produto.UnidadeTipo.PCT, 9.98));
        produtosBD.add(new Produto("7892", "Arroz Agulhinha Tipo 1 Tia Ju", Produto.UnidadeTipo.PCT, 17.48));
        produtosBD.add(new Produto("7893", "Feijão Carioca Codil", Produto.UnidadeTipo.PCT, 5.78));
        produtosBD.add(new Produto("7894", "File de Peito de Frango Congelado Sadia", Produto.UnidadeTipo.BDJ, 14.9));
        produtosBD.add(new Produto("7895", "Gasolina BR", Produto.UnidadeTipo.LITRO, 8.19));
    }

    public Produto findBy(String codigoDeBarras){
        for(Produto p : produtosBD)
            if(p.getCodigoDeBarras().equals(codigoDeBarras))
                return p;

        return null;
    }
}
