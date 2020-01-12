package pl;

import pl.models.adminMenus.AdminMenu;
import pl.models.adminMenus.SolutionMenu;

public class Application {

    public static void main(String[] args) {

        SolutionMenu solutionMenu = new SolutionMenu();

        while(true){
            AdminMenu adminMenu = new AdminMenu();

            adminMenu.turn();
        }


    }
}
