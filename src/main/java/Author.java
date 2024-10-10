import java.util.Set;

public class Author {
    private String name;
    private String lastName;
    private String biography;
    private Set<Book> publishedBooks;

    public Author(String name, String lastName, String biography, Set<Book> publishedBooks) {
        this.name = name;
        this.lastName = lastName;
        this.biography = biography;
        this.publishedBooks = publishedBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Set<Book> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(Set<Book> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }
}
