package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Mihail", "Ivanov", "bear@mail.ru");
        User user2 = new User("Svetlana", "Popova", "cvetochek@mail.ru");
        User user3 = new User("Nikita", "Sidorov", "nik123@mail.ru");
        User user4 = new User("Oleg", "Petrov", "olejka@mail.ru");

        Car car1 = new Car("BMV", 2023);
        Car car2 = new Car("Mercedes", 2002);
        Car car3 = new Car("Nissan", 328);
        Car car4 = new Car("VAZ", 1);

        userService.add(user1.setCar(car1).setUser(user1));
        userService.add(user2.setCar(car2).setUser(user2));
        userService.add(user3.setCar(car3).setUser(user3));
        userService.add(user4.setCar(car4).setUser(user4));

        for (User user : userService.listUsers()) {
            System.out.println(user + " " + user.getCar());
        }

        System.out.println(userService.getUserByCar("VAZ", 1));

        context.close();
    }
}
