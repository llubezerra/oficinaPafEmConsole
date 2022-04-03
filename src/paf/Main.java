package paf;

import paf.menu.MenuHandler;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Empresa epaPadreEustaquio = createEmpresa();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        MenuHandler menuHandler = new MenuHandler(epaPadreEustaquio, null, produtoDAO);
        menuHandler.select("p");
        System.out.println("::: PAF em Console ::::");
        System.out.println("Empresa: " + epaPadreEustaquio);
        System.out.println("Encerrado(...)");

        System.out.println(epaPadreEustaquio.getNome());
        System.out.println("--------------------------");

        Cupom cupomLoja = new Cupom(epaPadreEustaquio, null, null);

        System.out.println("Cupom Loja de Conveniência: ");
        List<ItemDoCupom> itensDoCupom1 = cupomLoja.getItens();
        for(ItemDoCupom i : itensDoCupom1) {
            System.out.println(i.getSequencial());
            System.out.println(i.getProduto().getCodigoDeBarras());
            System.out.println(i.getProduto().getDescricao());
            System.out.println(i.getQuantidade());
            System.out.println("--------------------------");
        }

        CupomEmAbastecimento cupomPosto = new CupomEmAbastecimento(epaPadreEustaquio, null, null);
        //cupomPosto.addItem(01, 02, gasolina, 20);

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

}
