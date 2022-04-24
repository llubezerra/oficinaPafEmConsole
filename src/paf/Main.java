package paf;

import paf.menu.MenuHandler;

public class Main {

    public static void main(String[] args) {

        Empresa epaPadreEustaquio = createEmpresa();

        PafDatabase db = new PafDatabase();
        if(db.connect()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(db);
            produtoDAO.load();

            ImpressoraFiscal ecf = new IFEcfSim();
            if(ecf.connect()){
                MenuHandler menuHandler = new MenuHandler(epaPadreEustaquio, null, ecf, produtoDAO);
                menuHandler.select("p");
            }
            db.disconnect();
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
