package paf;

import paf.menu.MenuHandler;

import br.com.ecfsim.EcfSimDriver;

public class Main {

    public static void main(String[] args) {

        Empresa epaPadreEustaquio = createEmpresa();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        EcfSimDriver driver = new EcfSimDriver();
        if(driver.conecta()){
            MenuHandler menuHandler = new MenuHandler(epaPadreEustaquio, null, driver, produtoDAO);
            menuHandler.select("p");
        }

        System.out.println();
        System.out.println("::: PAF em Console ::::");
        System.out.println("Empresa: " + epaPadreEustaquio.getNome());
        System.out.println("PAF em Console encerrado");
        System.out.println();

        System.out.println("--------------------------");

    }

    public static Empresa createEmpresa(){
        return new Empresa("08314547000173", "Posto e Conveniência Meninas Superpoderosas", "R Pe Eustáquio, 2354. Praia Grande, Arraial do Cabo - RJ");
    }

}
