
import dto.Author;
import dto.Book;
import dto.User;
import model.AuthorModel;
import model.BookModel;
import model.UserModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.assertEquals;

public class CrudTest {

    /**
     * Ejecutar en orden descendente las pruebas para que tengan sentido,
     * ya que las que se encuentran más abajo dependen de las ejecuciones
     * de arriba.
     */

    private static AuthorModel authorModel;
    private static BookModel bookModel;
    private static UserModel userModel;

    @BeforeAll
    static void setUp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("localConnectionMySQL");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        authorModel = new AuthorModel(entityManager);
        bookModel = new BookModel(entityManager);
        userModel = new UserModel(entityManager);
    }

    @Test
    public void testGetByIdAuthor() {
        Author authorExpected = new Author(1,"Miguel de Cervantes","Saavedra","Miguel de Cervantes Saavedra fue un novelista, poeta, dramaturgo y soldado español.");

        Author actualAuthor = authorModel.getById(1);

        assertEquals(authorExpected, actualAuthor);

    }

    @Test
    public void testSaveAuthor(){
        Author authorExpected = new Author("Julio", "Cortazár","Escritor y profesor argentino. También trabajó como traductor, oficio que desempeñó para la Unesco y varias editoriales.");

        authorModel.save(authorExpected);

        Author actualAuthor = authorModel.getById(2);

        assertEquals(authorExpected, actualAuthor);
    }

    @Test
    public void testUpdateAuthor(){
        Author authorExpected = new Author(2,"Julio", "Cortazár","Escritor y profesor argentino. También trabajó como traductor, oficio que desempeñó para la Unesco y varias editoriales.En 1981, sin renunciar a su nacionalidad argentina, optó por la francesa en protesta contra la dictadura militar en su país");

        authorModel.update(authorExpected);

        Author actualAuthor = authorModel.getById(2);

        assertEquals(authorExpected, actualAuthor);

    }

    @Test
    public void testRemoveAuthor(){

        Author authorToRemove = new Author(2,"Julio", "Cortazár","Escritor y profesor argentino. También trabajó como traductor, oficio que desempeñó para la Unesco y varias editoriales.En 1981, sin renunciar a su nacionalidad argentina, optó por la francesa en protesta contra la dictadura militar en su país");

        authorModel.remove(authorToRemove);

        Author actualAuthor = authorModel.getById(2);

        assertEquals(null, actualAuthor);

    }

    @Test
    public void testGetByIdBook() {

        Book expetedBook = new Book(1,"Don Quijote de la Mancha",(short)1605,7833839512095L);

        Book actualBook = bookModel.getById(1);

        assertEquals(expetedBook, actualBook);
    }

    @Test
    public void testSaveBook(){
        Book bookExpected = new Book("Rayuela", (short)1963, 1234567891011L);

        bookModel.save(bookExpected);

        Book actualBook = bookModel.getById(2);

        assertEquals(bookExpected, actualBook);
    }

    @Test
    public void testUpdateBook(){

        Book bookExpected = new Book(2,"Rayuela", (short)1963, 5534567891011L);

        bookModel.update(bookExpected);

        Book actualBook = bookModel.getById(2);

        assertEquals(bookExpected, actualBook);
    }

    @Test
    public void testRemoveBook(){

        Book bookExpected = new Book(2,"Rayuela", (short)1963, 5534567891011L);

        bookModel.remove(bookExpected);

        Book actualBook = bookModel.getById(2);

        assertEquals(null, actualBook);

    }


    @Test
    public void testGetByIdUser(){
        User userExpected = new User(1,"Enrique", "enrique@gmail.com","3nr1qu3");

        User actualUser = userModel.getById(1);

        assertEquals(userExpected,actualUser);
    }

    @Test
    public void testSaveUser() {
        User userExpected = new User("Jorge","jorge@gmail.com","j0rg3");

        userModel.save(userExpected);

        User actualUser = userModel.getById(2);

        assertEquals(userExpected, actualUser);

    }

    @Test
    public void testUpadateUser() {
        User userExpected = new User(2,"Jorge","jorge@gmail.com","!j0rg3@°");

        userModel.update(userExpected);

        User actualUser = userModel.getById(2);

        assertEquals(userExpected, actualUser);
    }

    @Test
    public void testRemoveUser() {
        User userExpected = new User(2,"Jorge","jorge@gmail.com","!j0rg3@°");

        userModel.remove(userExpected);

        User actualUser = userModel.getById(2);

        assertEquals(null, actualUser);
    }




}
