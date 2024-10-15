package dto;

import javax.persistence.*;

@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuthor;

    @Column(name = "name")
    private String name;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "biography")
    private String biography;

    public Author(){}

    public Author(int idAuthor, String name, String lastName, String biography) {
        this.idAuthor = idAuthor;
        this.name = name;
        this.lastName = lastName;
        this.biography = biography;
    }

    public Author(String name, String lastName, String biography) {
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

        public AuthorBuilder() {

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Author author = (Author) obj;
        return this.idAuthor == author.idAuthor && this.name.equals(author.name)
                && this.lastName.equals(author.lastName)
                && this.biography.equals(author.biography);
    }

    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}
