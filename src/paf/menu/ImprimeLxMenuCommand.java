package paf.menu;

import paf.Empresa;
import paf.ImpressoraFiscal;
import paf.Usuario;

public class ImprimeLxMenuCommand extends MenuCommand {


    public ImprimeLxMenuCommand(MenuHandler menuHandler, ImpressoraFiscal ecf, Empresa empresa, Usuario usuario) {
        super(menuHandler, ecf, empresa, usuario);
    }

    @Override
    public void execute() {
        doMenuImprimeLx();
    }

    private void doMenuImprimeLx(){
        ecf.printLeituraX(empresa);
        System.out.println("Leitura X impressa.");
        menuHandler.select("p");
    }
}
