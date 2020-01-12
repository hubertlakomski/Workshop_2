package pl.models.adminMenus;

import pl.dao.SolutionDao;
import pl.models.simpleClasses.Solution;

import java.sql.Timestamp;
import java.util.Scanner;

public class SolutionMenu {

    public  void turn(){
        System.out.println("Rozwiązania zadań: ");

        SolutionDao solutionDao = new SolutionDao();
        Solution[] allSolution = solutionDao.findAll();

        for(Solution solution: allSolution){
            System.out.println(solution);
        }

        String[] options = {"1. Dodanie rozwiązania",
                "2. Edycja rozwiązania",
                "3. Usunięcie rozwiązania",
                "4. Powrót do poprzedniego menu"};

        System.out.println("Opcje: ");

        for (String option: options) {
            System.out.println(option);
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Wciśnij klawisz z nr wybranej opcji: ");

        int choice = input.nextInt();
        input.nextLine();

        if(choice==1) {

            String description;
            Timestamp created;
            int exerciseId;
            int usersId;

            System.out.println("Dodawanie rozwiązania");

            System.out.println("1. Podaj rozwiązanie: ");
            description = input.nextLine();
            System.out.println("2. Podaj id zadania: ");
            exerciseId = input.nextInt();
            input.nextLine();
            System.out.println("3. Podaj id użytkownika: ");
            usersId = input.nextInt();
            input.nextLine();

            created = new Timestamp(System.currentTimeMillis());

            Solution solution = new Solution(created, description, exerciseId, usersId);

            solutionDao.create(solution);

            System.out.println("Rozwiązanie dodane..");
        }

        else if(choice==2) {
            int solutionId;
            String description;
            int exerciseId;
            int usersId;
            Timestamp updated;

            System.out.println("Edycja rozwiązania");

            System.out.print("Podaj id rozwiązania: ");
            solutionId = input.nextInt();
            input.nextLine();
            System.out.println("1. Podaj rozwiązanie: ");
            description = input.nextLine();
            System.out.println("2. Podaj id zadania: ");
            exerciseId = input.nextInt();
            input.nextLine();
            System.out.println("3. Podaj id użytkownika: ");
            usersId = input.nextInt();
            input.nextLine();

            Solution solution = new Solution();

            updated = new Timestamp(System.currentTimeMillis());

            solution.setId(solutionId);
            solution.setDescription(description);
            solution.setExerciseId(exerciseId);
            solution.setUsersId(usersId);
            solution.setUpdated(updated);
            solution.setCreated(solutionDao.read(solutionId).getCreated());

            solutionDao.update(solution);

            System.out.println("Dane zaktualizowane..");
        }

        else if(choice==3){
            int solutionId;

            System.out.println("Usuwanie rozwiązania zadania");

            System.out.print("Podaj id zadania: ");
            solutionId = input.nextInt();

            solutionDao.delete(solutionId);

            System.out.println("Rozwiązanie usunięte..");

        }

        else if(choice==4){
            AdminMenu basicMenu = new AdminMenu();
            basicMenu.turn();
        }

        else{
            System.out.println("Nie oszukuj, nie mam opcji zabezpieczających.. :)");
        }
    }

}
