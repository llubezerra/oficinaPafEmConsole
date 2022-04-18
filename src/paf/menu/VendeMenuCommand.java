package paf.menu;

import paf.*;
import br.com.ecfsim.FormaPagamento;

public class VendeMenuCommand extends MenuCommand {

    private ProdutoDAO produtoDAO;
    private Cupom cupom;

    public VendeMenuCommand(MenuHandler menuHandler, ImpressoraFiscal ecf, Empresa empresa, Usuario usuario, ProdutoDAO produtoDAO) {
        super(menuHandler, ecf, empresa, usuario);
        this.produtoDAO = produtoDAO;
    }

    @Override
    public void execute() {
        doIniciaVenda();
    }

    //Passo 1
    private void doIniciaVenda(){
        cupom = new Cupom(empresa, Main.cliente, null);
        ecf.printAbreCupom(cupom);

        doAdicionaItem();
    }

    //Passo 2
    private void doAdicionaItem(){
        System.out.println("[ PAF em Console > Menu Principal > Menu de Vendas ]");
        System.out.print("Digite o código de barras do produto: ");
        String codigoDeBarras = keyboardScanner.next();
        System.out.print("Digite a quantidade do produto: ");
        double quantidade = keyboardScanner.nextDouble();

        System.out.println(System.lineSeparator().repeat(LINE_QTY));

        Produto produto = produtoDAO.findBy(codigoDeBarras);
        if(produto != null){
            cupom.addItem(produto, quantidade);
            ecf.printVendeItem(cupom);
        }else
            System.out.println("Produto não encontrado.");

        doConsultaSeNovoItem();
    }

    //Passo 3
    private void doConsultaSeNovoItem(){
        System.out.println("[ PAF em Console > Menu Principal > Menu de Vendas ]");
        System.out.println("Deseja vender outro item? Digite: ");
        System.out.println("s - sim, vende outro item.");
        System.out.println("n - não, fecha o cupom fiscal.");
        System.out.print("= ");

        String opcaoMenu = keyboardScanner.next();

        System.out.println(System.lineSeparator().repeat(LINE_QTY));

        if(opcaoMenu.equals("s"))
            doAdicionaItem();
        else if(opcaoMenu.equals("n"))
            doInformaFormaPgto();
        else {
            System.out.println("Opção incorreta");
            doConsultaSeNovoItem();
        }
    }

    //Passo 4
    private void doInformaFormaPgto(){

        System.out.println("[ PAF em Console > Menu Principal > Menu de Vendas ]");
        System.out.println("Escolha a forma de pagamento:");
        System.out.println(FormaPagamento.DINHEIRO.ordinal() + " - Dinheiro");
        System.out.println(FormaPagamento.CARTAO_DEBITO.ordinal() + " - Cartão de débito");
        System.out.println(FormaPagamento.CARTAO_CREDITO.ordinal() + " - Cartão de crédito");
        System.out.print("= ");

        int formaPgto = keyboardScanner.nextInt();
        ecf.printEfetuaFormaPagamento(FormaPagamento.values()[formaPgto]);

        System.out.println(System.lineSeparator().repeat(LINE_QTY));

        doFechaVenda();
    }

    //Passo 5
    private void doFechaVenda(){
        ecf.printTerminaFechamentoCupom();
        System.out.println("Venda fechada.");

        System.out.println(System.lineSeparator().repeat(LINE_QTY));

        menuHandler.select("p");
    }
}
