class Employee {
    String nama;

    Employee() {
        System.out.println("Konstruktor Employee() dijalankan");
    }

    void Employee(String n) {
        this.nama = n;
        System.out.println("Konstruktor Employee(String n) dijalankan");
    }

    void getDetails() {
        System.out.println(nama);
    }
}

class Program2 extends Employee { // Manager2
    String departement;

    Program2() {
        this.Employee("sales");
        System.out.println("Konstruktor manager() dijalankan");
    }

    Program2(String dept) {
        departement = dept;
        System.out.println("Konstruktor Manager(String dept) dijalankan");
    }

    void getDetails() {
        System.out.println(departement);
    }

    public static void main(String args[]) {
        Program2 e = new Program2();
        e.getDetails();
    }
}

// Kesimpulannya constructor dan method dari Class parrent tereksekusi terlebih dahulu baru class childnya