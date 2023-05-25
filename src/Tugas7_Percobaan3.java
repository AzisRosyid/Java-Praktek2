public class Tugas7_Percobaan3 {

}

class Employee2 {
    String nama;
    int Salary;

    Employee2() {
    }

    Employee2(String nm) {
        this.nama = nm;
        System.out.println("Employee");
    }

    public int salary() {
        return 0;
    }
}

class Programmer extends Employee2 {
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

class Payroll {
    public int calcPayroll(Employee2 emp) {
        int money = emp.salary();
        if (emp instanceof Manager2)
            money += new Manager2().tunjungan();
        if (emp instanceof Programmer)
            money += new Programmer().bonus();
        return money;
    }

    public static void main(String[] args) {
        Payroll pr = new Payroll();
        Programmer prg = new Programmer();
        Manager2 mgr = new Manager2();
        System.out.println("Payroll untuk Programmer: " + pr.calcPayroll(prg));
        System.out.println("Payroll untuk Manager:" + pr.calcPayroll(mgr));
    }
}
