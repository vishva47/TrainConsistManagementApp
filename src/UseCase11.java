import java.util.regex.Pattern;

public class UseCase11 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^TRN\\d{3}$");
        System.out.println("TRN001: " + p.matcher("TRN001").matches());
    }
}
