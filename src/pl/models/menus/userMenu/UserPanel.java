package pl.models.menus.userMenu;

import pl.dao.UserDao;
import pl.models.simpleClasses.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserPanel {

    private int login;

    public void turn(){

        String[] options = {"1. Dodawanie rozwiązania",
                "2. Przeglądanie swoich rozwiązań",
                "3. Zakończenie programu"};

        System.out.println("Opcje: ");

        for (String option: options) {
            System.out.println(option);
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Wciśnij klawisz z nr wybranej opcji: ");

        int choice = input.nextInt();
        input.nextLine();

        SolutionPanel solutionPanel = new SolutionPanel(login);

        if(choice==1) {

            solutionPanel.add();
        }

        else if(choice==2) {
            solutionPanel.view();
        }
        else{
            System.exit(0);
        }

        turn();
    }

    public int login(){

        UserDao userDao = new UserDao();

        User[] userList = userDao.findAll();

        List<Integer> usersId = new ArrayList<>();

        for(User user: userList){
            usersId.add(user.getId());
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Podaj id użytkownika: ");

        int userLogin = input.nextInt();

        if(usersId.contains(userLogin)){
            return userLogin;
        }
        else{
            System.out.println("Błędne id");
            userLogin = login();
            return userLogin;
        }
    }

    public UserPanel() {
        this.login = login();
    }
}
