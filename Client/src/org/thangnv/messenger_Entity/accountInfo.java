package org.thangnv.messenger_Entity;

import java.util.Date;

/**
 * Created by DEV on 1/1/2017.
 */
public class accountInfo {
    private String accountId;
    private String FirstName;
    private String surName;
    private String address;
    private Date birthDay;

    public accountInfo(String accountId, String firstName, String surName, String address, Date birthDay) {
        this.accountId = accountId;
        FirstName = firstName;
        this.surName = surName;
        this.address = address;
        this.birthDay = birthDay;
    }


}
