import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminInterface {
    public static void adminInterface(String position) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        String simpleDate = dateFormat.format(date);
        String simpleTime = timeFormat.format(date);
        System.out.println("==========" + simpleDate + "==========" + simpleTime + "====> " + position);

    }
}
