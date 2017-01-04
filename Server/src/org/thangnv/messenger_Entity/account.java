package org.thangnv.messenger_Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by DEV on 1/3/2017.
 */
public class account {
    private String accountId;
    private String userName;
    private String password;

    public account(String accountId, String userName, String passWord) {
        this.accountId = accountId;
        this.userName = userName;
        this.password = passWord;
    }

    public account() {
    }

    public void accountResultSet(ResultSet rs) throws SQLException {
        accountId = rs.getString("AccountID");
        userName = rs.getString("Username");
        password = rs.getString("Password");
    }


    public String getAccountId() {
        return accountId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return password;
    }

    public void setAccountId(String accountId) {

        this.accountId = accountId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.password = passWord;
    }

}

