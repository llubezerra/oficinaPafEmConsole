package paf.menu;

import paf.Empresa;
import paf.Usuario;

import java.util.HashMap;
import java.util.Map;

public class MenuHandler {

    public enum MenuTipo {
        PRINCIPAL, VENDAS, LX_IMPRIME, LX_EXPORTA, SAI;
    }

    private Map<MenuTipo, MenuCommand> menuMap = new HashMap<MenuTipo, MenuCommand>();

    public MenuHandler(Empresa empresa, Usuario usuario){
        menuMap.put(MenuTipo.PRINCIPAL, new PrincipalMenuCommand(this, empresa, usuario));
        menuMap.put(MenuTipo.VENDAS, new VendeMenuCommand(this, empresa, usuario));
        menuMap.put(MenuTipo.LX_IMPRIME, new ImprimeLxMenuCommand(this, empresa, usuario));
        menuMap.put(MenuTipo.LX_EXPORTA, new ExportaLxMenuCommand(this, empresa, usuario));
        menuMap.put(MenuTipo.SAI, new SaiMenuCommand(this, empresa, usuario));
    }
}
