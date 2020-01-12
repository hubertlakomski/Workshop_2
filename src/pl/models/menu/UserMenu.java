package pl.models.menu;

import pl.dao.UserDao;
import pl.models.User;

import java.util.Scanner;

public class UserMenu {

    public void turn(){
        System.out.println("Użytkownicy: ");

        UserDao userDao = new UserDao();
        User[] allUsers = userDao.findAll();

        for(User user: allUsers){
            System.out.println(user);
        }

        String[] options = {"1. Dodanie użytkownika",
                "2. Edycja użytkownika",
                "3. Usunięcie użytkownika",
                "4. Powrót do poprzedniego menu"};

        System.out.println("Opcje: ");

        for (String option: options) {
            System.out.println(option);
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Wciśnij klawisz z nr wybranej opcji: ");

        int choice = input.nextInt();

        if(choice==1) {

            String name;
            String email;
            String password;
            int user_group_id;

            System.out.println("Dodawanie użytkownika");

            System.out.print("1. Podaj imię: ");
            name = input.next();
            System.out.print("2. Podaj email: ");
            email = input.next();
            System.out.print("3. Podaj hasło: ");
            password = input.next();
            System.out.print("4. Podaj id grupy: ");
            user_group_id = input.nextInt();

            User user = new User(name, email, password, user_group_id);

            userDao.create(user);

            System.out.println("Użytkownik dodany..");
        }

        else if(choice==2) {
            int userId;
            String name;
            String email;
            String password;
            int user_group_id;

            System.out.println("Edycja użytkownika");

            System.out.print("Podaj id użytkownika: ");
            userId = input.nextInt();

            System.out.print("1. Podaj imię: ");
            name = input.next();
            System.out.print("2. Podaj email: ");
            email = input.next();
            System.out.print("3. Podaj hasło: ");
            password = input.next();
            System.out.print("4. Podaj id grupy: ");
            user_group_id = input.nextInt();

            User user = new User(name, email, password, user_group_id);

            user.setId(userId);

            userDao.update(user);

            System.out.println("Dane zaktualizowane..");
        }

        else if(choice==3){
            int userId;

            System.out.println("Usuwanie użytkownika");

            System.out.print("Podaj id użytkownika: ");
            userId = input.nextInt();

            userDao.delete(userId);

            System.out.println("Użytkownik usunięty..");

        }

        else if(choice==4){
            BasicMenu basicMenu = new BasicMenu();
            basicMenu.turn();
        }

        else{
            System.out.println("Nie oszukuj, nie mam opcji zabezpieczających.. :)");
        }

    }
}
