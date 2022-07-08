package entities;

public class Worker {
    private String name;
    private WorkerLevel level;
    private double baseSalary;

    public Worker(String name, WorkerLevel workerLevel, double baseSalary){
        this.name = name;
        this.level = workerLevel;
        this.baseSalary = baseSalary;
    }
    public void addContract(HourContract contract){

    }
    public void removeContract(HourContract contract){

    }
    public double income(int year, int month){
        return baseSalary;
    }
}
