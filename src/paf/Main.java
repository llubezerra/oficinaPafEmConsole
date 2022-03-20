package paf;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Produto> produtosBD;
    public static void main(String[] args) {

        Empresa empresaXYZ = createEmpresa();
        produtosBD = createProdutosBD();

        Produto cafe  = findBy("7891");
        Produto arroz = findBy("7892");
        Produto gasolina = findBy("7895");

        System.out.println(empresaXYZ.getNome());
        System.out.println("--------------------------");

        Cupom cupomLoja = new Cupom(empresaXYZ, null, null);
        cupomLoja.addItem(cafe, 1);

        System.out.println("Cupom Loja de Conveniência: ");
        List<ItemDoCupom> itensDoCupom1 = cupomLoja.getItens();
        for(ItemDoCupom i : itensDoCupom1) {
            System.out.println(i.getSequencial());
            System.out.println(i.getProduto().getCodigoDeBarras());
            System.out.println(i.getProduto().getDescricao());
            System.out.println(i.getQuantidade());
            System.out.println("--------------------------");
        }

        CupomEmAbastecimento cupomPosto = new CupomEmAbastecimento(empresaXYZ, null, null);
        cupomPosto.addItem(01, 02, gasolina, 20);

        System.out.println("Cupom Posto de Gasolina: ");
        List<ItemDoCupomEmAbastecimento> itensDoCupom2 = cupomPosto.getItensAbastecimento();
        for(ItemDoCupom i : itensDoCupom2) {
            System.out.println(i.getSequencial());
            System.out.println(i.getProduto().getCodigoDeBarras());
            System.out.println(i.getProduto().getDescricao());
            System.out.println(i.getQuantidade());
            System.out.println("--------------------------");
        }

        /*
        System.out.println(produtosBD.get(0).getDescricao()); --> testei o código do Bruno pra saber o que fazia :)

        Produto produto = findBy("7891");
        if(produto != null)
            System.out.println(produto.getDescricao());
        else
            System.out.println("Produto não encontrado.");
        */
    }

    public static Empresa createEmpresa(){
        return new Empresa("08314547000173", "Posto e Conveniência Meninas Superpoderosas", "R Pe Eustáquio, 2354. Praia Grande, Arraial do Cabo - RJ");
    }

    public static List<Produto> createProdutosBD(){
        List<Produto> produtos = new ArrayList<Produto>();

        produtos.add(new Produto("7891", "Café 3 Corações", Produto.UnidadeTipo.PCT, 9.98));
        produtos.add(new Produto("7892", "Arroz Agulhinha Tipo 1 Tia Ju", Produto.UnidadeTipo.PCT, 17.48));
        produtos.add(new Produto("7893", "Feijão Carioca Codil", Produto.UnidadeTipo.PCT, 5.78));
        produtos.add(new Produto("7894", "File de Peito de Frango Congelado Sadia", Produto.UnidadeTipo.BDJ, 14.9));
        produtos.add(new Produto("7895", "Gasolina BR", Produto.UnidadeTipo.LITRO, 8.19));

        return produtos;
    }

    public static Produto findBy(String codigoDeBarras){
        for(Produto p : produtosBD)
            if(p.getCodigoDeBarras().equals(codigoDeBarras))
                return p;

            return null;
    }
}
