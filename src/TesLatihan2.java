public class TesLatihan2 {
    public static void main(String[] args) {
        Mahasiswa_2 mhs = new Mahasiswa_2(12345, "Jono");
        System.out.println("NRP : " + mhs.getNrp());
        System.out.println("Nama : " + mhs.getNama());
    }
}

class Mahasiswa_2 { // Mahasiswa
    private int nrp;
    private String nama = "";

    public Mahasiswa_2(int i, String n) {
        nrp = i;
        nama = n;
    }

    public int getNrp() {
        return nrp;
    }

    public String getNama() {
        return nama;
    }
}
