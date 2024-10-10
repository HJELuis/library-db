public class Book {
    private int idAuthor;
    private String title;
    private short year;
    private long ISBN;


    public Book(String title, int idAuthor, short year, long ISBN) {
        this.title = title;
        this.idAuthor = idAuthor;
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
        return idAuthor;
    }

    public void setAuthor(int author) {
        this.idAuthor = author;
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
        private int idAuthor;
        private short year;
        private long ISBN;

        public BookBuilder(String title, long ISBN) {
            this.title = title;
            this.ISBN = ISBN;
        }

        public BookBuilder withAuthor(int author) {
            this.idAuthor = author;
            return this;
        }

        public BookBuilder withYear(short year){
            this.year = year;
            return this;
        }

        public Book build() throws Exception {
            validateAuthor();
            validateYear();
            return new Book(this.title,this.idAuthor,this.year, this.ISBN);
        }

        public void validateAuthor() throws Exception {
            if(idAuthor < 0) {
                throw new Exception("Autor no válido");
            }
        }

        public void validateYear() throws Exception {
            if(year < 0 || year > 2024) {
                throw new Exception("Año no válido");
            }
        }
    }




}
