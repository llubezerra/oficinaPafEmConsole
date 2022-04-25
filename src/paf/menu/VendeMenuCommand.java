package paf.menu;

import paf.*;
import br.com.ecfsim.FormaPagamento;

public class VendeMenuCommand extends MenuCommand {

    private ProdutoDAO produtoDAO;
    private Cliente cliente;
    private Cupom cupom;

    public VendeMenuCommand(MenuHandler menuHandler, ImpressoraFiscal ecf, Empresa empresa, Usuario usuario, ProdutoDAO produtoDAO) {
        super(menuHandler, ecf, empresa, usuario);
        this.produtoDAO = produtoDAO;
    }

    @Override
    public void execute() {
        doAdicionaCliente();
    }

    //Passo 1
    private void doAdicionaCliente(){
        System.out.println("[ PAF em Console > Menu Principal > Menu de Vendas ]");
        System.out.println("Deseja identificar o cliente? Digite:");
        System.out.println("s - sim, o cliente deseja ser identificado.");
        System.out.println("n - não, o cliente não deseja ser identificado.");
        System.out.print("= ");

        String opcaoMenu = keyboardScanner.next();

        if(opcaoMenu.equals("s")) {
            System.out.println("Digite 1 para pessoa física.");
            System.out.println("Digite 2 para pessoa jurídica");

            String opcaoMenu2 = keyboardScanner.next();

            if(opcaoMenu2.equals("1")) {
                System.out.println("Digite o CPF do cliente: ");
                String cpf = keyboardScanner.next();
                cliente = new PessoaFisica(cpf, "", "", "");
            } else if(opcaoMenu2.equals("2")){
                System.out.println("Digite o CNPJ do cliente: ");
                String cnpj = keyboardScanner.next();
                cliente = new PessoaJuridica(cnpj, "", "", "", "");
            } else{
                System.out.println("Opção inválida");
            }

        }else
            cliente = null;

        System.out.println(System.lineSeparator().repeat(LINE_QTY));
        doIniciaVenda();
    }

    //Passo 2
    private void doIniciaVenda(){
        cupom = new Cupom(empresa, cliente, null);
        ecf.printAbreCupom(cupom);

        doAdicionaItem();
    }

    //Passo 3
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

    //Passo 4
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
        else if(opcaoMenu.equals("n")) {
            ecf.printIniciaFechamentoCupom();
            doInformaFormaPgto();
        }else {
            System.out.println("Opção incorreta");
            doConsultaSeNovoItem();
        }
    }

    //Passo 5
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

    //Passo 6
    private void doFechaVenda(){
        ecf.printTerminaFechamentoCupom();
        System.out.println(System.lineSeparator().repeat(LINE_QTY));

        menuHandler.select("p");
    }
}
