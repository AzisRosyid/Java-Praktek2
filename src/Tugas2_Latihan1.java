public class Tugas2_Latihan1 {
    public static void main(String[] args) {
        Mahasiswa MHS = new Tugas2_Latihan1().new Mahasiswa();
        System.out.println("IDENTITAS AWAL : ");
        MHS.cetak();

        MHS.ubah("DITA", 2010, "Madiun");
        System.out.println("IDENTITAS AKHIR : ");
        MHS.cetak();

        Mahasiswa mhsPTI = new Tugas2_Latihan1().new Mahasiswa();
        System.out.println("IDENTITAS AWAL : ");
        MHS.cetak();

        mhsPTI.ubah("AZIS ROSYID", 2022, "Yogyakarta");
        System.out.println("IDENTITAS AKHIR : ");
        mhsPTI.cetak();

        Mahasiswa mhsTI = new Tugas2_Latihan1().new Mahasiswa();
        System.out.println("IDENTITAS AWAL : ");
        mhsTI.cetak();

        mhsTI.ubah("KURNIAWAN", 2010, "Surabaya");
        System.out.println("IDENTITAS AKHIR : ");
        mhsTI.cetak();

        MHS = new Tugas2_Latihan1().new Mahasiswa();
        System.out.println("IDENTITAS AWAL : ");
        MHS.cetak();

        MHS.ubah("DITA", 2010, "Madiun");
        System.out.println("IDENTITAS AKHIR : ");
        MHS.cetak();
    }

    class Mahasiswa {
        public String nama;
        public int angkatan;
        public String asal;
    
        public Mahasiswa() {
            nama = "Ani";
            angkatan = 2010;
            asal = "Magelang";
        }
    
        public void ubah(String nama, int angkatan, String asal) {
            this.nama = nama;
            this.angkatan = angkatan;
            this.asal = asal;
        }
    
        public void cetak() {
            System.out.println("nama     : " + nama);
            System.out.println("angkatan : " + angkatan);
            System.out.println("asal     : " + asal);
        }
    }
}

