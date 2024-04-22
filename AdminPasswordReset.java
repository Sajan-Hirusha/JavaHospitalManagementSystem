import java.util.Scanner;

public class AdminPasswordReset {
    //Value Assign for adminPassword variable only testing process
    private static String adminPassword = "admin123";
    //Value Assign for adminPassword process end
    public void setAdminPassword(String newAdminPasswword) {
        Scanner input=new Scanner(System.in);
        if(newAdminPasswword.equals(adminPassword)) {
            System.out.println("Enter new Admin Password:");
            String adminPassword = input.nextLine();
            this.adminPassword = adminPassword;
            System.out.println("Admin Password change Successfully!");
        }
        else{
            System.out.println("Old password is note matched!");
        }
    }
    public String getAdminPassword() {
        return this.adminPassword;
    }
    public static void adminPasswordReset(){
        AdminInterface.adminInterface("Admin password Reset section");
        AdminPasswordReset adminPasswordReset = new AdminPasswordReset();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Old Admin Password:");
        String oldAdminPassword = input.nextLine();
        adminPasswordReset.setAdminPassword(oldAdminPassword);

    }
}
