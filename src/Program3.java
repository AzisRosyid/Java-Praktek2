class Employee {
    String nama;
    int Salary;

    void Employee() {
    }

    void Employee(String nm) {
        this.nama = nm;
        System.out.println("Employee");
    }

    public int salary() {
        return 0;
    }
}

class Programmer extends Employee {
    private static final int prgSal = 50000;
    private static final int prgBonus = 10000;

    public int Salary() {
        return prgSal;
    }

    public int bonus() {
        return prgBonus;
    }
}

class Manager extends Employee {
    private static final int mgrSal = 40000;
    private static final int tunjungan = 40000;

    public int salary() {
        return mgrSal;
    }

    public int tunjungan() {
        return tunjungan;
    }
}

public class Program3 { // Payroll
    public int calcPayroll(Employee emp) {
        int money = emp.salary();
        if (emp instanceof Manager) 
            money += ((Manager) emp).tunjungan();
        if (emp instanceof Programmer) 
            money += ((Programmer) emp).bonus();
        return money;
    }

    public static void main(String[] args) {
        Program3 pr = new Program3();
        Programmer prg = new Programmer();
        Manager mgr = new Manager();
        System.out.println("Payroll untuk Programmer: " + pr);
        System.out.println("Payroll untuk Manager:" + pr.calcPayroll(mgr));
    }
}