package paf.menu;

import br.com.ecfsim.EcfSimDriver;
import paf.*;

import java.util.List;

public class VendeMenuCommand extends MenuCommand {

    private ProdutoDAO produtoDAO;
    private Cupom cupom;

    public VendeMenuCommand(MenuHandler menuHandler, EcfSimDriver ecf, Empresa empresa, Usuario usuario, ProdutoDAO produtoDAO) {
        super(menuHandler, ecf, empresa, usuario);
        this.produtoDAO = produtoDAO;
    }

    @Override
    public void execute() {
        doMenuVendas();
    }

    private void doMenuVendas(){
        doIniciaVenda();
    }

    //Passo 1
    private void doIniciaVenda(){
        cupom = new Cupom(empresa, null, null);
        ecf.abreCupom(empresa.getCnpj(), empresa.getNome(), empresa.getEndereco(), "");

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
            List<ItemDoCupom> itensDoCupom1 = cupom.getItens();
            for(ItemDoCupom i : itensDoCupom1) {
                //String unid = toString(i.getProduto().getUnidade());
                ecf.vendeItem(i.getProduto().getCodigoDeBarras(), i.getProduto().getDescricao(), i.getQuantidade(), "", i.getValor());
            }
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
        System.out.println("0 - Dinheiro");
        System.out.println("1 - Cartão de débito");
        System.out.println("2 - Cartão de crédito");
        System.out.print("= ");

        int formaPgto = keyboardScanner.nextInt();

        System.out.println(System.lineSeparator().repeat(LINE_QTY));

        doFechaVenda();
    }

    //Passo 5
    private void doFechaVenda(){
        System.out.println("Venda fechada.");

        System.out.println(System.lineSeparator().repeat(LINE_QTY));

        menuHandler.select("p");
    }
}
