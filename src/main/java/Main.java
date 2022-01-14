import app.config.AppConfig;
import app.model.User;
import app.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
//      Car car1 = new Car("m", 1);
//      Car car2 = new Car("s", 2);
//      Car car3 = new Car("d", 3);
//      Car car4 = new Car("p", 4);
//
//      userService.add(new User(car1, "User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User(car2, "User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User(car3, "User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User(car4, "User4", "Lastname4", "user4@mail.ru"));

        List<User> users = userService.getListUsers();
        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+user.getAge());
            System.out.println();
        }
        context.close();
    }
}
