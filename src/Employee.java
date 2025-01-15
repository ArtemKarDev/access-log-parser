public class Employee {
    private String name;
    private Department dep;

    public Employee(String name, Department dep){
        if (name.isEmpty() || name.isBlank()){ throw new IllegalArgumentException("Укажите имя сотрудника!");}
        else {this.name = name;}
        this.dep = dep;
    }
    public Department getDep() {
        return this.dep;
    }
    public String getName() {
        return this.name;
    }



    public void setDep(Department dep) {
        if (this == this.dep.getBoss()){
            System.out.println("Сотрудник является начальником отдела "+ this.getDep().getDepName() +". Его не возможно перевести в другой отдел!");
        }
        else {
            this.dep = dep;
        }
    }

    @Override
    public String toString(){
        if(this == dep.getBoss()){return "Сотрудник "+ this.name + " начальник отдела " + dep.getDepName();}
        else if (this.dep.getBoss() == null) {
            return "Сотрудник "+ this.name+" работает в отделе "+this.dep.getDepName() +", начальник которого не назначен!";
        }
        return "Сотрудник "+ this.name+" работает в отделе "+this.dep.getDepName() +", начальник которого "+ this.dep.getBossName();
    }

}

