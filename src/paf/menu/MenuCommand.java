package paf.menu;

import paf.Empresa;
import paf.ImpressoraFiscal;
import paf.Usuario;

import java.util.Scanner;

public abstract class MenuCommand {

    protected final int LINE_QTY = 2;

    protected Scanner keyboardScanner;
    protected MenuHandler menuHandler;
    protected Empresa empresa;
    protected Usuario usuario;
    protected ImpressoraFiscal ecf;

    public MenuCommand(MenuHandler menuHandler, ImpressoraFiscal ecf, Empresa empresa, Usuario usuario) {
        keyboardScanner = new Scanner(System.in);
        this.menuHandler = menuHandler;
        this.ecf = ecf;
        this.empresa = empresa;
        this.usuario = usuario;
    }

    public abstract void execute();
}
