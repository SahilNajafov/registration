package Site;

import DeletingAccount.Delete;
import Edit.EditingData;
import LogIn.LogIn;
import Registration.RegistrateUser;
import Users.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Processes {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose one: ");
        System.out.println("""
                1-Sign up
                2-Log in"""
        );
        int process = scanner.nextInt();

        if (process == 1) {
            RegistrateUser.registrate();
        }

        if (process == 2) {
            System.out.println("Enter the e-mail: ");
            String email = scanner.next();
            System.out.println("Enter the password: ");
            String password = scanner.next();

            LogIn.logIn(email, password);

            while (true) {
                System.out.println("Choose one: ");
                System.out.println("""
                        1-Change the name
                        2-Change the surname
                        3-Change the e-mail
                        4-Change the password
                        5-Log out
                        6-Delete account"""
                );

                int secondProcess = scanner.nextInt();

                if (secondProcess == 1) {
                    System.out.println("Enter the new name: ");
                    String newName = scanner.next();
                    EditingData.editName(email, password, newName);
                } else if (secondProcess == 2) {
                    System.out.println("Enter the new surname: ");
                    String newSurname = scanner.next();
                    EditingData.editSurname(email, password, newSurname);
                } else if (secondProcess == 3) {
                    System.out.println("Enter the new e-mail: ");
                    String newEmail = scanner.next();
                    EditingData.editEmail(email, password, newEmail);
                } else if (secondProcess == 4) {
                    while(true){
                        System.out.println("Enter the new password: ");
                        String newPassword = scanner.next();
                        System.out.println("Enter again: ");
                        String newPasswordAuth = scanner.next();
                        if (newPassword.equals(newPasswordAuth)){
                            EditingData.editPassword(email, password, newPassword);
                            break;
                        }
                    }

                } else if (secondProcess == 5) {
                    System.out.println("Loged out!");
                    break;
                } else if (secondProcess == 6) {
                    Delete.delete(email, password);
                    break;
                }
            }

        }

    }

}