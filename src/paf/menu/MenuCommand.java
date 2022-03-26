package paf.menu;

import paf.Empresa;
import paf.Usuario;

import java.util.Scanner;

public abstract class MenuCommand {

    protected Scanner keyboardScanner;
    protected MenuHandler menuHandler;
    protected Empresa empresa;
    protected Usuario usuario;

    public MenuCommand(MenuHandler menuHandler, Empresa empresa, Usuario usuario) {
        this.keyboardScanner = keyboardScanner;
        this.menuHandler = menuHandler;
        this.empresa = empresa;
        this.usuario = usuario;
    }

    public abstract void execute();
}
