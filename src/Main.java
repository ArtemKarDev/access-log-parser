public class Main {
    public static void main(String[] args) {

        Department dep1 = new Department("ИТ");
        Department dep2 = new Department("Маркетинг");

        Employee emp1 = new Employee("Антон", dep1);
        Employee emp2 = new Employee("Евгений", dep1);
        Employee emp3 = new Employee("Мария", dep2);

        dep1.setBoss(emp1);
        dep1.setBoss(emp3);
        dep2.setBoss(emp3);
        System.out.println(emp1);
        System.out.println(emp2);

        emp1.setDep(dep2);
        System.out.println(emp2);
        System.out.println(emp1);

    }
}
