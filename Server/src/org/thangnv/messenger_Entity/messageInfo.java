package org.thangnv.messenger_Entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by DEV on 1/1/2017.
 */
public class messageInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idSender;
    private String idRecipient;
    private Date dateSend;
    private Object content;

    public messageInfo() {
    }

    public messageInfo(String idSender, String idRecipient, Date dateSend, Object content) {
        this.idSender = idSender;
        this.idRecipient = idRecipient;
        this.dateSend = dateSend;
        this.content = content;
    }

    public void messageInfoResultSet(ResultSet rs) throws SQLException {
        idSender = rs.getString("IdSender");
        idRecipient = rs.getString("IdRecipient");
        dateSend = rs.getDate("DateSend");
        content = rs.getString("Content");
    }


    public String getIdSender() {
        return idSender;
    }

    public String getIdRecipient() {
        return idRecipient;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public Object getContent() {
        return content;
    }

    public void setIdSender(String idSender) {

        this.idSender = idSender;
    }

    public void setIdRecipient(String idRecipient) {
        this.idRecipient = idRecipient;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
