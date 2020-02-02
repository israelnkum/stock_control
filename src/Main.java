import com.config.Base;
import com.israel.Users;
import com.israel.Vehicle;
import org.hibernate.Session;

import java.util.Date;

public class Main {

    public static void main(final String[] args) throws Exception {
        try (Session session = Base.getSession()) {
            Users users = new Users();
            users.setUsername("Another Another");
            users.setJoinedDate(new Date());
            Vehicle vehicle = new Vehicle();
            vehicle.setName("Car");
            users.setVehicle(vehicle);


            Users users1 = new Users();
            users1.setUsername("Osikani Another");
            users1.setJoinedDate(new Date());
            Vehicle vehicle1 = new Vehicle();
            vehicle1.setName("Car2");
            users1.setVehicle(vehicle1);

            session.beginTransaction();
            session.save(users1);
            session.save(users);
            session.save(vehicle1);
            session.save(vehicle);

            session.getTransaction().commit();
        }

    }
}