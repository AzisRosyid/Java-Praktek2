

class Employee1 {
    String nama;

    Employee1() {
        System.out.println("Konstruktor Employee() dijalankan");
    }

    Employee1(String n) {
        this.nama = n;
        System.out.println("Konstruktor Employee(String n) dijalankan");
    }

    void getDetails() {
        System.out.println(nama);
    }
}

class Manager1 extends Employee1 {
    String departement;

    Manager1() {
        super("sales");
        System.out.println("Konstruktor manager() dijalankan");
    }

    Manager1(String dept) {
        departement = dept;
        System.out.println("Konstruktor Manager(String dept)dijalankan");
    }

    void getDetails() {
        System.out.println(departement);
    }

    public static void main(String args[]) {
        Manager1 e = new Manager1();
        e.getDetails();
    }
}
