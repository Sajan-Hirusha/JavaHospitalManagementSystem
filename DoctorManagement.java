import java.util.Scanner;

public class DoctorManagement {
    static String doctors[][] = new String[100][4];
    static int currentSaveDoctorId = 1;
    static boolean mainResult = true;

    //doctor process start
    public static void doctorManagement() {

        String doctorQuestions[] = {
                "1) Save doctor",
                "2) Find doctor",
                "3) Update doctor",
                "4) Delete doctor",
                "5) Find all doctor",
                "6) Back to Home"
        };
        while (mainResult) {
            AdminInterface.adminInterface("Doctor Management section");
            for (String questions : doctorQuestions) {
                System.out.println(questions);
            }
            int userInput = InputMethods.userInput();

            switch (userInput) {
                case 1:
                    saveDoctor();
                    break;
                case 2:
                    findDoctor();
                    break;
                case 3:
                    updateDoctor();
                    break;
                case 4:
                    deleteDoctor();
                    break;
                case 5:
                    findAllDoctor();
                    break;
                case 6:
                    return;
            }
        }

    }

    public static String doctorStatus() {

            System.out.println("Enter the doctor Status:");
            System.out.println("\t1) Available");
            System.out.println("\t2) Not Available");
            int num = InputMethods.userInput();
            if (num == 1)
                return "Available";

            else 
                return "Not Available";
    }

    //save doctor process start
    public static void saveDoctor() {

        Scanner input = new Scanner(System.in);

        boolean result = true;
        boolean condition = true;

        while (result) {

            if (doctors[doctors.length - 1][0] == null) {
                String doctorId, doctorName, doctorDescription, doctorStatus;
                doctorId = "D" + currentSaveDoctorId++;
                System.out.println("Enter the doctor Name:");
                doctorName = input.nextLine().trim();
                System.out.println("Enter the doctor Description:");
                doctorDescription = input.nextLine().trim();
                doctorStatus = doctorStatus();


                while (condition) {
                    if (doctorName.equals("")) {
                        System.out.println("ReEnter the doctor Name correctly:");
                        doctorName = input.nextLine().trim();
                        condition = true;

                    } else if (doctorDescription.equals("")) {
                        System.out.println("ReEnter the doctor Description correctly:");
                        doctorDescription = input.nextLine().trim();
                        condition = true;

                    } else {
                        condition = false;
                    }
                }

                for (int i = 0; i < doctors.length; i++) {
                    if (doctors[i][0] == null) {
                        doctors[i][0] = doctorId;
                        doctors[i][1] = doctorName;
                        doctors[i][2] = doctorDescription;
                        doctors[i][3] = doctorStatus;
                        System.out.println("doctor Saved!");
                        break;

                    } else {
                        if (doctors[i][0] != null) {
                            if (doctors[i][0].equals(doctorId)) {
                                System.out.println("doctor already exists!");
                                break;
                            }
                        }
                    }

                }

                System.out.println("1) Do you want Add another doctor.");
                System.out.println("2) Back to doctor management section.");
                result = condition = InputMethods.reCall();
            } else {
                System.out.println("database is full");
            }

        }
    }

    //save doctor process start
    //find doctor process start
    public static void findDoctor() {
        Scanner input = new Scanner(System.in);
        boolean result = true;
        while (result) {
            System.out.println("Enter the doctor Id:");
            String doctorId = input.nextLine().trim();
            for (int i = 0; i < doctors.length; i++) {
                if (doctors[i][0] != null && doctors[i][0].equals(doctorId.toUpperCase().trim())) {
                    System.out.println("doctor Id is: " + doctors[i][0]);
                    System.out.println("doctor name is: " + doctors[i][1]);
                    System.out.println("doctor Description is :" + doctors[i][2]);
                    System.out.println("doctor status is: " + doctors[i][3]);
                    break;

                }
                if (doctors[i][0] == null) {
                    System.out.println("This doctor Id has no doctor!");
                    break;

                }


            }
            System.out.println("1) Do you want Find another doctor.");
            System.out.println("2) Back to doctors management section.");
            result = InputMethods.reCall();

        }
    }

    public static String[] findDoctor(String name) {
        String doctorDetails[] = new String[4];
        String doctorName = name;
        for (int i = 0; i < doctors.length; i++) {
            if (doctors[i][0] != null && doctors[i][1].equalsIgnoreCase(doctorName)) {
                doctorDetails[0] = doctors[i][0];
                doctorDetails[1] = doctors[i][1];
                doctorDetails[2] = doctors[i][2];
                doctorDetails[3] = doctors[i][3];
                return doctorDetails;

            }
            if (doctors[i][0] == null) {
                break;

            }
        }
        return doctorDetails;
    }

    //find doctor process end
    //update doctor process start
    public static void updateDoctor() {
        Scanner input = new Scanner(System.in);
        Scanner inputForInt = new Scanner(System.in);
        String questions[] = {
                "1) update Doctor Name.",
                "2) update Doctor Description.",
                "3) update Doctor Status.",
                "4) update All.",
                "5) Back to item management section "
        };
        boolean result = true;
        while (result) {
            System.out.println("Enter doctor Id you want to update details:");
            String doctorId = input.nextLine().trim();
            for (int i = 0; i < doctors.length; i++) {
                if (doctors[i][0] != null && doctors[i][0].equals(doctorId.toUpperCase().trim())) {
                    for (String q : questions) {
                        System.out.println(q);
                    }
                    System.out.println("Enter the your choise:");
                    int number = inputForInt.nextInt();
                    switch (number) {
                        case 1:
                            System.out.println("Enter the new doctor Name: ");
                            doctors[i][1] = input.nextLine();
                            System.out.println("New item Name Update successfully!");
                            break;
                        case 2:
                            System.out.println("Enter the new doctor Description: ");
                            doctors[i][2] = input.nextLine();
                            System.out.println("New doctor Description Update successfully!");
                            break;
                        case 3:
                            System.out.println("Enter the new doctor Status: ");
                            doctors[i][3] = doctorStatus();
                            System.out.println("New doctor Status Update successfully!");
                            break;
                        case 4:
                            System.out.println("Enter the new doctor ID: ");
                            doctors[i][0] = input.nextLine();
                            System.out.println("Enter the new doctor Name: ");
                            doctors[i][1] = input.nextLine();
                            System.out.println("Enter the new doctor Description: ");
                            doctors[i][2] = input.nextLine();
                            System.out.println("Enter the new doctor Status: ");
                            doctors[i][3] = doctorStatus();
                            break;
                        case 5:
                            return;

                        default:
                            System.out.println("Wrong input!");

                    }
                    break;
                }
                if (doctors[i][0] == null) {
                    System.out.println("doctor code is wrong!");
                    break;
                }
            }
            System.out.println("1) Do you want Update another doctor.");
            System.out.println("2) Back to doctor management section.");
            result = InputMethods.reCall();
        }
    }

    //update doctor process end
    //delete doctor process start
    public static void deleteDoctor() {
        Scanner input = new Scanner(System.in);
        Scanner inputForInt = new Scanner(System.in);
        boolean result = true;
        LOOP:
        while (result) {
            System.out.println("1) Delete doctor.");
            System.out.println("2) Back to doctor management section.");
            int number = InputMethods.userInput();
            switch (number) {
                case 1:
                    System.out.println("Enter doctor Id you want to Delete details:");
                    String doctorId = input.nextLine().trim();
                    for (int i = 0; i < doctors.length; i++) {
                        if (doctors[i][0] != null && doctors[i][0].equals(doctorId.toUpperCase().trim())) {
                            System.out.println("=========item delete confomation!==========");
                            System.out.println("Do you want to delete this doctor?");
                            System.out.println("\t1) yes.");
                            System.out.println("\t2) No.");
                            System.out.println("Enter the your choise:");
                            int userInput = inputForInt.nextInt();
                            switch (userInput) {
                                case 1:
                                    //deleting item details start
                                    doctors[i][0] = null;
                                    doctors[i][1] = null;
                                    doctors[i][2] = null;
                                    doctors[i][3] = null;
                                    //deleting item details end
                                    for (int n = i; n < doctors.length - 1; n++) {

                                        //filling null space using array next elements start
                                        if (doctors[n + 1][0] != null) {
                                            doctors[n][0] = doctors[n + 1][0];
                                            doctors[n][1] = doctors[n + 1][1];
                                            doctors[n][2] = doctors[n + 1][2];
                                            doctors[n][3] = doctors[n + 1][3];
                                            doctors[n + 1][0] = null;
                                            doctors[n + 1][1] = null;
                                            doctors[n + 1][2] = null;
                                            doctors[n + 1][3] = null;
                                        } else if (doctors[n + 1][0] == null) {
                                            System.out.println("doctor details delete successfully!");
                                            break;
                                        }
                                    }
                                    //filling null space using array next elements end
                                    break;
                                case 2:
                                    break;

                            }
                            break;
                        }
                        if (doctors[i][0] == null) {
                            System.out.println("Wrong item code!");
                            continue LOOP;
                        }

                    }
                case 2:
                    return;
            }
            //delete item process end
        }
    }

    //Find all doctor start
    public static void findAllDoctor() {
        for (int i = 0; i < doctors.length; i++) {
            if (doctors[i][0] != null) {
                System.out.println((i + 1) + ") " + doctors[i][0]);
                System.out.println("   " + doctors[i][1]);
                System.out.println("   " + doctors[i][2]);
                System.out.println("   " + doctors[i][3]);
                System.out.println("");
            } else {
                break;
            }
        }
        System.out.println("1) Back to doctor management section.");
        int number = InputMethods.userInput();
        switch (number) {
            case 1:
                return;
        }
    }
    //Find all doctor end
    //doctor process end
}

