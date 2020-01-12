package pl.models.menu;

import pl.dao.GroupDao;
import pl.models.Group;

import java.util.Scanner;

public class GroupMenu {

    public void turn(){
        System.out.println("Grupy: ");

        GroupDao groupDao = new GroupDao();
        Group[] allGroup = groupDao.findAll();

        for(Group group: allGroup){
            System.out.println(group);
        }

        String[] options = {"1. Dodanie grupy",
                "2. Edycja grupy",
                "3. Usunięcie grupy",
                "4.Powrót do poprzedniego menu"};

        System.out.println("Opcje: ");

        for (String option: options) {
            System.out.println(option);
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Wciśnij klawisz z nr wybranej opcji: ");

        int choice = input.nextInt();
        input.nextLine();


        if(choice==1) {

            String name;

            System.out.println("Dodawanie grupy");

            System.out.print("1. Podaj nazwę: ");
            name = input.nextLine();

            Group group = new Group(name);

            groupDao.create(group);

            System.out.println("Grupa dodana..");
        }

        else if(choice==2) {
            int groupId;
            String name;

            System.out.println("Edycja grupy");

            System.out.print("Podaj id grupy: ");
            groupId = input.nextInt();
            input.nextLine();

            System.out.print("1. Podaj nazwę: ");
            name = input.nextLine();

            Group group = new Group(name);

            group.setId(groupId);

            groupDao.update(group);

            System.out.println("Dane zaktualizowane..");
        }

        else if(choice==3){
            int groupId;

            System.out.println("Usuwanie grupy");

            System.out.print("Podaj id grupy: ");
            groupId = input.nextInt();

            groupDao.delete(groupId);

            System.out.println("Grupa usunięta..");

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
