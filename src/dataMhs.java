import java.io.BufferedReader;
import java.io.InputStreamReader;

public class dataMhs {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Mahasiswa[] data;

    public static void main(String[] args) throws Exception {
        while(true) {
            System.out.print("<===== Menu Pilihan =====>\n1. Input Data\n2. Pencarian Data\n3. Penghapusan Data\n4. Menampilkan Data\n5. Keluar Program\nInput Menu yang Anda pilih : ");
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
            System.out.println();
        }
    }

    private static void inputData() throws Exception {
        System.out.print("\n<=== Input Data ===>\nMasukkan jumlah data Mahasiswa : ");
        int mhs = Integer.parseInt(br.readLine());
        data = new Mahasiswa[mhs];
        for (int i = 0; i < mhs; i++) {
            System.out.print("\nMasukkan Nama Mahasiswa : ");
            String nama = br.readLine();
            System.out.print("Masukkan Alamat Mahasiswa : ");
            String alamat = br.readLine();
            System.out.print("Masukkan IPK Mahasiswa : ");
            double ipk = Double.parseDouble(br.readLine());
            data[i] = new Mahasiswa(nama, alamat, ipk);
            tampilData(data);
        }
    }

    private static void pencarianData() throws Exception {
        System.out.print("\n<=== Pencarian Data ===>\nMasukkan Nama Mahasiswa : ");
        String cari = br.readLine();
        for (int i = 0; i < data.length; i++)
            if (cari.equals(data[i].getNama())) {
                tampilData(new Mahasiswa[] {data[i]});
                System.out.println("Data Mahasiswa " + cari + " ditemukan!");
                return;
            }
        System.out.println("-------------------------\nData Mahasiswa " + cari + " tidak ditemukan!");
    }

    private static void penghapusanData() throws Exception {
        System.out.print("\n<=== Penghapusan Data ===>\nMasukkan Nama Mahasiswa  : ");
        String hapus = br.readLine();
        for (int i = 0; i < data.length; i++)
            if (hapus.equals(data[i].getNama())) {
                Mahasiswa[] temp = new Mahasiswa[data.length-1];
                for (int j = 0; j < data.length; j++)
                    if (j == i) continue;
                    else if (j < i) 
                        temp[j] = data[j];
                    else 
                        temp[j-1] = data[j];
                data = temp;
                System.out.println("-------------------------\nData Mahasiswa " + hapus + " ditemukan dan dihapus!");
                return;
            }
        System.out.println("-------------------------\nData Mahasiswa " + hapus + " tidak ditemukan!");
    }

    private static void menampilkanData() {
        System.out.print("\n<=== Penampilan Data ===>");
        tampilData(data);
    }

    private static void tampilData(Mahasiswa[] mhs) {
        int nama = 6, alamat = 7, ipk = 5;
        for (Mahasiswa i: mhs) {
            if (i == null) break;
            if ((i.getNama().length() + 2) > nama) 
                nama = i.getNama().length() + 2;
            if ((i.getAlamat().length() + 2) > alamat) 
                alamat = i.getAlamat().length() + 2;
            if ((i.getNama().length() + 2) > ipk) 
                ipk = String.valueOf(i.getIpk()).length() + 2;
        }
        int spc = nama + alamat + ipk + 2 * 4;
        System.out.println();
            for (int i = 0; i < spc; i++) {
                System.out.print("-");
            }
        System.out.println();
        System.out.printf("%" + -nama + "s||  %" + -alamat + "s||  %" + -ipk + "s", "Nama", "Alamat", "IPK");
        System.out.println();
            for (int i = 0; i < spc; i++) {
                System.out.print("-");
            }
        System.out.println();
        for (Mahasiswa i: mhs) {
            if (i == null) break;
            System.out.printf("\n%" + -nama + "s||  %" + -alamat + "s||  %" + -ipk + "s", i.getNama(), i.getAlamat(), i.getIpk());
        }
        System.out.println();
        for (int i = 0; i < spc; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

class Mahasiswa {
    private String nama, alamat;
    private double ipk;

    public Mahasiswa (String nama, String alamat, double ipk) {
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