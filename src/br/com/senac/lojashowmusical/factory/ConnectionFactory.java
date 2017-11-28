package br.com.senac.lojashowmuscial.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            String dbURL = "jdbc:sqlserver://localhost:1433;"
                    + " databaseName=LOJA_DE_MUSICA";
            Properties properties = new Properties();
            properties.put("db_driver",
                    "com.microsoft.jdbc.sqlserver.SQLServerDriver");
            //PREENCHER!!
            properties.put("user", "aluno");
            properties.put("password", "senac");
            connection = DriverManager.getConnection(dbURL, properties);
        }
        return connection;
    }

    public static void closeConnection(Connection conn,
            PreparedStatement pstm, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection conn,
            PreparedStatement pstm) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstm != null) {
                pstm.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
