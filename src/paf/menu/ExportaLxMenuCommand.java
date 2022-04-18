package paf.menu;

import paf.Empresa;
import paf.ImpressoraFiscal;
import paf.Usuario;

public class ExportaLxMenuCommand extends MenuCommand {


    public ExportaLxMenuCommand(MenuHandler menuHandler, ImpressoraFiscal ecf, Empresa empresa, Usuario usuario) {
        super(menuHandler, ecf, empresa, usuario);
    }

    @Override
    public void execute() {
    doMenuExportaLx();
    }

    private void doMenuExportaLx(){
        ecf.printAndExportLeituraX(empresa);
        System.out.println("Leitura X impressa e exportada.");
        menuHandler.select("p");
    }
}
