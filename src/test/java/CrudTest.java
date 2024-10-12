
import dto.Author;
import model.AuthorModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.assertEquals;

public class CrudTest {


    private static AuthorModel authorModel;

    @BeforeAll
    static void setUp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("localConnectionMySQL");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        authorModel = new AuthorModel(entityManager);
    }

    @Test
    public void testGetById() {
        Author authorExpected = new Author(1,"Miguel de Cervantes","Saavedra","Miguel de Cervantes Saavedra fue un novelista, poeta, dramaturgo y soldado español.");

        Author actualAuthor = authorModel.getById(1);

        assertEquals(authorExpected, actualAuthor);

    }

}
