import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Tugas2_4 {
    public static void main(String[] args) throws Exception {
        Absen absen = new Absen();
        while(true) {
            System.out.print("====> Program Absensi <====\nMenu :\na. Menambah mahasiswa\nb. Melihat jumlah mahasiswa yang masuk\nc. Tampikan nama mahasiswa\nd. Keluar (exit)\n\nPilih opsi : ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String opsi = br.readLine();
            if (opsi.equals("a")) {
                System.out.print("Masukkan nama Mahasiswa : ");
                String nama = br.readLine();
                System.out.print("Masukkan angkatan mahasiswa : ");
                int angkatan = Integer.parseInt(br.readLine());
                System.out.print("Masukkan asal Mahasiswa : ");
                String asal = br.readLine();
                absen.tambahMahasiswa(nama, angkatan, asal);
                System.out.println("\nMahasiswa berhasil ditambahkan!");
            } else if (opsi.equals("b")) 
                System.out.println("\nJumlah Mahasiswa yang masuk : " + absen.jumlahMahasiswaMasuk());
            else if (opsi.equals("c"))
                absen.tampikanNamaMahasiswa();
            else if (opsi.equals("d")) 
                break;
            else
                System.out.println("\nInput yang Anda masukkan tidak ada di dalam opsi!");
            br.readLine();
        }
    }
}

class Absen {
    private ArrayList<Mhs> mhs;

    Absen() {
        mhs = new ArrayList<>();
    }

    void tambahMahasiswa(String nama, int angkatan, String asal) {
        mhs.add(new Mhs(nama, angkatan, asal));
    }

    int jumlahMahasiswaMasuk() {
        return mhs.size();
    }

    void tampikanNamaMahasiswa() {
        System.out.println();
        for(int i = 0; i < mhs.size(); i++) 
            System.out.println((i+1) + ". " + mhs.get(i).getNama());
    }
}

class Mhs {
    private String nama;
    private int angkatan;
    private String asal;

    Mhs(String nama, int angkatan, String asal) {
        this.nama = nama;
        this.angkatan = angkatan;
        this.asal = asal;
    }

    public String getNama() {
        return nama;
    }

    public int getAngkatan() {
        return angkatan;
    }

    public String getAsal() {
        return asal;
    }

    public void cetak() {
        System.out.println("Nama : " + nama);
        System.out.println("Angkatan : " + angkatan);
        System.out.println("Asal : " + asal);
    }
}