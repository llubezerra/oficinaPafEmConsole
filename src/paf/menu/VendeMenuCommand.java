package paf.menu;

import paf.*;

public class VendeMenuCommand extends MenuCommand {

    private ProdutoDAO produtoDAO;
    private Cupom cupom;

    public VendeMenuCommand(MenuHandler menuHandler, Empresa empresa, Usuario usuario, ProdutoDAO produtoDAO) {
        super(menuHandler, empresa, usuario);
        this.produtoDAO = produtoDAO;
    }

    @Override
    public void execute() {
        doMenuVendas();
    }

    private void doMenuVendas(){
        doVendaPasso1();
    }

    private void doVendaPasso1(){
        cupom = new Cupom(empresa, null, null);
    }

    private void doVendaPasso2(){
        System.out.println("[ PAF em Console > Menu Principal > Menu de Vendas ]");
        System.out.print("Digite o código de barras do produto: ");
        String codigoDeBarras = keyboardScanner.nextLine();
        System.out.println("Digite a quantidade do produto: ");
        double quantidade = keyboardScanner.nextDouble();

        Produto produto = produtoDAO.findBy(codigoDeBarras);
        if(produto != null)
            cupom.addItem(produto, quantidade);
        else
            System.out.println("Produto não encontrado.");

        doVendaPasso3();
    }

    private void doVendaPasso3(){
        System.out.println("[ PAF em Console > Menu Principal > Menu de Vendas ]");
        System.out.println("Deseja vender outro item? Digite: ");
        System.out.println("s - sim, vende outro item.");
        System.out.println("n - não, fecha o cupom fiscal.");
        System.out.print("= ");

        String opcaoMenu = keyboardScanner.nextLine();
        keyboardScanner.next();
        if(opcaoMenu.equals("s"))
            doVendaPasso2();
        else if(opcaoMenu.equals("n"))
            doVendaPasso4();
        else {
            System.out.println("Opção incorreta");
            doVendaPasso3();
        }
    }

    private void doVendaPasso4(){

    }
}
