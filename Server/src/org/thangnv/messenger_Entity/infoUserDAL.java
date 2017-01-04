package org.thangnv.messenger_Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by DEV on 1/4/2017.
 */
public class infoUserDAL extends sqlDataProvider{
    public ArrayList<infoUser> infoUserGetByTop(String top,String where,String order){
        ArrayList<infoUser> list = new ArrayList<>();
        String selectQuery = "select";

        if (top.length() != 0){
            selectQuery += " Top " + top;
        }
        selectQuery += " * from InfoUser";
        if (where.length() !=0){
            selectQuery += "Where" + where;
        }
        if (order.length() !=0){
            selectQuery += " Order By "  + order;
        }

        try(Statement statement = getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(selectQuery);

            while (rs.next()){
                infoUser obj = new infoUser();
                obj.infoUserResultSet(rs);
                list.add(obj);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
