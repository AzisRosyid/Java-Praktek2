public class TesLatihan2 {
    public static void main(String[] args) {
        Mhs mhs = new Mhs(12345, "Jono");
        System.out.println("NRP : " + mhs.getNrp());
        System.out.println("Nama : " + mhs.getNama());
    }
}

class Mhs { // Mahasiswa
    private int nrp;
    private String nama = "";

    public Mhs(int i, String n) {
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
