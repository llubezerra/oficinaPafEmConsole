package paf;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Empresa empresa = createEmpresa();
        List<Produto> produtosBD = createProdutosBD();

        System.out.println(empresa.getNome());
    }

    public static Empresa createEmpresa(){
        return new Empresa("08314547000173", "EPA Supermercados Padre Eustáquio", "R Pe Eustáquio, 2354. Padre Eustáquio, BH - MG");
    }

    public static List<Produto> createProdutosBD(){
        List<Produto> produtos = new ArrayList<Produto>();

        produtos.add(new Produto("7891", "Café 3 Corações", Produto.UnidadeTipo.PCT, 9.98));
        produtos.add(new Produto("7892", "Arroz Agulhinha Tipo 1 Tia Ju", Produto.UnidadeTipo.PCT, 17.48));
        produtos.add(new Produto("7893", "Feijão Carioca Codil", Produto.UnidadeTipo.PCT, 5.78));
        produtos.add(new Produto("7894", "File de Peito de Frango Congelado Sadia", Produto.UnidadeTipo.BDJ, 14.9));

        return produtos;
    }
}
