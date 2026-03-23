public class StudentGrade {
    private final String name;
    private final double[] marks;

    public StudentGrade(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double[] getMarks() {
        return marks;
    }
}