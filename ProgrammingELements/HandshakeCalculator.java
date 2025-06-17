//Importing Scanner Class from util package
import java.util.Scanner;
//Computing maximum number of handshakes
public class HandshakeCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Take the input from user to enter the number of students
        int numberOfStudents = scanner.nextInt();

        // Calculate maximum number of handshakes using the formula: n(n-1)/2
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        // Display the result
        System.out.println("Maximum number of possible handshakes: " + handshakes);

        // Close the scanner to prevent resource leak
        sc.close();
    }
}
