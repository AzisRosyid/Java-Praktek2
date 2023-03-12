class Employee2 {
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

class Programmer2 extends Employee2 {
    private static final int prgSal = 50000;
    private static final int prgBonus = 10000;

    public int Salary() {
        return prgSal;
    }

    public int bonus() {
        return prgBonus;
    }
}

class Manager2 extends Employee2 {
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
    public int calcPayroll(Employee2 emp) {
        int money = emp.salary();
        if (emp instanceof Manager2) 
            money += ((Manager2) emp).tunjungan();
        if (emp instanceof Programmer2) 
            money += ((Programmer2) emp).bonus();
        return money;
    }

    public static void main(String[] args) {
        Program3 pr = new Program3();
        Programmer2 prg = new Programmer2();
        Manager2 mgr = new Manager2();
        System.out.println("Payroll untuk Programmer: " + pr);
        System.out.println("Payroll untuk Manager:" + pr.calcPayroll(mgr));
    }
}