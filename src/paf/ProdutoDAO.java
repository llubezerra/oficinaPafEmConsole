package paf;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ProdutoDAO {

    private PafDatabase db;
    private List<Produto> produtosBD;

    public ProdutoDAO(PafDatabase db) {
        this.db = db;
    }

    public void load() {
        Statement stm = db.createStatement();
        try {
            stm.execute("DROP TABLE IF EXISTS produts;");
            stm.execute("CREATE TABLE IF NOT EXISTS produtos(" +
                            "produtosId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "codigoDeBarras TEXT NOT NULL, " +
                            "descricao TEXT NOT NULL, " +
                            "unidade TEXT NOT NULL, " +
                            "valorUnitario REAL NOT NULL" +
                    ");");
            stm.executeUpdate(
                    "INSERT INTO produtos(codigoDeBarras, descricao, unidade, valorUnitario) VALUES " +
                            "('7891', 'Café 3 Corações', 'PCT', 9.98)" +
                            "('7892', 'Arroz Agulhinha Tipo 1 Tia Ju', 'PCT', 17.48)" +
                            "('7893', 'Feijão Carioca Codil', 'PCT', 5.78)" +
                            "('7894', 'File de Peito de Frango Congelado Sadia', 'BDJ', 14.9)" +
                            "('7895', 'Gasolina BR', 'LTR', 8.19);"
            );
        } catch(SQLException e){
            System.err.println(e.getMessage());
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public Produto findBy(String codigoDeBarras){
        for(Produto p : produtosBD)
            if(p.getCodigoDeBarras().equals(codigoDeBarras))
                return p;

        return null;
    }
}
