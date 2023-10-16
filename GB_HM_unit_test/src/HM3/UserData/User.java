package HM3.UserData;

import java.util.Objects;

public class User {

    String name;
    String password;
    boolean isAuthenticate = false;
    boolean isAdmin;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        return this.isAuthenticate =
                Objects.equals(this.name, name) &&
                Objects.equals(this.password, password);
    }

    public boolean logoutIfNotAdmin() {
        return this.isAuthenticate = isAdmin && this.isAuthenticate;
    }

}