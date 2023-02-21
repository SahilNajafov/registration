package Users;

import java.time.LocalDate;

public class User {
    public String name;
    public String surname;
    public String email;
    public LocalDate birthday;
    public String password;

    public User(String name, String surname, String email, LocalDate birthday, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
    }
}
