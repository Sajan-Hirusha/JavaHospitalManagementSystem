import java.util.Scanner;

public class AdminLogging {

    //loging process start
    private static String email;
    private static String password;
    public static boolean login() {

        Scanner input = new Scanner(System.in);
        System.out.println("Insert your Email");
        email = input.nextLine();
        System.out.println("Insert your Password");
        password = input.nextLine();
        if (email.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
            System.out.println("Please enter the email and password correctly");

        } else {
            for (int i = 0; i < AdminRegister.users.length; i++) {
                if (AdminRegister.users[i][0] != null) {
                    if (AdminRegister.users[i][0].equals(email) && AdminRegister.users[i][1].equals(password)) {
                        return true;
                    }

                } else {
                    break;

                }

            }
            System.out.println("your password and email not match");
        }
        return false;
    }

    //loging process End
}
