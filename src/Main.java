import com.config.Base;
import com.israel.Users;
import org.hibernate.Session;

import java.util.Date;

public class Main {

    public static void main(final String[] args) throws Exception {
        /*try (Session session = Base.getSession()) {
            Users users = new Users();
            users.setId(1);
            users.setUsername("Another Another");
            users.setJoinedDate(new Date());


            Users users1 = new Users();
            users1.setId(2);
            users1.setUsername("Osikani Another");
            users1.setJoinedDate(new Date());
            session.beginTransaction();
            session.save(users1);
            session.save(users);

            session.getTransaction().commit();
        }*/

     /* Users user =  Users.getUserData(1);

        System.out.println("The name is "+ user.getUsername());*/

     Users.allUsers();
    }
}