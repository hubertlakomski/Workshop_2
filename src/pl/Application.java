package pl;

import pl.models.GroupMenu;

public class Application {

    public static void main(String[] args) {

        GroupMenu groupMenu = new GroupMenu();

        while(true){
            groupMenu.turn();
        }


    }
}
