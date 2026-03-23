import java.util.*;

public class GradeManagementSystem {

    private static final int SUBJECT_COUNT = 5;
    private static final ArrayList<StudentGrade> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n=== GRADE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student Marks");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Averages");
            System.out.println("4. Find Top Performers");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidInt(1, 6);

            switch (choice) {
                case 1 -> addStudentMarks();
                case 2 -> viewAllStudents();
                case 3 -> calculateAverages();
                case 4 -> findTopPerformers();
                case 5 -> ReportGenerator.generateReport(students);
                case 6 -> {
                    running = false;
                    System.out.println("Thank you for using Grade Management System!");
                }
            }
        }
    }

    //Add Student Marks
    private static void addStudentMarks() {
        System.out.println("\n=== ADD STUDENT MARKS ===");

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        double[] marks = new double[SUBJECT_COUNT];
        String[] subjects = {"Mathematics", "Science", "English", "History", "Computer"};

        System.out.println("\nEnter marks for 5 subjects (out of 100):");

        for (int i = 0; i < SUBJECT_COUNT; i++) {
            System.out.print(subjects[i] + ": ");
            marks[i] = getValidMark();
        }

        students.add(new StudentGrade(name, marks));
        System.out.println("✅ Student marks added successfully!");
    }

    //View All Students
    private static void viewAllStudents() {
        System.out.println("\n=== ALL STUDENTS ===");

        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.printf("%-20s %-12s %-12s %-12s %-12s %-12s %-12s\n",
                "Student Name", "Math", "Science", "English", "History", "Computer", "Average");

        System.out.println("----------------------------------------------------------------------------------------------------");

        for (StudentGrade s : students) {
            double avg = GradeCalculator.calculateAverage(s.getMarks());

            System.out.printf("%-20s %-12.2f %-12.2f %-12.2f %-12.2f %-12.2f %-12.2f\n",
                    s.getName(),
                    s.getMarks()[0],
                    s.getMarks()[1],
                    s.getMarks()[2],
                    s.getMarks()[3],
                    s.getMarks()[4],
                    avg);
        }
    }

    //Calculate Averages
    private static void calculateAverages() {
        System.out.println("\n=== STUDENT AVERAGES ===");

        for (StudentGrade s : students) {
            double avg = GradeCalculator.calculateAverage(s.getMarks());
            String grade = GradeCalculator.getGrade(avg);

            System.out.printf("%-15s : Average = %.2f, Grade = %s\n",
                    s.getName(), avg, grade);
        }
    }

    //Top Performers
    private static void findTopPerformers() {
        System.out.println("\n=== TOP PERFORMERS ===");

        if (students.isEmpty()) {
            System.out.println("No data available!");
            return;
        }

        students.sort((a, b) -> Double.compare(
                GradeCalculator.calculateAverage(b.getMarks()),
                GradeCalculator.calculateAverage(a.getMarks())
        ));

        for (int i = 0; i < students.size(); i++) {
            StudentGrade s = students.get(i);
            double avg = GradeCalculator.calculateAverage(s.getMarks());

            System.out.printf("%d. %s - Average: %.2f\n",
                    i + 1, s.getName(), avg);
        }
    }

    //Validation
    private static int getValidInt(int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) return value;
                else System.out.print("Enter between " + min + "-" + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Enter number: ");
            }
        }
    }

    private static double getValidMark() {
        while (true) {
            try {
                double mark = Double.parseDouble(scanner.nextLine());
                if (mark >= 0 && mark <= 100) return mark;
                else System.out.print("Marks must be 0-100: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Enter number: ");
            }
        }
    }
}