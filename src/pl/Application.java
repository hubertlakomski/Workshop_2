package pl;

import pl.dao.UserDao;
import pl.models.User;

public class Application {

    public static void main(String[] args) {
        User user = new User("Hubert", "hubertlakomski@gmail.com", "password");

        UserDao userDao = new UserDao();
//        //CREATE użytkownika do bazy danych
//        System.out.println("Przed zapisem: "+user);
//        User savedUser = userDao.create(user);
//        System.out.println("Po zapisie: "+user);

        //READ użytkownika z bazy danych
        User user2 = userDao.read(1);
        System.out.println("Istniejący user w bazie: " + user2);

        User user3 = userDao.read(45625);
        System.out.println("Nieistniejący user w baze: "+user3);

        //UPDATE użytkownika w bazie danych
        user2.setUserName("Nowy lepszy user name");
        userDao.update(user2);
        System.out.println("Nowy user name: "+user2);
    }
}
