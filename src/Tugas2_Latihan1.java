public class Tugas2_Latihan1 {
    public static void main(String[] args) {
        Mahasiswa_3 MHS = new Mahasiswa_3();
        System.out.println("IDENTITAS AWAL : ");
        MHS.cetak();

        MHS.ubah("DITA", 2010, "Madiun");
        System.out.println("IDENTITAS AKHIR : ");
        MHS.cetak();

        Mahasiswa_3 mhsPTI = new Mahasiswa_3();
        System.out.println("IDENTITAS AWAL : ");
        MHS.cetak();

        mhsPTI.ubah("AZIS ROSYID", 2022, "Yogyakarta");
        System.out.println("IDENTITAS AKHIR : ");
        mhsPTI.cetak();

        Mahasiswa_3 mhsTI = new Mahasiswa_3();
        System.out.println("IDENTITAS AWAL : ");
        mhsTI.cetak();

        mhsTI.ubah("KURNIAWAN", 2010, "Surabaya");
        System.out.println("IDENTITAS AKHIR : ");
        mhsTI.cetak();

        MHS = new Mahasiswa_3();
        System.out.println("IDENTITAS AWAL : ");
        MHS.cetak();

        MHS.ubah("DITA", 2010, "Madiun");
        System.out.println("IDENTITAS AKHIR : ");
        MHS.cetak();
    }
}

class Mahasiswa_3 {
    public String nama;
    public int angkatan;
    public String asal;

    public Mahasiswa_3() {
        nama = "Ani";
        angkatan = 2010;
        asal = "Magelang";
    }

    public void ubah(String nm, int ak, String as) {
        nama = nm;
        angkatan = ak;
        asal = as;
    }

    public void cetak() {
        System.out.println("nama : " + nama);
        System.out.println("angkatann : " + angkatan);
        System.out.println("asal : " + asal);
    }
}