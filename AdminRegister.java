import java.util.Scanner;

public class AdminRegister {

    static String users[][] = new String[3][2];
    //register process start
    private static String email, password, adminPassword;

    public static boolean register() {
        AdminPasswordReset adminPasswordReset =new AdminPasswordReset();
        Scanner input = new Scanner(System.in);

        if (users[users.length - 1][0] != null) {
            System.out.println("user database is full");
            return false;
        }
        System.out.println("Insert your Email:");
        email = input.nextLine().trim();
        System.out.println("Insert your Password:");
        password = input.nextLine().trim();
        System.out.println("Enter Admin Password:");
        adminPassword = input.nextLine().trim();
        if (adminPassword.equals(adminPasswordReset.getAdminPassword())) {
            for (int x = 0; x < users.length; x++) {
                if (users[x][0] == null) {
                    users[x][0] = email;
                    users[x][1] = password;
                    return true;
                } else {
                    if (users[x][0].equalsIgnoreCase(email)) {
                        System.out.println("Email is already exists!");
                        return false;
                    }

                }
            }
        } else {
            System.out.println("Admin Password is wrong!");
        }
        return false;
    }
    //register process end
}
