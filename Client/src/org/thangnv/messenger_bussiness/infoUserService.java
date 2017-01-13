package org.thangnv.messenger_bussiness;

import org.thangnv.messenger_Entity.infoUser;
import org.thangnv.messenger_Entity.infoUserDAL;

import java.util.ArrayList;

/**
 * Created by DEV on 1/6/2017.
 */
public class infoUserService {
    private static infoUserDAL infoUserDAL = new infoUserDAL();

    public static ArrayList<infoUser> infoUserGetByTop(String top, String where, String order){
        return  infoUserDAL.infoUserGetByTop("","","");
    }
}
