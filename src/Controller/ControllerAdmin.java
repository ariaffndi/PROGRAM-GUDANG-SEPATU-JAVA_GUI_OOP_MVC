package Controller;

import Entity.EntityAdmin;
import Model.ModelAdmin;

public class ControllerAdmin {
    ModelAdmin modelAdmin = new ModelAdmin();

    public void controllerCreateAdmin (String username, String password) {
        EntityAdmin admin = new EntityAdmin(username, password);
        modelAdmin.createAdmin(admin);
    }

    public boolean controllerCekLogin (String username, String password) {
        return modelAdmin.cekLogin(username, password);
    }

}
