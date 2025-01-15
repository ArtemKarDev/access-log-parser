public class Department {
    private Employee boss;
    private String department;

    public Department(String department){
        if (department.isEmpty() || department.isBlank()){
            throw new IllegalArgumentException("Укажите название отдела!");
        }
        else {this.department = department;}
    }

    public void setBoss(Employee employee){
        this.boss = employee;
        if (employee.getDep() != this){
            employee.setDep(this);
        }
    }

    public Employee getBoss(){
        return this.boss;
    }

    public String getDepName(){
        return this.department;
    }
    public String getBossName(){
        return this.boss.getName();
    }

    @Override
    public String toString(){
        if(this.getBoss() == null){
            return "Департамент: "+ this.department+" без начальника!";
        }
        return "Департамент: "+ this.department+" Начальник: "+ this.boss.getName();
    }
}
