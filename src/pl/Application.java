package pl;

import pl.models.ExerciseMenu;
import pl.models.UserMenu;

public class Application {

    public static void main(String[] args) {

        UserMenu userMenu = new UserMenu();
        ExerciseMenu exerciseMenu = new ExerciseMenu();

        while(true){
            exerciseMenu.turn();
        }

    }
}
