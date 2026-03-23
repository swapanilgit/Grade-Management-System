import java.util.*;

public class ReportGenerator {

    public static void generateReport(ArrayList<StudentGrade> students) {

        System.out.println("\n=== PERFORMANCE REPORT ===");

        if (students.isEmpty()) {
            System.out.println("No data available!");
            return;
        }

        int totalStudents = students.size();
        System.out.println("Total Students: " + totalStudents);

        int subjects = 5;
        double[] subjectTotals = new double[subjects];

        // Calculate subject totals
        for (StudentGrade s : students) {
            double[] marks = s.getMarks();
            for (int i = 0; i < subjects; i++) {
                subjectTotals[i] += marks[i];
            }
        }

        String[] subjectNames = {"Mathematics", "Science", "English", "History", "Computer"};

        System.out.println("\n📊 SUBJECT AVERAGES:");
        for (int i = 0; i < subjects; i++) {
            double avg = subjectTotals[i] / totalStudents;
            System.out.printf("• %s: %.2f\n", subjectNames[i], avg);
        }

        // Top Performers
        System.out.println("\n🏆 TOP PERFORMERS:");

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

        // Grade Distribution
        int A = 0, B = 0, C = 0, D = 0, F = 0;

        for (StudentGrade s : students) {
            double avg = GradeCalculator.calculateAverage(s.getMarks());
            String grade = GradeCalculator.getGrade(avg);

            switch (grade) {
                case "A+", "A" -> A++;
                case "B" -> B++;
                case "C" -> C++;
                case "D" -> D++;
                default -> F++;
            }
        }

        System.out.println("\n📈 GRADE DISTRIBUTION:");
        System.out.println("• A Grade: " + A + " students");
        System.out.println("• B Grade: " + B + " students");
        System.out.println("• C Grade: " + C + " students");
        System.out.println("• D Grade: " + D + " students");
        System.out.println("• F Grade: " + F + " students");
    }
}