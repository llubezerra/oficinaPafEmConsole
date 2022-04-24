package paf;

import java.io.File;
import java.net.URISyntaxException;
import java.sql.*;

public class PafDatabase {

    private final String DATABASE_NAME = "paf.db";
    private Connection conn;

    private String getJarPath(){
        String path = "";
        try {
            path = new File(ClassLoader.getSystemClassLoader().getResource(".").toURI()).getPath().concat(File.separator);
        } catch (URISyntaxException e) {
            System.err.println(e.getMessage());
        }
        return path;
    }

    public boolean connect(){
        try {
            String dbUri = "jdbc:sqlite:".concat(getJarPath()).concat(DATABASE_NAME);
            conn = DriverManager.getConnection(dbUri);
            return true;
        } catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    public void disconnect(){
        try {
            if(!conn.isClosed())
                conn.close();
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    //Execução de strings SQL estáticas
    public Statement createStatement() {
        try {
            return conn.createStatement();
        } catch (SQLException e) {
            return null;
        }
    }

    //Execução de strings SQL dinâmicas (com parâmetros variáveis)
    public PreparedStatement createPreparedStatement(String sqlStatement) {
        try {
           return  conn.prepareStatement(sqlStatement);
        } catch (SQLException e) {
            return null;
        }
    }

}
