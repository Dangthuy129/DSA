public class Student {
    private static int autoIncrementId = 1; // Tự động tăng ID
    private final int id;
    private String name;
    private double marks;
    private String rank;

    public Student(String name, double marks) {
        this.id = autoIncrementId++;
        this.name = name;
        this.marks = marks;
        this.rank = calculateRank();
    }

    private String calculateRank() {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getRank() {
        return rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        this.rank = calculateRank();
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Marks: %.2f, Rank: %s", id, name, marks, rank);
    }
}
