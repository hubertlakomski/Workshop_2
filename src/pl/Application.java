package pl;

import pl.models.menus.adminMenu.AdminMenu;
import pl.models.menus.adminMenu.SolutionMenu;

public class Application {

    public static void main(String[] args) {

        SolutionMenu solutionMenu = new SolutionMenu();

        while(true){
            AdminMenu adminMenu = new AdminMenu();

            adminMenu.turn();
        }


    }
}
