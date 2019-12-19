package pl;

import pl.dao.UserDao;
import pl.models.User;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Użytkownicy: ");

        UserDao userDao = new UserDao();
        User[] allUsers = userDao.findAll();

        for(User user: allUsers){
            System.out.println(user);
        }

        String[] options = {"1. Dodanie użytkownika",
                "2. Edycja użytkownika",
                "3. Usunięcie użytkownika",
                "4. Zakończenie programu"};

        System.out.println("Opcje: ");

        for (String option: options) {
            System.out.println(option);
        }

        System.out.print("Wciśnij klawisz z nr opcji: ");

        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt() || input.nextInt()>options.length || input.nextInt()<0) {
            System.out.print("Wyborem jest liczba całkowita: ");
            input.nextLine();
        }

        int choice = input.nextInt();

        switch (choice){

            case 1:
        }

    }
}
