package pl;

import pl.models.SolutionMenu;

public class Application {

    public static void main(String[] args) {

        SolutionMenu solutionMenu = new SolutionMenu();

        while(true){
            SolutionMenu.turn();
        }


    }
}
