package EduSys.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Jdbc {

//    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    private static final String DB_URL = "jdbc:sqlserver://WebStore.mssql.somee.com;database=WebStore;encrypt=true;trustServerCertificate=true;";
//    private static final String USERNAME = "songlong_SQLLogin_1";
//    private static final String PASSWORD = "p5xhkkw67t";
    
    
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=edusys1;encrypt=true;trustServerCertificate=true;";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "Son15@2";
    private static Connection connection;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    private static PreparedStatement createPreparedStatement(String sql, Object... values) {
        try {
            PreparedStatement ps = Jdbc.getConnection().prepareStatement(sql);
            for (int i = 0; i < values.length; i++) { // set Parameters
                ps.setObject(i + 1, values[i]);
            }
            return ps;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static int executeUpdate(String sql, Object... values) {
        PreparedStatement ps = Jdbc.createPreparedStatement(sql, values);
        try {
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static ResultSet executeQuery(String sql, Object... values) {
        PreparedStatement ps = Jdbc.createPreparedStatement(sql, values);
        try {
            return ps.executeQuery();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static <T> T getValue(String sql, Object... values) {
        ResultSet rs = Jdbc.executeQuery(sql, values);
        try {
            rs.next();
            return (T) rs.getObject(1);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}