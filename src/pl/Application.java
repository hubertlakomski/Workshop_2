package pl;

import pl.models.menus.userMenu.UserPanel;

public class Application {

    public static void main(String[] args) {

        UserPanel userPanel = new UserPanel();

        while(true) {
            userPanel.turn();
        }

    }
}
