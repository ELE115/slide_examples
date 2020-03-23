import java.io.PrintStream;

public class GradeBook {
    private String className;
    private int maxNumberStudents;
    private int currentNumberStudents;
    private int maxAssignments;
    private int currentAssignments;
    private Student[] students;
    private double[][] grades;
    private String[] assignmentNames;
    private double[] assignmentWeights;

    public GradeBook(String passedClassName, int passedMaxNumberStudents, int passedMaxAssignments) {
        className = passedClassName;
        maxNumberStudents = passedMaxNumberStudents;
        maxAssignments = passedMaxAssignments;
        currentNumberStudents = 0;
        currentAssignments = 0;
        students = new Student[maxNumberStudents];
        grades = new double[maxAssignments][maxNumberStudents];
        assignmentNames = new String[maxAssignments];
        assignmentWeights = new double[maxAssignments];
    }
    // returns student's index
    public int addStudent(Student s) {
        int studentIndex = currentNumberStudents;
        students[currentNumberStudents] = s;
        currentNumberStudents = currentNumberStudents + 1;
        return studentIndex;
    }

    // set the grade for a particular student and assignment
    public void setGrade(int studentIndex, int assignmentIndex, double grade) {
        grades[assignmentIndex][studentIndex] = grade;
    }

    public double getGrade(int studentIndex, int assignmentIndex) {
        return grades[assignmentIndex][studentIndex];
    }

    // returns assignment's index
    public int addAssignment(String name, double weight) {
        int assignmentIndex = currentAssignments;
        assignmentNames[currentAssignments] = name;
        assignmentWeights[currentAssignments] = weight;
        currentAssignments = currentAssignments + 1;
        return assignmentIndex;
    }

    // returns the array of class roster
    public Student[] getRoster() {
        return students;
    }

    // returns the current grade given across of the assignments
    public double computeTermGrade(int studentIndex) {
        // find total possible percentage
        double total = 0;
        double points = 0;
        for (int i = 0; i < currentAssignments; i = i + 1) {
            total = total + assignmentWeights[i];
            points = points + grades[i][studentIndex] * assignmentWeights[i];
        }
        return points / total;
    }

    private int findStudentIndex(Student passedStudent) {
        int i;
        for (i = 0; i < currentNumberStudents; i = i + 1) {
            if (passedStudent.equals(students[i]))
                return i;
        }
        return i; // if does not find students returns an index past the end of the array
    }

    public double computeTermGrade(Student passedStudent) {
        return computeTermGrade(findStudentIndex(passedStudent));
    }

    public void printGradeBook(PrintStream p) {
        String tmpLine;
        p.println("Gradebook for " + className);
        p.print("Student Name");
        for (int i = 0; i < currentAssignments; i = i + 1) {
            p.print(", " + assignmentNames[i]);
        }
        p.println(", Total");
        for (int i = 0; i < currentNumberStudents; i = i + 1) {
            tmpLine = students[i].getName();
            for (int j = 0; j < currentAssignments; j = j + 1) {
                tmpLine = tmpLine + ", " + grades[j][i];
            }
            tmpLine = tmpLine + ", " + computeTermGrade(i);
            p.println(tmpLine);
        }
    }

    public void printGradeBook()
    {
        printGradeBook(System.out);
    }

    public static void main(String[] argv) {
        //lets test out the class
        GradeBook g = new GradeBook("ELE 115", 25, 20);
        //Add two assignments
        g.addAssignment("Lab 1", 0.1);
        g.addAssignment("Lab 2", 0.1);
        Student david = new Student("David Wentzlaff", 123, "wentzlaf", "wentzlaf@princeton.edu", 2020);
        Student alexey = new Student("Alexey Lavrov", 456, "alavrov", "alavrov@princeton.edu", 2020);
        int daveIndex = g.addStudent(david);
        int alexeyIndex = g.addStudent(alexey);
        g.setGrade(daveIndex, 0, 90);
        g.setGrade(daveIndex, 1, 80);
        g.setGrade(alexeyIndex, 0, 85);
        g.setGrade(alexeyIndex, 1, 91);
        g.printGradeBook();
    }
}
