package org.thangnv.messenger_Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by DEV on 1/4/2017.
 */
public class messageDAL extends sqlDataProvider {
    public ArrayList<messageInfo> messageInfoGetByTop(String top, String where, String order) {
        ArrayList<messageInfo> list = new ArrayList<>();
        String selectQuery = "Select";

        if (top.length() != 0) {
            selectQuery += " Top " + top;
        }
        selectQuery += " * from Message ";
        if (where.length() != 0) {
            selectQuery += " Where " + where;
        }
        if (order.length() != 0) {
            selectQuery += " Order By " + order;
        }

        try (Statement statement = getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(selectQuery);

            while (rs.next()) {
                messageInfo obj = new messageInfo();
                obj.messageInfoResultSet(rs);
                list.add(obj);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertMessage(messageInfo messageInfo){
        String selectQuery = "insert into Message values ('"+messageInfo.getIdSender()+"','"+messageInfo.getIdRecipient()+"','"+messageInfo.getDateSend()+"',N'"+messageInfo.getContent()+"')";
        try(Statement st = getConnection().createStatement()) {
            st.executeUpdate(selectQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
