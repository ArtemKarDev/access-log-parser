public class Main {
    public static void main(String[] args) {

        Student anton = new Student("Антон",new int[] {2,3,4,5});
        System.out.println(anton);
        Student bony = new Student("Боня");
        System.out.println(bony);
        bony.setGrades(new int[]{5,4,3,2});
        System.out.println(bony);
        anton.addGrades(new int[]{5,5,5}).addOneGrade(2);
        bony.setGrades(new int []{4,4,4}).addOneGrade(5).addGrades(new int [] {3,3,3});
        System.out.println(anton);
        System.out.println(anton.getGrades());
        System.out.println(bony);
        bony.addOneGrade(10);

    }
}
