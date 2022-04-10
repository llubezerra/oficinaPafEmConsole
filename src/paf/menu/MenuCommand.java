package paf.menu;

import br.com.ecfsim.EcfSimDriver;
import paf.Empresa;
import paf.Usuario;

import java.util.Scanner;

public abstract class MenuCommand {

    protected final int LINE_QTY = 2;

    protected Scanner keyboardScanner;
    protected MenuHandler menuHandler;
    protected Empresa empresa;
    protected Usuario usuario;
    protected EcfSimDriver ecf;

    public MenuCommand(MenuHandler menuHandler, EcfSimDriver ecf, Empresa empresa, Usuario usuario) {
        keyboardScanner = new Scanner(System.in);
        this.menuHandler = menuHandler;
        this.ecf = ecf;
        this.empresa = empresa;
        this.usuario = usuario;
    }

    public abstract void execute();
}
