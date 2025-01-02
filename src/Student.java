import java.util.Arrays;

public class Student {

    private String name;
    private int[] grades;

    public Student(String name) {
        this.name = name;
        this.grades = new int[0];
    }

    public Student(String name, int[] grades){
        this.name = name;
        this.grades = new int[grades.length];
        for(int i = 0; i< grades.length; i++){
            if (grades[i]<2 || grades[i]>5){throw new IllegalArgumentException();}
            else {this.grades[i] = grades[i];}
        }
    }

    public Student setGrades(int[] grades) {
        this.grades = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 2 || grades[i] > 5) {
                throw new IllegalArgumentException();
            } else {
                this.grades[i] = grades[i];
            }
        }
        return this;
    }

    public Student addOneGrade(int grade){
        this.grades = Arrays.copyOf(this.grades,this.grades.length + 1);
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException();
        } else {
            this.grades[this.grades.length - 1] = grade;
        }
        return this;
    }
    public Student addGrades(int[] grades){
        for(int item : grades) {
            this.addOneGrade(item);
        }
        return this;
    }

    public String toString(){
        return "Студент "+ this.name + ". Оценки: " + Arrays.toString(this.grades);
    }

}
