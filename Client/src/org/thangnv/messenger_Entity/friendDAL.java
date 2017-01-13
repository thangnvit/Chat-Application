package org.thangnv.messenger_Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by DEV on 1/5/2017.
 */
public class friendDAL extends sqlDataProvider {
    public ArrayList<friend> getListFirend(String accountId){
        ArrayList<friend> list = new ArrayList<>();
        String selectQuery = "select Username,Content,Image from Account,Message,InfoUser where Account.AccountID = InfoUser.AccountID and Account.AccountID = Message.IdSender and IdRecipient = '"+ accountId +"'";

        try(Statement statement = getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(selectQuery);

            while (rs.next()){
                friend obj = new friend();
                obj.friendResultSet(rs);
                list.add(obj);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
