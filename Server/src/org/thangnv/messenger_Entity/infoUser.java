package org.thangnv.messenger_Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by DEV on 1/3/2017.
 */
public class infoUser {
    private String accountId;
    private String firstName;
    private String surName;
    private String address;
    private Date birthday;

    public infoUser(String accountId, String firstName, String surName, String address, Date birthday) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.surName = surName;
        this.address = address;
        this.birthday = birthday;
    }

    public infoUser() {
    }

    public void infoUserResultSet(ResultSet rs) throws SQLException {
        accountId = rs.getString("AccountID");
        firstName = rs.getString("FirstName");
        surName = rs.getString("SurName");
        address = rs.getString("Address");
        birthday = rs.getDate("BirthDay");
    }

    public String getAccountId() {
        return accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getAddress() {
        return address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
