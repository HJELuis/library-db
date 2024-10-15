import dto.Author;
import dto.Book;
import dto.User;
import model.AuthorModel;
import model.BookModel;
import model.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Library {
    public static void main(String[] args) throws Exception {
        //Singleton pattern design
        EntityManager entityManager = SingleEntityManager.getInstance();

        AuthorModel authorModel = new AuthorModel(entityManager);
        BookModel bookModel = new BookModel(entityManager);
        UserModel userModel = new UserModel(entityManager);

        //Builder pattern design

        //Author CRUD methods
        Author author = new Author.AuthorBuilder()
                .withName("Gabriel")
                .withLastName("García")
                .withBiography("Fue un escritor, guionista, editor de libros y periodista colombiano.").build();

        authorModel.save(author);

        Author authorReceived = authorModel.getById(1);
        System.out.println(authorReceived);

        authorReceived.setLastName("Márquez");
        authorModel.update(authorReceived);
        System.out.println(authorReceived);

        authorModel.remove(authorReceived);
        authorReceived = authorModel.getById(1);
        System.out.println(authorReceived);

        System.out.println("--------------------------");

        //Book CRUD methods
        Book book = new Book.BookBuilder("Cien años de soledad",1908765432234L)
                .withYear((short)1967)
                        .build();


        bookModel.save(book);

        Book bookReceived = bookModel.getById(1);
        System.out.println(bookReceived);

        bookReceived.setISBN(2222765432234L);
        bookModel.update(bookReceived);
        System.out.println(bookReceived);

        bookModel.remove(bookReceived);
        bookReceived = bookModel.getById(1);
        System.out.println(bookReceived);

        System.out.println("-----------------------");

        //User CRUD methods
        User user = new User.UserBuilder("password")
                .withName("name")
                .withEmail("email@gmail.com")
                .build();


        userModel.save(user);

        User userReceived = userModel.getById(1);
        System.out.println(userReceived);

        userReceived.setPassword("newPassword");
        userModel.update(userReceived);
        System.out.println(userReceived);

        userModel.remove(userReceived);
        userReceived = userModel.getById(1);
        System.out.println(userReceived);

    }
}
