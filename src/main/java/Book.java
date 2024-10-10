public class Book {
    private String title;
    private String author;
    private short year;
    private long ISBN;


    public Book(String title, String author, short year, long ISBN) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
        private String author;
        private short year;
        private long ISBN;

        public BookBuilder(String title, long ISBN) {
            this.title = title;
            this.ISBN = ISBN;
        }

        public BookBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder withYear(short year){
            this.year = year;
            return this;
        }

        public Book build() throws Exception {
            validateAuthor();
            validateYear();
            return new Book(this.title,this.author,this.year, this.ISBN);
        }
        
        public void validateAuthor() throws Exception {
            if(author.length() < 0 || author.length() > 100) {
                throw new Exception("Nombre del autor no válido");
            } else if (author.isEmpty()) {
                this.author = "unkown";
            }
        }

        public void validateYear() throws Exception {
            if(year < 0 || year > 2024) {
                throw new Exception("Año no válido");
            }
        }
    }




}
