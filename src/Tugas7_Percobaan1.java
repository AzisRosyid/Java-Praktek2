public class Tugas7_Percobaan1 {
    public static void main(String[] args) {
        Manager mng = new Manager("Andi", 300.0);
        System.out.println(mng.getNama());
        System.out.println(mng.getBonus());
        System.out.println(mng.getGaji());
    }
}

class Karyawan {
    private String nama;
    private double gaji;
    private static double persennaikgaji = 0.10;

    public Karyawan(String nm, double gj) {
        this.setNama(nm);
        this.setGaji(gj);
    }

    void setNama(String nm) {
        nama = nm;
    }

    void setGaji(double gj) {
        gaji = gj;
    }

    static void setPresentase(double persen) {
        persennaikgaji = persen;
    }

    String getNama() {
        return nama;
    }

    double getGaji() {
        return gaji;
    }

    static double getPersentase() {
        return persennaikgaji;
    }

    void naikkanGaji() {
        gaji += (gaji * persennaikgaji);
    }
}

class Manager extends Karyawan {
    private static double bonus = 500;

    Manager(String nm, double gj) {
        super(nm, gj);
    }

    double getBonus() {
        return bonus;
    }

    void setBonus(double bns) {
        bonus = bns;
    }

    double getGaji() {
        double gajidasar = super.getGaji();
        return (gajidasar + bonus);
    }
}
