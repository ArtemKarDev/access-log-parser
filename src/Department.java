public class Department {
    private Employee boss;
    public String department;

    public Department(String department){
        this.department = department;
    }

    public void setBoss(Employee employee){
        if(employee.getDep() == this){
            this.boss = employee;
        }else {
            System.out.println("Это сотрудник не из этого отдела!");
        }
    }

    public Employee getBoss(){
        return this.boss;
    }

    public String toString(){
        return "Департамент: "+ this.department+" Начальник: "+this.boss.name;
    }
}
