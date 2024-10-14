
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

    @Test
    public void testSave(){
        Author authorExpected = new Author("Julio", "Cortazár","Escritor y profesor argentino. También trabajó como traductor, oficio que desempeñó para la Unesco y varias editoriales.");

        authorModel.save(authorExpected);

        Author actualAuthor = authorModel.getById(2);

        assertEquals(authorExpected, actualAuthor);
    }

    @Test
    public void testUpdate(){
        Author authorExpected = new Author(2,"Julio", "Cortazár","Escritor y profesor argentino. También trabajó como traductor, oficio que desempeñó para la Unesco y varias editoriales.En 1981, sin renunciar a su nacionalidad argentina, optó por la francesa en protesta contra la dictadura militar en su país");

        authorModel.update(authorExpected);

        Author actualAuthor = authorModel.getById(2);

        assertEquals(authorExpected, actualAuthor);

    }

    @Test
    public void testRemove(){

        Author authorToRemove = new Author(2,"Julio", "Cortazár","Escritor y profesor argentino. También trabajó como traductor, oficio que desempeñó para la Unesco y varias editoriales.En 1981, sin renunciar a su nacionalidad argentina, optó por la francesa en protesta contra la dictadura militar en su país");

        authorModel.remove(authorToRemove);

        Author actualAuthor = authorModel.getById(2);

        assertEquals(null, actualAuthor);

    }

}
