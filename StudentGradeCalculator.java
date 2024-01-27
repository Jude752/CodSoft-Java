import java.util.Scanner;

public class StudentGradeCalculator {

    // Constants for grade ranges
    private static final int A_PLUS_THRESHOLD = 85;
    private static final int A_THRESHOLD = 75;
    private static final int B_THRESHOLD = 65;
    private static final int C_THRESHOLD = 55;
    private static final int D_THRESHOLD = 45;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display grading criteria
        displayGradingCriteria();

        // Get the number of subjects from the user
        int numSubjects = getNumberOfSubjects(scanner);

        // Input marks for each subject
        int[] marks = getMarksForSubjects(scanner, numSubjects);

        // Calculate total marks and average percentage
        int totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

        // Assign grades based on the new criteria
        String grade = calculateGrade(averagePercentage);

        // Display results with explanations
        displayResults(totalMarks, averagePercentage, grade);

        // Close the scanner
        scanner.close();
    }

    // Display grading criteria
    private static void displayGradingCriteria() {
        System.out.println("Grading Criteria:");
        System.out.println(">= " + A_PLUS_THRESHOLD + " - A+ (Excellent)");
        System.out.println(">= " + A_THRESHOLD + " - A (Very Good)");
        System.out.println(">= " + B_THRESHOLD + " - B (Good)");
        System.out.println(">= " + C_THRESHOLD + " - C (Satisfactory)");
        System.out.println(">= " + D_THRESHOLD + " - D (Needs Improvement)");
        System.out.println("< " + D_THRESHOLD + " - F (Fail)");
    }

    // Get the number of subjects from the user
    private static int getNumberOfSubjects(Scanner scanner) {
        System.out.println("\nEnter the number of subjects:");
        return scanner.nextInt();
    }

    // Input marks for each subject
    private static int[] getMarksForSubjects(Scanner scanner, int numSubjects) {
        int[] marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.printf("Enter marks for Subject %d (out of 100): ", i + 1);
            marks[i] = scanner.nextInt();
        }
        return marks;
    }

    // Calculate total marks by summing up individual subject marks
    private static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    // Calculate average percentage by dividing total marks by the number of subjects
    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    // Assign grades based on the specified criteria
    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= A_PLUS_THRESHOLD) {
            return "A+";
        } else if (averagePercentage >= A_THRESHOLD) {
            return "A";
        } else if (averagePercentage >= B_THRESHOLD) {
            return "B";
        } else if (averagePercentage >= C_THRESHOLD) {
            return "C";
        } else if (averagePercentage >= D_THRESHOLD) {
            return "D";
        } else {
            return "F";
        }
    }

    // Display results with explanations
    private static void displayResults(int totalMarks, double averagePercentage, String grade) {
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}
