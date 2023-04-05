public class Tugas2_Latihan3 {
    public static void main(String[] args) {
        Scoope varx = new Scoope();
        varx.infoScoope();
    }
}

class Scoope {
    int angka = 20;
    void infoScoope() {
        int angka1 = 12;
        System.out.println("Angka di method : " + angka1);
        System.out.println("Angka di kelas : " + this.angka);
        int modulus = angka % angka1;
        System.out.println("Sisa hasil : " + modulus);
        float bagi = angka / angka1;
        System.out.println("Hasil Bagi : " + bagi);
    }
}
