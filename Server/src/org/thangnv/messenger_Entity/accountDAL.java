package org.thangnv.messenger_Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by DEV on 1/4/2017.
 */
public class accountDAL extends sqlDataProvider {

    public ArrayList<account> accountGetByTop(String top, String where, String order) {
        ArrayList<account> list = new ArrayList<account>();
        String selcetQuery = "select";

        if (top.length() != 0) {
            selcetQuery += " Top " + top;
        }

        selcetQuery += " * from Account ";

        if (where.length() != 0) {
            selcetQuery += " Where " + where;
        }

        if (order.length() != 0) {
            selcetQuery += " Order By " + order;
        }

        try (Statement statement = getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(selcetQuery);

            while (rs.next()) {
                account obj = new account();
                obj.accountResultSet(rs);
                list.add(obj);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
