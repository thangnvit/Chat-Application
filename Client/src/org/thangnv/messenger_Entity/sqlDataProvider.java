package org.thangnv.messenger_Entity;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by DEV on 12/10/2016.
 */
public class sqlDataProvider  {
    private final String hostName = "localhost";
    private final String dataBase = "Messenger";
    private final String user = "sa";
    private final String password = "123456";
    private static String strConn;
    private static Connection connection = null;
    public sqlDataProvider() {
        strConn = "jdbc:sqlserver://"+ hostName+":1433;databaseName="+dataBase+";user="+user+";password="+password+";";
    }

    public static Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(strConn);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        System.out.println(new sqlDataProvider().getConnection());
    }

}
