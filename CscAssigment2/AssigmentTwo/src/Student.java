import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//student class for creating PART 1-
class Student {
    private final String name;
    private final int rollNumber;
    private final double[] marks;3
//constructor
    public Student(String name, int rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public double calculateAverageMarks() {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    public void displayStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Average Marks: " + calculateAverageMarks());
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

 class StudentRecordSystem {
    private static final String FILE_PATH = "StudentRecords.txt";

    public static void main(String[] args) {
        createOrLoadStudentRecordsFile();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add new student record:");
            System.out.println("2. View all records:");
            System.out.println("3. Search for a student by roll number:");
            System.out.println("4. Edit an existing student record by roll number:");
            System.out.println("5. Delete a student record by roll number:");
            System.out.println("6. Exit:");
            System.out.print("Enter your choice from on of the (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudentRecord(scanner);
                    break;
                case 2:
                    viewAllStudentRecords();
                    break;
                case 3:
                    searchStudentRecord(scanner);
                    break;
                case 4:
                    editStudentRecord(scanner);
                    break;
                case 5:
                    deleteStudentRecord(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }
//part 2
    private static void createOrLoadStudentRecordsFile() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                file.createNewFile();
            }
            //part3
        } catch (IOException e) {
            System.err.println("Error!: " + e.getMessage());
        }
    }

    private static void addStudentRecord(Scanner scanner) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true); //to enable to write characters to a file
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);//writing to the file by buffering
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) { //text ouput

            System.out.println("Enter student's name: ");
            String name = scanner.nextLine();

            int rollNumber;
            try {
                System.out.println("Enter student's roll number: ");
                rollNumber = Integer.parseInt(scanner.nextLine());//  reads a line of input
            } catch (NumberFormatException e) {// input cannot be parsed as an integer then invalid
                throw new InvalidInputException("Invalid roll number");
            }

            System.out.print("Enter student's marks (comma-separated): ");
            String marksInput = scanner.nextLine(); //read marks
            String[] marksArray = marksInput.split(",");// splits input based by commas
            double[] marks = new double[marksArray.length];
            for (int i = 0; i < marksArray.length; i++) {// marks input into array
                marks[i] = Double.parseDouble(marksArray[i]);// makes it to double
            }

            Student student = new Student(name, rollNumber, marks);
            printWriter.println(student);
            System.out.println("Student record added successfully.");

        } catch (IOException | InvalidInputException e) { // checks again with vaild
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void viewAllStudentRecords() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int rollNumber = Integer.parseInt(parts[1]);
                double[] marks = new double[parts.length - 2];
                for (int i = 2; i < parts.length; i++) {
                    marks[i - 2] = Double.parseDouble(parts[i]);
                }
                Student student = new Student(name, rollNumber, marks);
                student.displayStudentInfo();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void searchStudentRecord(Scanner scanner) {
        System.out.print("Enter roll number: ");
        int targetRollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean found = false;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                int rollNumber = Integer.parseInt(parts[1]);
                if (rollNumber == targetRollNumber) {
                    found = true;
                    String name = parts[0];
                    double[] marks = new double[parts.length - 2];
                    for (int i = 2; i < parts.length; i++) {
                        marks[i - 2] = Double.parseDouble(parts[i]);
                    }
                    Student student = new Student(name, rollNumber, marks);
                    student.displayStudentInfo();
                    break; // Exit loop when the first match is found
                }
            }
            if (!found) {
                System.out.println("Student record not found.");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void editStudentRecord(Scanner scanner) {
        System.out.print("Enter the roll number of the student to edit: ");
        int targetRollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<String> records = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean found = false;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                int rollNumber = Integer.parseInt(parts[1]); //pp
                if (rollNumber == targetRollNumber) {
                    found = true;
                    System.out.println("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new marks (comma-separated): ");
                    String newMarksInput = scanner.nextLine();

                    // Create the updated student record
                    String updatedRecord = newName + "," + targetRollNumber + "," + newMarksInput;
                    records.add(updatedRecord);
                    System.out.println("Student record updated successfully.");
                } else {
                    records.add(line);
                }
            }

            if (!found) {
                System.out.println("Student record not found.");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Write the updated records back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    private static void deleteStudentRecord(Scanner scanner) {
        System.out.print("Enter the roll number of the student to delete: ");
        int targetRollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<String> records = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean found = false;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");

//checks if it has the name and roll number
            if (parts.length >= 2) {
                int rollNumber = Integer.parseInt(parts[1]);//roll as an array
//used to check that it was deleted by using finding if statement is ture or fasle
                if (rollNumber == targetRollNumber) {
                    found = true;
                    System.out.println("Student record deleted successfully.");
                } else {
                    records.add(line);
                }
            }
        }
            if (!found) {
                System.out.println("Student not found.");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Write the remaining records (without the deleted one) back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

}
