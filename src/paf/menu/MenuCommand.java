package paf.menu;

import paf.Empresa;
import paf.Usuario;

import java.util.Scanner;

public abstract class MenuCommand {

    protected final int LINE_QTY = 2;

    protected Scanner keyboardScanner;
    protected MenuHandler menuHandler;
    protected Empresa empresa;
    protected Usuario usuario;

    public MenuCommand(MenuHandler menuHandler, Empresa empresa, Usuario usuario) {
        keyboardScanner = new Scanner(System.in);
        this.menuHandler = menuHandler;
        this.empresa = empresa;
        this.usuario = usuario;
    }

    public abstract void execute();
}
