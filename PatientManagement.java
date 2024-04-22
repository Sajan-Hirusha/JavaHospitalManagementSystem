import java.util.Scanner;

public class PatientManagement {


    static String patients[][] = new String[100][4];
    static int currentSavePatientId = 1;
    static boolean mainResult = true;

    //Patient process start
    public static void patientManagementSystem() {

        String patientQuestions[] = {
                "1) Save new Ward patient",
                "2) Find Ward patient",
                "3) Update Ward patient",
                "4) Delete Ward patient",
                "5) Find all Ward patients",
                "6) Back to Home"
        };
        while (mainResult) {
            AdminInterface.adminInterface("Ward Patient Management section");
            for (String questions : patientQuestions) {
                System.out.println(questions);
            }
            int userInput = InputMethods.userInput();

            switch (userInput) {
                case 1:
                    savePatient();
                    break;
                case 2:
                    findPatient();
                    break;
                case 3:
                    updatePatient();
                    break;
                case 4:
                    deletePatient();
                    break;
                case 5:
                    findAllPatient();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Wrong input! please enter valid input");
            }
        }

    }

    //save Patient process start
    public static void savePatient() {

        Scanner input = new Scanner(System.in);
        boolean result = true;
        boolean condition = true;

        while (result) {

            if (patients[patients.length - 1][0] == null) {
                String patientID, patientName, patientAddress, PatientDisease;
//              System.out.println("Enter the Patient ID:");
                patientID = "P" + currentSavePatientId++;
                System.out.println("Enter the Patient Name:");
                patientName = input.nextLine().trim();
                System.out.println("Enter the PatientAddress:");
                patientAddress = input.nextLine().trim();
                System.out.println("Enter the Patient disease:");
                PatientDisease = input.nextLine().trim();

                while (condition) {
                    if (patientName.equals("")) {
                        System.out.println("ReEnter the Patient Name correctly:");
                        patientName = input.nextLine().trim();
                        condition = true;

                    } else if (patientAddress.equals("")) {
                        System.out.println("ReEnter the Patient Address correctly:");
                        patientAddress = input.nextLine().trim();
                        condition = true;
                    } else if (PatientDisease.equals("")) {
                        System.out.println("ReEnter the Patient disease correctly:");
                        PatientDisease = input.nextLine().trim();
                        condition = true;
                    } else {
                        condition = false;
                    }
                }

                for (int i = 0; i < patients.length; i++) {
                    if (patients[i][0] == null) {
                        patients[i][0] = patientID;
                        patients[i][1] = patientName;
                        patients[i][2] = patientAddress;
                        patients[i][3] = PatientDisease;
                        System.out.println("Patient Saved!");
                        break;

                    } else {
                        if (patients[i][0] != null) {
                            if (patients[i][0].equals(patientID)) {
                                System.out.println("Patient already exists!");
                                break;
                            }
                        }
                    }

                }
// add function
                System.out.println("1) Do you want Add another patient");
                System.out.println("2) Back to patient management section.");
                result = condition = InputMethods.reCall();

// add function
            } else {
                System.out.println("database is full");
            }

        }
    }

    //save Patient process start
    //find Patient process start
    public static void findPatient() {
        Scanner input = new Scanner(System.in);
        boolean result = true;
        while (result) {
            System.out.println("Enter the Patient ID:");
            String patientID = input.nextLine().trim();
            for (int i = 0; i < patients.length; i++) {
                if (patients[i][0] != null && patients[i][0].equals(patientID.toUpperCase())) {
                    System.out.println("Patient id is: " + patients[i][0]);
                    System.out.println("Patient name is: " + patients[i][1]);
                    System.out.println("Patient Adress is :" + patients[i][2]);
                    System.out.println("Patient disease is: " + patients[i][3]);
                    break;

                }
                if (patients[i][0] == null) {
                    System.out.println("This Patient id has no Patient!");
                    break;

                }


            }
            System.out.println("1) Do you want Find another Patient.");
            System.out.println("2) Back to Patient management section.");
            result = InputMethods.reCall();
        }
    }

    //find Patient process end
    //update Patient process start
    public static void updatePatient() {
        Scanner input = new Scanner(System.in);
        Scanner inputForInt = new Scanner(System.in);
        String questions[] = {
                "1) update Patient Name.",
                "2) update Patient Adress.",
                "3) update Patient disease.",
                "4) update All.",
                "5) Back to Patient management section "
        };
        boolean result = true;
        while (result) {
            System.out.println("Enter Patient ID you want to update details:");
            String PatientID = input.nextLine().trim();
            for (int i = 0; i < patients.length; i++) {
                if (patients[i][0] != null && patients[i][0].equals(PatientID.toUpperCase())) {
                    for (String q : questions) {
                        System.out.println(q);
                    }
                    System.out.println("Enter the your choise:");
                    int number = inputForInt.nextInt();
                    switch (number) {
                        case 1:
                            System.out.println("Enter the new Patient Name: ");
                            patients[i][1] = input.nextLine();
                            System.out.println("New Patient name Update successfully!");
                            break;
                        case 2:
                            System.out.println("Enter the new Patient Adress: ");
                            patients[i][2] = input.nextLine();
                            System.out.println("New Patient address Update successfully!");
                            break;
                        case 3:
                            System.out.println("Enter the new Patient disease: ");
                            patients[i][3] = input.nextLine();
                            System.out.println("New Patient disease Update successfully!");
                            break;
                        case 4:
                            System.out.println("Enter the new Patient Name: ");
                            patients[i][1] = input.nextLine();
                            System.out.println("Enter the new Patient Adress: ");
                            patients[i][2] = input.nextLine();
                            System.out.println("Enter the new Patient disease: ");
                            patients[i][3] = input.nextLine();
                            break;

                        case 6:
                            return;

                        default:
                            System.out.println("Wrong input!");

                    }
                    break;
                }
                if (patients[i][0] == null) {
                    System.out.println("Patient ID is wrong!");
                    break;
                }
            }
            System.out.println("1) Do you want Update another Patient.");
            System.out.println("2) Back to Patient management section.");
            result = InputMethods.reCall();
        }
    }

    //update Patient process end
    //delete Patient process start
    public static void deletePatient() {

        Scanner input = new Scanner(System.in);
        Scanner inputForInt = new Scanner(System.in);
        boolean result = true;
        LOOP:
        while (result) {
            System.out.println("1) Delete Patient.");
            System.out.println("2) Back to Patient management section.");
            int number = InputMethods.userInput();
            switch (number) {
                case 1:
                    System.out.println("Enter Patient ID you want to Delete details:");
                    String PatientID = input.nextLine().trim();
                    for (int i = 0; i < patients.length; i++) {
                        if (patients[i][0] != null && patients[i][0].equals(PatientID.toUpperCase())) {
                            System.out.println("=========Patient delete confomation!==========");
                            System.out.println("Do you want to delete this Patient?");
                            System.out.println("\t1) yes.");
                            System.out.println("\t2) No.");
                            System.out.println("Enter the your choise:");
                            int userInput = inputForInt.nextInt();
                            switch (userInput) {
                                case 1:
                                    //deletiong Patient details start
                                    patients[i][0] = null;
                                    patients[i][1] = null;
                                    patients[i][2] = null;
                                    patients[i][3] = null;
                                    //deletiong Patient details end
                                    for (int n = i; n < patients.length - 1; n++) {

                                        //filling null space using array next elements start
                                        if (patients[n + 1][0] != null) {
                                            patients[n][0] = patients[n + 1][0];
                                            patients[n][1] = patients[n + 1][1];
                                            patients[n][2] = patients[n + 1][2];
                                            patients[n][3] = patients[n + 1][3];
                                            patients[n + 1][0] = null;
                                            patients[n + 1][1] = null;
                                            patients[n + 1][2] = null;
                                            patients[n + 1][3] = null;
                                        } else if (patients[n + 1][0] == null) {
                                            System.out.println("Patient details delete successfully!");
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
                        if (patients[i][0] == null) {
                            System.out.println("Wrong Patient ID!");
                            continue LOOP;
                        }

                    }
                case 2:
                    return;
            }
            //delete Patient process end
        }
    }

    //Find all Patient start
    public static void findAllPatient() {
        for (int i = 0; i < patients.length; i++) {
            if (patients[i][0] != null) {
                System.out.println((i + 1) + ") " + patients[i][0]);
                System.out.println("   " + patients[i][1]);
                System.out.println("   " + patients[i][2]);
                System.out.println("   " + patients[i][3]);
                System.out.println("");
            } else {
                break;
            }
        }
        System.out.println("1) Back to Patient management section.");
        int number = InputMethods.userInput();
        switch (number) {
            case 1:
                return;
        }
    }
    //Find all Patient end
    //Patient process end
}
