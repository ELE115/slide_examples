public class Student {
    private String name;
    private long idNumber;
    private String netid;
    private String email;
    private int classYear;

    public Student(String passedName, long passedIdNumber, String passedNetid, String passedEmail, int passedClassYear) {
        name = passedName;
        idNumber = passedIdNumber;
        netid = passedNetid;
        email = passedEmail;
        classYear = passedClassYear;
    }

    public int getClassYear() {
        return classYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String passedName) {
        name = passedName;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long passedIdNumber) {
        idNumber = passedIdNumber;
    }

    public String getNetid() {
        return netid;
    }

    public void setNetid(String passedNetid) {
        netid = passedNetid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String passedEmail) {
        email = passedEmail;
    }

    public void setClassYear(int passedClassYear) {
        classYear = passedClassYear;
    }

    public String toString() {
        return name + " : " + idNumber + " : " + netid +
                " : " + email + " : " + classYear;
    }

    public boolean equals(Student s) {
        return idNumber == s.idNumber && classYear == s.classYear && name.equals(s.name) && netid.equals(s.netid) && email.equals(s.email);
    }

    public static void main(String[] args) {
        Student s = new Student("David Wentzlaff", 1234, "wentzlaf", "wentzlaf@princeton.edu", 2020);
        System.out.println(s.toString());
    }
}
