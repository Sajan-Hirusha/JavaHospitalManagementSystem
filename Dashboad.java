public class Dashboad {
    //dashboad process start
    public static void openDashboad() {

        String dashboadQuestions[] = {
                "1) Ward Patient Management",
                "2) Doctor management",
                "3) Appointment management",
                "4) Logout"};
        while (true) {
            AdminInterface.adminInterface("Dashboad");
            for (String questions : dashboadQuestions) {
                System.out.println(questions);
            }
            int validUserInput = InputMethods.userInput();

            switch (validUserInput) {

                case 1:
                    PatientManagement.patientManagementSystem();
                    break;
                case 2:
                    DoctorManagement.doctorManagement();
                    break;
                case 3:
                    AppoinmentManagement.appoinmentManagement();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong input! please enter valid input");
            }
        }

    }
    //dashboad process end
}
