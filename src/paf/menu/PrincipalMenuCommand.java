package paf.menu;

import paf.Empresa;
import paf.Usuario;

public class PrincipalMenuCommand extends MenuCommand {


    public PrincipalMenuCommand(MenuHandler menuHandler, Empresa empresa, Usuario usuario) {
        super(menuHandler, null, empresa, usuario);
    }

    @Override
    public void execute() {
        doMenuPrincipal();
    }

    private void doMenuPrincipal(){
        System.out.println("[ PAF em Console > Menu Principal ]");

        System.out.println("Digite: ");
        System.out.println("v - Efetuar venda");
        System.out.println("i - Imprimir Leitura X");
        System.out.println("e - Imprimir e exportar Leitura X");
        System.out.println("s - Sair");
        System.out.print("= ");

        String opcaoDoMenu = keyboardScanner.nextLine();
        System.out.println(System.lineSeparator().repeat(LINE_QTY));

        menuHandler.select(opcaoDoMenu);

    }
}
