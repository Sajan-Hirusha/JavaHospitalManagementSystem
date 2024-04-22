import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AppoinmentManagement {
    public static void appoinmentManagement() {

        while (true) {
            AdminInterface.adminInterface("AppoinmentManagement Management section");
            System.out.println("1) Place Appoinement.");
            System.out.println("2) Back to Home.");
            int userInput = InputMethods.userInput();
            switch (userInput) {
                case 1:
                    placeAppoinment();
                    break;
                case 2:
                    return;
            }

        }
    }
    public static void placeAppoinment(){
        Scanner input = new Scanner(System.in);
        boolean condition = true;

        System.out.println("Enter Doctor Name: ");
        String doctorName = input.nextLine().trim();
        while (condition) {
            if (doctorName.equals("")) {
                System.out.println("ReEnter the doctor Name correctly:");
                doctorName = input.nextLine().trim();
                condition = true;

            }else {
                condition = false;
            }
        }
       String doctorDetails[] = DoctorManagement.findDoctor(doctorName);
        if (doctorDetails[0]!=null && doctorDetails[3].equalsIgnoreCase("available")){
            System.out.println("Enter patient Name: ");
            String patientName = input.nextLine().trim();
            System.out.println("Enter patient phone Number: ");
            int phoneNumber = input.nextInt();
            while (condition) {
                if (patientName.equals("")) {
                    System.out.println("ReEnter the patient Name correctly:");
                    patientName = input.nextLine().trim();
                    condition = true;
                } else {
                    condition = false;
                }
            }
            printBillDetails( doctorDetails[0],doctorDetails[1],doctorDetails[2],patientName,phoneNumber);
        }
        else{
            System.out.println("Doctor not Available!");
        }


    }
    public static void printBillDetails(String ID,String name, String description,String patientName,int phoneNumber){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        String simpleDate = dateFormat.format(date);
        String simpleTime = timeFormat.format(date);
        System.out.println("===============Bill info================");
        System.out.println("Date: " + simpleDate + "\t\tTime: " + simpleTime );
        System.out.println("==========Doctor Details=========");
        System.out.println("Doctor ID: " + ID);
        System.out.println("Doctor Name: " + name);
        System.out.println("Doctor description: " + description);
        System.out.println();
        System.out.println("==========Patient Details========");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Phone Number: " + phoneNumber);
        System.out.println("========================================");
        System.out.println();
    }
}
