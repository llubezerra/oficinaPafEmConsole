package paf.menu;

import br.com.ecfsim.EcfSimDriver;
import paf.Empresa;
import paf.Usuario;

public class ImprimeLxMenuCommand extends MenuCommand {


    public ImprimeLxMenuCommand(MenuHandler menuHandler, EcfSimDriver ecf, Empresa empresa, Usuario usuario) {
        super(menuHandler, ecf, empresa, usuario);
    }

    @Override
    public void execute() {
        doMenuImprimeLx();
    }

    private void doMenuImprimeLx(){
        System.out.println("Leitura X impressa.");
    }
}
