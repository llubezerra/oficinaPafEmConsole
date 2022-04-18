package paf;

import br.com.ecfsim.FormaPagamento;

public interface ImpressoraFiscal {

    boolean connect();
    void printAbreCupom(Cupom cupom);
    void printVendeItem(Cupom cupom);
    void printIniciaFechamentoCupom();
    void printEfetuaFormaPagamento(FormaPagamento forma);
    void printTerminaFechamentoCupom();
    void printLeituraX(Empresa empresa);
    void printAndExportLeituraX(Empresa empresa);

}