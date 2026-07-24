public class Student {
    int id;
    String name;
    double[] grades = new double[2];

    Student(int id, String name, double firstGrade, double secondGrade) {
        this.id = id;
        this.name = name;
        this.grades[0] = firstGrade;
        this.grades[1] = secondGrade;
    }

    double calculateFinalGrade() {
        return (grades[0] + grades[1]) / 2;
    }

    String getGradeStatus() {
        double finalGrade = calculateFinalGrade();
        if (finalGrade >= 90) {
            return "Excellent";
        } else if (finalGrade >= 75) {
            return "Very Good";
        } else if (finalGrade >= 60) {
            return "Pass";
        } else
            return "Fail";
    }

    void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Subject 1 Grade: " + grades[0] + ", Subject 2 Grade: " + grades [1] + ", Final Grade: " + calculateFinalGrade() + ", Status: " + getGradeStatus());
    }

}

