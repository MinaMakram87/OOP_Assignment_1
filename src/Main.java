import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of students: ");
        int n = scanner.nextInt();
        Student[] students = new Student[n];

        scanner.nextLine();

        for (int i = 0; i < n; i++){
            System.out.println("Enter student " + (i + 1) + " information:");
            System.out.println("Enter ID: ");
            int id = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.println("Enter first subject grade: ");
            double firstGrade = scanner.nextDouble();

            while (firstGrade < 0 || firstGrade >100){
                System.out.println("Invalid grade.");

                System.out.println("Enter first subject grade again: ");
                firstGrade = scanner.nextDouble();
            }

            System.out.println("Enter second subject grade: ");
            double secondGrade = scanner.nextDouble();

            while (secondGrade < 0 || secondGrade > 100) {
                System.out.println("Invalid grade.");

                System.out.println("Enter second subject grade again: ");
                secondGrade = scanner.nextDouble();
            }

            students[i] = new Student(id, name, firstGrade, secondGrade);
            scanner.nextLine();
        }

        int menuChoice;

        do {
            System.out.println("===== Main Menu =====");
            System.out.println("1. Display Students");
            System.out.println("2. Calculate Average Grade");
            System.out.println("3. Find Highest Grade");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Count Passed and Failed Students");
            System.out.println("6. Sort Students by Grade");
            System.out.println("0. Exit");
            System.out.println("=====================");

            System.out.println("Enter your choice: ");
            menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    for (int i = 0; i < n; i++)
                        students[i].displayInfo();
                    break;
                case 2:
                    double sum = 0;
                    for (int i = 0; i < n; i++){
                        sum = sum + students[i].calculateFinalGrade();
                    }
                    double average = sum / n;
                    System.out.println("Average Grade: " + average);
                    break;
                case 3:
                    int highestIndex = 0;
                    for (int i = 1; i < n; i++){
                        if (students[i].calculateFinalGrade() > students[highestIndex].calculateFinalGrade()){
                            highestIndex = i;
                        }
                    }
                    System.out.println("Student with highest grade:");
                    students[highestIndex].displayInfo();
                    break;
                case 4:
                    System.out.println("Enter student ID: ");
                    int searchId = scanner.nextInt();
                    boolean found = false;
                    for (int i = 0; i < n; i++){
                        if (students[i].id == searchId){
                            students[i].displayInfo();
                            found = true;
                            break;
                        }
                    }
                    if (found == false){
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    int passedStudents = 0;
                    int failedStudents = 0;
                    for (int i = 0; i < n; i++){
                        if (students[i].calculateFinalGrade() >= 60){
                            passedStudents++;
                        }else {
                            failedStudents++;
                        }
                    }
                     System.out.println("Passed Students: " + passedStudents);
                     System.out.println("Failed Students: " + failedStudents);
                     break;
                case 6:
                    for (int i = 0; i < n - 1; i++){
                        for (int j = i + 1; j < n; j++){
                            double firstGrade = students[i].calculateFinalGrade();
                            double secondGrade = students[j].calculateFinalGrade();
                            if (secondGrade > firstGrade){
                                Student temp = students[i];
                                students[i] = students[j];
                                students[j] = temp;
                            }
                        }
                    }
                    System.out.println("Students sorted by grade:");
                    for (int i = 0; i < n; i++){
                        students[i].displayInfo();
                    }
                    break;
                case 0:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }while (menuChoice != 0);

        scanner.close();
    }
}