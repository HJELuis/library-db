

public class User {
    private int idUser;
    private String name;
    private String email;
    private String password;

    public User(int idUser, String name, String email, String password) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class UserBuilder {
        private int idUser;
        private String name;
        private String email;
        private String password;

        public UserBuilder(int idUser, String password) {
            this.idUser = idUser;
            this.password = password;
        }

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder withEmail(String email){
            this.email = email;
            return this;
        }

        public User build() {
            return new User (this.idUser, this.name, this.email, this.password);
        }
    }
}
