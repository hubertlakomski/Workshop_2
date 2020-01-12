package pl;

import pl.models.menu.BasicMenu;
import pl.models.menu.SolutionMenu;

public class Application {

    public static void main(String[] args) {

        SolutionMenu solutionMenu = new SolutionMenu();

        while(true){
            BasicMenu basicMenu = new BasicMenu();

            basicMenu.turn();
        }


    }
}
