package pl;

import pl.models.menus.adminMenu.AdminMenu;
import pl.models.menus.userMenu.UserPanel;

import java.util.Scanner;

public class Application {

    private static String ADMIN_PASSWORD = "pass";

    public static void main(String[] args) {

        String userData = "";

        while(true) {

            if(!userData.equals(ADMIN_PASSWORD)) {
                Scanner input = new Scanner(System.in);
                System.out.print("Jak wiesz co to wpisz: ");
                userData = input.next();
            }

            if(userData.equals(ADMIN_PASSWORD)){
                AdminMenu adminMenu = new AdminMenu();
                adminMenu.turn();
            }
            else {
                UserPanel userPanel = new UserPanel();
                userPanel.turn();
            }

        }

    }
}
