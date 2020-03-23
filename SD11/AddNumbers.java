import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;

public class AddNumbers{
    public static void main(String[] argv) throws IOException {
        double sum = 0;
        Scanner scanner = new Scanner(new FileInputStream("numberlist"));
        while (scanner.hasNext() == true ) {
            sum += scanner.nextDouble();
        }
        System.out.println(sum);
    }
}
