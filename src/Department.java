public class Department {
    private Employee boss;
    public String department;

    public Department(String department){
        if (department.isEmpty() || department.equals(" ")){
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

    @Override
    public String toString(){
        if(this.getBoss() == null){
            return "Департамент: "+ this.department+" без начальника!";
        }
        return "Департамент: "+ this.department+" Начальник: "+this.boss.name;
    }
}
