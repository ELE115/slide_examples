import java.io.FileInputStream;
import java.io.IOException;

public class ClassRead{
    public static void main(String[] argv) throws IOException {
        FileInputStream inputFile = new FileInputStream("ELE115.grade");
        GradeBook g = new GradeBook(inputFile, 25, 20);
        g.printGradeBook();
        inputFile.close();
    }
}
