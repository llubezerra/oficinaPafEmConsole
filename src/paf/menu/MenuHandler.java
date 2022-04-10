package paf.menu;

import br.com.ecfsim.EcfSimDriver;
import paf.Empresa;
import paf.ProdutoDAO;
import paf.Usuario;

import java.util.HashMap;
import java.util.Map;

public class MenuHandler {

    public enum MenuTipo {
        PRINCIPAL("p"), VENDAS("v"), LX_IMPRIME("i"), LX_EXPORTA("e"), SAI("s");

        private String label;

        private MenuTipo(String label){
            this.label = label;
        }

        public static MenuTipo valueOfLabel(String label){
            for(MenuTipo menu : values())
                if(menu.label.equals(label))
                    return menu;
            return null;
        }
    }

    private Map<MenuTipo, MenuCommand> menuMap = new HashMap<MenuTipo, MenuCommand>();
    private MenuCommand curMenu;

    public MenuHandler(Empresa empresa, Usuario usuario, EcfSimDriver ecf, ProdutoDAO produtoDAO){
        menuMap.put(MenuTipo.PRINCIPAL, new PrincipalMenuCommand(this, empresa, usuario));
        menuMap.put(MenuTipo.VENDAS, new VendeMenuCommand(this, ecf, empresa, usuario, produtoDAO));
        menuMap.put(MenuTipo.LX_IMPRIME, new ImprimeLxMenuCommand(this, ecf, empresa, usuario));
        menuMap.put(MenuTipo.LX_EXPORTA, new ExportaLxMenuCommand(this, ecf, empresa, usuario));
        menuMap.put(MenuTipo.SAI, new SaiMenuCommand(this, empresa, usuario));
    }

    public void select(String menuLabel) {
        curMenu = menuMap.get(MenuTipo.valueOfLabel(menuLabel));
        curMenu.execute();
    }
}
