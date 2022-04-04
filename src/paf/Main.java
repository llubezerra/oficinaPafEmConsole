package paf;

import paf.menu.MenuHandler;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Empresa epaPadreEustaquio = createEmpresa();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        MenuHandler menuHandler = new MenuHandler(epaPadreEustaquio, null, produtoDAO);
        menuHandler.select("p");
        System.out.println("::: PAF em Console ::::");
        System.out.println("Empresa: " + epaPadreEustaquio.getNome());
        System.out.println("Encerrado(...)");
        System.out.println();

        System.out.println("--------------------------");

        Cupom cupomLoja = new Cupom(epaPadreEustaquio, null, null);

        cupomLoja.addItem(produtoDAO.findBy("7892"), 2);

        System.out.println("Cupom Loja de Conveniência: ");
        List<ItemDoCupom> itensDoCupom1 = cupomLoja.getItens();
        for(ItemDoCupom i : itensDoCupom1) {
            System.out.println("Sequencial: " + i.getSequencial());
            System.out.println("Código de barras: " + i.getProduto().getCodigoDeBarras());
            System.out.println("Descrição: " + i.getProduto().getDescricao());
            System.out.println("Quantidade: " + i.getQuantidade());
            System.out.println("--------------------------");
        }

    }

    public static Empresa createEmpresa(){
        return new Empresa("08314547000173", "Posto e Conveniência Meninas Superpoderosas", "R Pe Eustáquio, 2354. Praia Grande, Arraial do Cabo - RJ");
    }

}
