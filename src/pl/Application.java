package pl;

import pl.models.Menu;

public class Application {

    public static void main(String[] args) {

        Menu menu = new Menu();

        while(true){
            menu.turn();
        }

    }
}
