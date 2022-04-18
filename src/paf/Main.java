package paf;

import paf.menu.MenuHandler;

public class Main {

    public static Cliente cliente = new PessoaFisica("000.111.222-34", "Teste", "Teste", "2299999-0000");
    public static void main(String[] args) {

        Empresa epaPadreEustaquio = createEmpresa();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        ImpressoraFiscal ecf = new IFEcfSim();
        if(ecf.connect()){
            MenuHandler menuHandler = new MenuHandler(epaPadreEustaquio, null, ecf, produtoDAO);
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
