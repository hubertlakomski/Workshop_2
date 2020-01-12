package pl.models.menu;

import java.util.Scanner;

public class BasicMenu {

    public void turn(){
        String[] options = {"1. Użytkownicy",
                "2. Grupy",
                "3. Zadania",
                "4. Rozwiązania",
                "5. Zakończenie programu"};

        System.out.println("Opcje: ");

        for (String option: options) {
            System.out.println(option);
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Wciśnij klawisz z nr wybranej opcji: ");

        int choice = input.nextInt();
        input.nextLine();


        if(choice==1) {
            UserMenu userMenu = new UserMenu();

            userMenu.turn();
        }

        else if(choice==2) {
            GroupMenu groupMenu = new GroupMenu();

            groupMenu.turn();
        }

        else if(choice==3){
            ExerciseMenu exerciseMenu = new ExerciseMenu();

            exerciseMenu.turn();
        }

        else if(choice==4){
            SolutionMenu solutionMenu = new SolutionMenu();

            solutionMenu.turn();
        }

        else if(choice==5) {
            System.exit(0);
        }

        else{
            System.out.println("Nie oszukuj, nie mam opcji zabezpieczających.. :)");
        }
    }

}
