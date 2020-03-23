import java.io.PrintStream;
import java.io.IOException;

public class Classroom {
    public static void main(String[] argv) throws IOException {
        //lets test out the class
        GradeBook g = new GradeBook("ELE 115", 25, 20);
        //Add two assignments
        g.addAssignment("Lab 1", 0.1);
        g.addAssignment("Lab 2", 0.1);
        g.addAssignment("Lab 3", 0.1);
        Student david = new Student("David Wentzlaff", 123, "wentzlaf", "wentzlaf@princeton.edu", 2020);
        Student alexey = new Student("Alexey Lavrov", 456, "alavrov", "alavrov@princeton.edu", 2020);
        Student jinzheng = new Student("Jinzheng Tu", 789, "jinzheng", "jinzheng@princeton.edu", 2020);
        Student zecheng = new Student("Zecheng He", 789, "zechengh", "zechengh@princeton.edu", 2020);
        int daveIndex = g.addStudent(david);
        int alexeyIndex = g.addStudent(alexey);
        int jinzhengIndex = g.addStudent(jinzheng);
        int zechengIndex = g.addStudent(zecheng);
        g.setGrade(daveIndex, 0, 90);
        g.setGrade(daveIndex, 1, 80);
        g.setGrade(daveIndex, 2, 100);
        g.setGrade(alexeyIndex, 0, 85);
        g.setGrade(alexeyIndex, 1, 91);
        g.setGrade(alexeyIndex, 2, 70);
        g.setGrade(jinzhengIndex, 0, 99);
        g.setGrade(jinzhengIndex, 1, 99);
        g.setGrade(jinzhengIndex, 2, 99);
        g.setGrade(zechengIndex, 0, 99);
        g.setGrade(zechengIndex, 1, 80);
        g.setGrade(zechengIndex, 2, 90);
        g.printGradeBook(new PrintStream("ELE115.csv"));
    }
}
