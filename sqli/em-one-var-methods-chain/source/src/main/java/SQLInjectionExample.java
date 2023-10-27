import java.util.List;
import javax.persistence.*;

public class SQLInjectionExample {
    @Entity
    @Table(name = "users")
    public static class User {

        @Id
        @GeneratedValue
        private Integer id;

        @Column(nullable = false, unique = true)
        private String login;
    }

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String login = args[0];
        var res = entityManager.createQuery("SELECT u FROM User u WHERE u.login = '" + login + "'").getResultList();
        System.out.println(res);

        entityManager.close();
        entityManagerFactory.close();

    }
}
