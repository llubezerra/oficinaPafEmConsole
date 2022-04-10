package paf.menu;

import br.com.ecfsim.EcfSimDriver;
import paf.Empresa;
import paf.Usuario;

public class ExportaLxMenuCommand extends MenuCommand {


    public ExportaLxMenuCommand(MenuHandler menuHandler, EcfSimDriver ecf, Empresa empresa, Usuario usuario) {
        super(menuHandler, ecf, empresa, usuario);
    }

    @Override
    public void execute() {
    doMenuExportaLx();
    }

    private void doMenuExportaLx(){
        System.out.println("Leitura X impressa e exportada.");
        menuHandler.select("p");
    }
}
