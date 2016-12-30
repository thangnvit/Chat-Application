package org.thangnv.messenger_data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by DEV on 12/10/2016.
 */
public class sqlDataProvider  {
    private String hostName;
    private String dataBase;
    private String user;
    private String password;
    private String strConn;
    private Connection connection = null;
    public sqlDataProvider(String hostName, String dataBase, String user, String password) {
        this.hostName = hostName;
        this.dataBase = dataBase;
        this.user = user;
        this.password = password;

        strConn = "jdbc:sqlserver://"+ hostName+":1433;databaseName="+dataBase+";user="+user+";password="+password+";";
    }

    public Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(strConn);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
