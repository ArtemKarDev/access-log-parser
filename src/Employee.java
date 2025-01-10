public class Employee {
    public String name;
    private Department dep;

    public Employee(String name, Department dep){
        if (name.isEmpty() || name.equals(" ")){ throw new IllegalArgumentException("Укажите имя сотрудника!");}
        else {this.name = name;}
        this.dep = dep;
    }
    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        if (this == this.dep.getBoss()){
            System.out.println("Сотрудник является начальником отдела "+ this.getDep().department +". Его не возможно перевести в другой отдел!");
        }
        else {
            this.dep = dep;
        }
    }

    @Override
    public String toString(){
        if(this == dep.getBoss()){return "Сотрудник "+ this.name + " начальник отдела " + dep.department;}
        else if (this.dep.getBoss() == null) {
            return "Сотрудник "+ this.name+" работает в отделе "+this.dep.department +", начальник которого не назначен!";
        }
        return "Сотрудник "+ this.name+" работает в отделе "+this.dep.department +", начальник которого "+ this.dep.getBoss().name;
    }

}

