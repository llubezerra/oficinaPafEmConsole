package paf;

import paf.menu.MenuHandler;

public class Main {

    public static void main(String[] args) {

        Empresa epaPadreEustaquio = createEmpresa();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        MenuHandler menuHandler = new MenuHandler(epaPadreEustaquio, null, produtoDAO);
        menuHandler.select("p");
        System.out.println();
        System.out.println("::: PAF em Console ::::");
        System.out.println("Empresa: " + epaPadreEustaquio.getNome());
        System.out.println("Encerrado");
        System.out.println();

        System.out.println("--------------------------");

    }

    public static Empresa createEmpresa(){
        return new Empresa("08314547000173", "Posto e Conveniência Meninas Superpoderosas", "R Pe Eustáquio, 2354. Praia Grande, Arraial do Cabo - RJ");
    }

}
