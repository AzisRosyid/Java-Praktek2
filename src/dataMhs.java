import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class dataMhs {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Mhs> mhs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        while(true) {
            System.out.print("<===== Menu Pilihan =====>\n1. Input Data\n2. Pencarian Data\n3. Penghapusan Data\n4.Menampilkan Data\n5. Keluar Program\nInput Menu yang Anda pilih : ");
            int input = Integer.parseInt(br.readLine());
            switch(input) {
                case 1:
                    inputData();
                    break;
                case 2:
                    pencarianData();
                    break;
                case 3:
                    penghapusanData();
                    break;
                case 4:
                    menampilkanData();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Input yang Anda masukkan tidak ada di dalam Menu!");
                    break;
            }
            System.out.println("\n");
        }
    }

    private static void inputData() throws Exception {
        System.out.print("\n<=== Input Data ===>\nMasukkan jumlah data : ");
        int data = Integer.parseInt(br.readLine());
        for (int i = 0; i < data; i++) {
            System.out.print("\nMasukkan Nama Mahasiswa : ");
            String nama = br.readLine();
            System.out.println("Masukkan Alamat Mahasiswa : ");
            String alamat = br.readLine();
            System.out.println("Masukkan IPK Mahasiswa : ");
            double ipk = Double.parseDouble(br.readLine());
            mhs.add(new Mhs(nama, alamat, ipk));
            menampilkanData();
        }
    }

    private static void pencarianData() throws Exception {
        System.out.print("\n<=== Pencarian Data ===>\nMasukkan Nama Mahasiswa : ");
        String cari = br.readLine();
        for (int i = 0; i < mhs.size(); i++)
            if (cari.equals(mhs.get(i).getNama())) {
                System.out.println("-------------------------\nData Mahasiswa " + cari + " ditemukan!");
                return;
            }
        System.out.println("Data Mahasiswa " + cari + " tidak ditemukan!");
    }

    private static void penghapusanData() throws Exception {
        System.out.print("\n<=== Penghapusan Data ===>\nMasukkan Nama Mahasiswa  : ");
        String hapus = br.readLine();
        for (int i = 0; i < mhs.size(); i++)
            if (hapus.equals(mhs.get(i).getNama())) {
                mhs.remove(hapus);
                System.out.println("-------------------------\nData Mahasiswa " + hapus + " ditemukan dan dihapus!");
                return;
            }
        System.out.println("-------------------------\nData Mahasiswa " + hapus + " tidak ditemukan!");
    }

    private static void menampilkanData() {
        System.out.println("\n<=== Penampilan Data ===>");
        for (int i = 0; i < mhs.size(); i++) {
            System.out.println("TAmpil");
        }
    }

    private static void getSpc() {
        int nama = 4, alamat = 5, ipk = 3;
        int spc = nama + alamat + ipk + 2 * 6;
    
        
    }

}

class Mhs {
    private String nama, alamat;
    private double ipk;

    public Mhs(String nama, String alamat, double ipk) {
        this.nama = nama;
        this.alamat = alamat;
        this.ipk = ipk;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public double getIpk() {
        return ipk;
    }
}