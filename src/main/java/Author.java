import java.util.Set;

public class Author {
    private int idAuthor;
    private String name;
    private String lastName;
    private String biography;

    public Author(int idAuthor, String name, String lastName, String biography) {
        this.idAuthor = idAuthor;
        this.name = name;
        this.lastName = lastName;
        this.biography = biography;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
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

    public static class AuthorBuilder {
        private int idAuthor;
        private String name;
        private String lastName;
        private String biography;

        public AuthorBuilder(int idAuthor) {
            this.idAuthor = idAuthor;
        }

        public AuthorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AuthorBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AuthorBuilder withBiography(String biography) {
            this.biography = biography;
            return this;
        }

        public Author build() {
            return new Author(this.idAuthor,this.name,this.lastName,this.biography);
        }

    }

}
