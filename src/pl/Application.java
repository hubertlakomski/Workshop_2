package pl;

import pl.dao.ExerciseDao;
import pl.dao.SolutionDao;
import pl.dao.UserDao;
import pl.models.Exercise;
import pl.models.Solution;
import pl.models.User;

public class Application {

    public static void main(String[] args) {
        User user = new User("Hubert", "hubertlakomski@gmail.com", "password", 0);

        UserDao userDao = new UserDao();
//        //CREATE użytkownika do bazy danych
//        System.out.println("Przed zapisem: "+user);
//        User savedUser = userDao.create(user);
//        System.out.println("Po zapisie: "+user);
//
//        //READ użytkownika z bazy danych
//        User user2 = userDao.read(1);
//        System.out.println("Istniejący user w bazie: " + user2);
//
//        User user3 = userDao.read(45625);
//        System.out.println("Nieistniejący user w baze: "+user3);
//
//        //UPDATE użytkownika w bazie danych
//        user2.setUserName("Nowy lepszy user name");
//        userDao.update(user2);
//        System.out.println("Nowy user name: "+user2);
//
//        //DELETE użytkownika z bazy danych
//        userDao.delete(1);

        User newUser1 = new User("hubertlakomski",
                "hubertlakomski@gmai.com",
                "password", 0);
        userDao.create(newUser1);
        User newUser2 = new User("hlakomski",
                "hlakomski@gmail.com",
                "passwordlakomski", 0);
        userDao.create(newUser2);

        User[] allUsers = userDao.findAll();

        for(User user1: allUsers){
            System.out.println(user1);
        }

        ExerciseDao exerciseDao = new ExerciseDao();

        Exercise newExercise1 = new Exercise("Zadanie 1", "Super łatwe");

        exerciseDao.create(newExercise1);

        SolutionDao solutionDao = new SolutionDao();

        Solution newSolution1 = new Solution(2017-07-23, 2017-07-23, "szybko zrobiłem", 1, 1);

    }
}
