package HM3.UserData;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (!user.isAuthenticate) return;
        data.add(user);
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logoutAllNotAdminUsers() {
        List<User> current = new ArrayList<>();

        for (User user : this.data) {
            if (user.logoutIfNotAdmin()) {
                current.add(user);
            }
        }
        this.data = current;
    }
}