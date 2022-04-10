package paf.menu;

import paf.Empresa;
import paf.Usuario;

public class SaiMenuCommand extends MenuCommand {


    public SaiMenuCommand(MenuHandler menuHandler, Empresa empresa, Usuario usuario) {
        super(menuHandler, null, empresa, usuario);
    }

    @Override
    public void execute() {

    }
}
