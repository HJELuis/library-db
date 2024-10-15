import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingleEntityManager{
    private static EntityManager entityManager;
    private SingleEntityManager(){}
    public static EntityManager getInstance(){
        if (entityManager == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("localConnectionMySQL");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            return entityManager;
        }
        return entityManager;
    }
}
