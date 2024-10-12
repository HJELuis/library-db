package dto;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBook;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private short year;

    @Column (name = "isbn")
    private long ISBN;


    public Book(String title, int idBook, short year, long ISBN) {
        this.title = title;
        this.idBook = idBook;
        this.year = year;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthor() {
        return idBook;
    }

    public void setAuthor(int author) {
        this.idBook = author;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public static class BookBuilder {
        private String title;
        private int idBook;
        private short year;
        private long ISBN;

        public BookBuilder(int idBook, String title, long ISBN) {
            this.idBook = idBook;
            this.title = title;
            this.ISBN = ISBN;
        }

        public BookBuilder withYear(short year){
            this.year = year;
            return this;
        }

        public Book build() throws Exception {
            validateBookID();
            validateYear();
            return new Book(this.title,this.idBook,this.year, this.ISBN);
        }

        public void validateBookID() throws Exception {
            if(idBook < 0) {
                throw new Exception("Id no válido");
            }
        }

        public void validateYear() throws Exception {
            if(year < 0 || year > 2024) {
                throw new Exception("Año no válido");
            }
        }
    }




}
