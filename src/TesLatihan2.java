public class TesLatihan2 {
    public static void main(String[] args) {
        Mahasiswa mhs = new TesLatihan2().new Mahasiswa(12345, "Jono");
        System.out.println("NRP : " + mhs.getNrp());
        System.out.println("Nama : " + mhs.getNama());
    }

    public class Mahasiswa { // Mahasiswa
        private int nrp;
        private String nama = "";
    
        public Mahasiswa(int i, String n) {
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
}