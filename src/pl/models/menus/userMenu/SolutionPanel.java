package pl.models.menus.userMenu;

import pl.dao.ExerciseDao;
import pl.dao.SolutionDao;
import pl.dao.UserDao;
import pl.models.simpleClasses.Exercise;
import pl.models.simpleClasses.Solution;
import pl.models.simpleClasses.User;

import java.sql.Timestamp;
import java.util.*;

public class SolutionPanel {

    private int userId;

    public void add(){

        UserDao userDao = new UserDao();

        User user = userDao.read(userId);

        SolutionDao solutionDao = new SolutionDao();

        Solution[] solution = solutionDao.findAllByUserId(userId);

        List<Integer> solvedExercisesId = new ArrayList<>();

        for(Solution s: solution){
            solvedExercisesId.add(s.getExerciseId());
        }

        ExerciseDao exerciseDao = new ExerciseDao();

        Exercise[] exercise = exerciseDao.findAll();

        List<Integer> unsolvedExercisesId = new ArrayList<>();


        for(Exercise e: exercise){
            if(!solvedExercisesId.contains(e.getId())){
                unsolvedExercisesId.add(e.getId());
                System.out.println(e.toString());
            }
        }

        if(unsolvedExercisesId.isEmpty()){
            System.out.println("Wszystkie zadania zostały rozwiązane");
            return;
        }
        else{
            System.out.println(user.getUserName()+
                    " nie dodałeś/aś jescze rozwiązań do tych zadań: ");
        }

        String choice;
        Scanner input = new Scanner(System.in);

        System.out.print("podaj id zadania, które chcesz rozwiązać: ");
        choice = input.nextLine();

        if(choice.equals("quit")){
            return;
        }
        else if(!unsolvedExercisesId.contains(Integer.parseInt(choice))){
            System.out.println("Błędny wybór");
            add();
            return;
        }


        String description;
        Timestamp created;

        System.out.print("1. Podaj rozwiązanie: ");
        description = input.nextLine();

        created = new Timestamp(System.currentTimeMillis());

        Solution userSolution = new Solution(created, description, Integer.parseInt(choice), userId);

        solutionDao.create(userSolution);

        System.out.println("Rozwiązanie dodane..");

    }

    public void view(){
        SolutionDao solutionDao = new SolutionDao();

        Solution[] solutions = solutionDao.findAllByUserId(userId);

        if(solutions.length==0){
            System.out.println("Brak rozwiązań");
        }
        else{
            System.out.println("Twoje rozwiązania: ");

            for(Solution solution: solutions){
                System.out.println("[Nr zadania: "+solution.getExerciseId()
                        +", dodano: "+solution.getCreated()
                        +", ostatnia zmiana: "+solution.getUpdated()+"]"
                        +"\nrozwiązanie: "+solution.getDescription());
            }
        }

    }

    public SolutionPanel(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
