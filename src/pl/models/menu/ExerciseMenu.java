package pl.models.menu;

import pl.dao.ExerciseDao;
import pl.models.Exercise;

import java.util.Scanner;

public class ExerciseMenu {

    public void turn(){
        System.out.println("Zadania: ");

        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise[] allExercise = exerciseDao.findAll();

        for(Exercise exercise: allExercise){
            System.out.println(exercise);
        }

        String[] options = {"1. Dodanie zadania",
                "2. Edycja zadania",
                "3. Usunięcie zadania",
                "4. Zakończenie programu",
                "5.Powrót do poprzedniego menu"};

        System.out.println("Opcje: ");

        for (String option: options) {
            System.out.println(option);
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Wciśnij klawisz z nr wybranej opcji: ");

        int choice = input.nextInt();
        input.nextLine();


        if(choice==1) {

            String title;
            String description;

            System.out.println("Dodawanie zadania");

            System.out.print("1. Podaj nazwę: ");
            title = input.nextLine();
            System.out.print("2. Podaj treść: ");
            description = input.nextLine();

            Exercise exercise = new Exercise(title, description);

            exerciseDao.create(exercise);

            System.out.println("Zadanie dodane..");
        }

        else if(choice==2) {
            int exerciseId;
            String title;
            String description;

            System.out.println("Edycja zadania");

            System.out.print("Podaj id zadania: ");
            exerciseId = input.nextInt();
            input.nextLine();

            System.out.print("1. Podaj tytuł: ");
            title = input.nextLine();
            System.out.print("2. Podaj treść: ");
            description = input.nextLine();

            Exercise exercise = new Exercise(title, description);

            exercise.setId(exerciseId);

            exerciseDao.update(exercise);

            System.out.println("Dane zaktualizowane..");
        }

        else if(choice==3){
            int exerciseId;

            System.out.println("Usuwanie zadania");

            System.out.print("Podaj id zadania: ");
            exerciseId = input.nextInt();

            exerciseDao.delete(exerciseId);

            System.out.println("Zadanie usunięte..");

        }

        else if(choice==4){
            System.exit(0);
        }

        else if(choice==5){
            BasicMenu basicMenu = new BasicMenu();
            basicMenu.turn();
        }

        else{
            System.out.println("Nie oszukuj, nie mam opcji zabezpieczających.. :)");
        }
    }
}
