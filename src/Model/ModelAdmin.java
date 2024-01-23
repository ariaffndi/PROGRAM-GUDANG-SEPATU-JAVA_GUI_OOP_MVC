package Model;

import Database.Database;
import Entity.EntityAdmin;

public class ModelAdmin {

    public void createAdmin(EntityAdmin admin) {
        Database.databaseAdmin.add(admin);
    }


    public boolean cekLogin(String username, String password) {
        boolean login = false;
        for (EntityAdmin admin : Database.databaseAdmin) {
            if(admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                login = true;
            }
        }
        return login;
    }

}
