import java.util.Scanner;

public class InputMethods {
    public static boolean reCall() {
        int number = userInput();
        switch (number) {
            case 1:
                return true;

            case 2:
                return false;
            default:
                reCall();
                return false;

        }
    }

    //validate user input start
    public static int userInput() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("\tEnter your choise:");

        if (input.hasNextInt()) {
            int userInput = input.nextInt();
            return userInput;
        } else {
            System.out.println("Wrong input! please enter valid input");
            input.next();
            return 0;
        }
    }
    //validate user input end
}

