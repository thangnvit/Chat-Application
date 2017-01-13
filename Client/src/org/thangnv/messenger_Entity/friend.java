package org.thangnv.messenger_Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by DEV on 1/5/2017.
 */
public class friend {
    private String username;
    private String avatar;
    private String lastContent;

    public friend(String username, String avatar, String lastContent) {
        this.username = username;
        this.avatar = avatar;
        this.lastContent = lastContent;
    }

    public friend() {
    }

    public void friendResultSet(ResultSet rs) throws SQLException {
        username = rs.getString("Username");
        avatar = rs.getString("Image");
        lastContent = rs.getString("Content");
    }

    public String getUsername() {
        return username;
    }

    public String getImage() {
        return avatar;
    }

    public String getLastContent() {
        return lastContent;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public void setImage(String image) {
        this.avatar = image;
    }

    public void setLastContent(String lastContent) {
        this.lastContent = lastContent;
    }
}
