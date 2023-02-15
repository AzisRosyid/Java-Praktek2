public class Tugas2_Latihan2 {
    public static void main(String[] args) {
        Lingkup varx = new Lingkup();
        varx.infoLingkup();
    }
}

class Lingkup {
    String sifat = "Marah";

    void infoLingkup() {
        String sifat = "Malu";
        System.out.println("Sifat pada metode : " + sifat);
        System.out.println("Sifat milik kelas : " + this.sifat);

    }
}
