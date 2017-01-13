package org.thangnv.messenger_bussiness;

import org.thangnv.messenger_Entity.messageDAL;
import org.thangnv.messenger_Entity.messageInfo;

import java.util.ArrayList;

/**
 * Created by DEV on 1/6/2017.
 */
public class messageService {
    private static messageDAL messageDAL = new messageDAL();

    public static ArrayList<messageInfo> messageInfoGetByTop(String top, String where, String order){
        return messageDAL.messageInfoGetByTop("","","");
    }

    public static void insertMessage(messageInfo messageInfo){
        messageDAL.insertMessage(messageInfo);
    }
}
