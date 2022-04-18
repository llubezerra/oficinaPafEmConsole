package paf;

import br.com.ecfsim.EcfSimDriver;
import br.com.ecfsim.FormaPagamento;

public class IFEcfSim implements ImpressoraFiscal {

    private EcfSimDriver driver;

    public IFEcfSim(){
        driver = new EcfSimDriver();
    }

    @Override
    public boolean connect() {
        return driver.conecta();
    }

    @Override
    public void printAbreCupom(Cupom cupom) {
        driver.abreCupom(cupom.getEmpresa().getCnpj(), cupom.getEmpresa().getNome(), cupom.getEmpresa().getEndereco(), cupom.getCliente().getDocIndvdl());
    }

    @Override
    public void printVendeItem(Cupom cupom) {
        driver.vendeItem(cupom.getUltimoItem().getProduto().getCodigoDeBarras(), cupom.getUltimoItem().getProduto().getDescricao(), cupom.getUltimoItem().getQuantidade(),
                cupom.getUltimoItem().getProduto().getUnidade().toString(), cupom.getUltimoItem().getProduto().getValorUnitario());
    }

    @Override
    public void printIniciaFechamentoCupom() {
        driver.iniciaFechamentoCupom();
    }

    @Override
    public void printEfetuaFormaPagamento(FormaPagamento forma) {
        driver.efetuaFormaPagamento(forma);
    }

    @Override
    public void printTerminaFechamentoCupom() {
        driver.terminaFechamentoCupom();
    }

    @Override
    public void printLeituraX(Empresa empresa) {
        driver.imprimeLeituraX(empresa.getCnpj(), empresa.getNome(), empresa.getEndereco());
    }

    @Override
    public void printAndExportLeituraX(Empresa empresa) {
        driver.imprimeEExportaLeituraX(empresa.getCnpj(), empresa.getNome(), empresa.getEndereco());
    }
}
