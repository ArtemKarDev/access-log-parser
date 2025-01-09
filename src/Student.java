import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String name;
    private List<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public Student(String name, int[] grades){
        this(name);
        this.grades = this.addGradesPrivate(grades);
    }

    public Student setGrades(int[] grades) {
        this.grades = new ArrayList<>();
        this.addGradesPrivate(grades);
        return this;
    }

    private List<Integer> addOneGradePrivate(int grade){
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Оценка не может быть меньше 2 и больше 5!");
        } else {
            this.grades.add(grade);
        }
        return this.grades;
    }

    public Student addOneGrade(int grade){
        this.grades = addOneGradePrivate(grade);
        return this;
    }

    private List<Integer> addGradesPrivate(int[] grades){
        for(int item : grades) {
            this.addOneGradePrivate(item);
        }
        return this.grades;
    }

    public Student addGrades(int[] grades){
        this.grades = this.addGradesPrivate(grades);
        return this;
    }

    public List<Integer> getGrades(){
        return this.grades;
    }
    @Override
    public String toString(){
        return "Студент "+ this.name + ". Оценки: " + this.grades;
    }

}
