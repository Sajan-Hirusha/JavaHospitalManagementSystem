
public class LoginInterface {

    //program initialization start

    // logingInterface();
    public static void logingInterface() {

        String initializePage[] = {"1) Do you want to login?",
                "2) Are you new to here?",
                "3) Reset admin Password.?",
                "4) Do you want to exit the page?"
        };
        while (true) {
            AdminInterface.adminInterface("Application Unit");
            System.out.println("");
            for (String question : initializePage) {
                System.out.println(question);
            }
            int validUserInput = InputMethods.userInput();

            switch (validUserInput) {
                case 1:
                    AdminInterface.adminInterface("Login Area");
                    if (AdminLogging.login()) {
                        Dashboad.openDashboad();
                    }
                    break;
                case 2:
                    AdminInterface.adminInterface("register Area");
                    if (AdminRegister.register()) {
                        Dashboad.openDashboad();
                    }
                    break;
                case 3:
                    AdminPasswordReset.adminPasswordReset();
                    break;
                case 4:
                    System.out.println("Good Bye!!!");
                    return;
                default:
                    System.out.println("Wrong input! please enter valid input");
            }
        }
    }
    //program initialization end
}
