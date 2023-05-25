public class Tugas4_Latihan1 {
    public static void main(String[] args) {
        // int tmp;
        // boolean status;
        // Nasabah nasabah = new Nasabah("Agus", "Daryanto");
        // System.out.println("Nasabah atas nama : " + nasabah.getNamaAwal() + " " + nasabah.getNamaAkhir());
        // nasabah.setTabungan(new Tabungan(5000));
        // tmp = nasabah.getTabungan().getSaldo();
        // System.out.println("Saldo awal : " + tmp);
        // nasabah.getTabungan().simpanUang(3000);
        // System.out.println("Jumlah uang yang disimpan : 3000");
        // status = nasabah.getTabungan().ambilUang(6000);
        // System.out.print("Jumlah uang yang diambil : 6000");
        // if (status)
        //     System.out.println(" ok");
        // else
        //     System.out.println(" gagal");
        // nasabah.getTabungan().simpanUang(3500);
        // System.out.println("Jumlah uang yang disimpan : 3500");
        // status = nasabah.getTabungan().ambilUang(4000);
        // System.out.print("Jumlah uang yang diambil : 4000");
        // if (status)
        //     System.out.println(" ok");
        // else
        //     System.out.println(" gagal");
        // status = nasabah.getTabungan().ambilUang(1600);
        // System.out.print("Jumlah uang yang diambil : 1600");
        // if (status)
        //     System.out.println(" ok");
        // else
        //     System.out.println(" gagal");
        // nasabah.getTabungan().simpanUang(2000);
        // System.out.println("Jumlah uang yang disimpan : 2000");
        // tmp = nasabah.getTabungan().getSaldo();
        // System.out.println("Saldo sekarang = " + tmp);
        // System.out.println("\n\n");
        PenyimpananUang tabungan = new PenyimpananUang(5000, 8.5 / 100);
        System.out.println("Uang yang ditabung : 5000");
        System.out.println("Tingkat bunga sekarang : 8.5%");
        System.out.println("Total uang anda sekarang : " + tabungan.cekUang());
    }
}

class Nasabah {
    private String namaAwal, namaAkhir;
    private Tabungan tabungan;

    public Nasabah(String namaAwal, String namaAkhir) {
        this.namaAwal = namaAwal;
        this.namaAkhir = namaAkhir;
    }

    public String getNamaAwal() {
        return namaAwal;
    }

    public String getNamaAkhir() {
        return namaAkhir;
    }

    public Tabungan getTabungan() {
        return tabungan;
    }

    public void setTabungan(Tabungan tabungan) {
        this.tabungan = tabungan;
    }
}

class Tabungan {
    private int saldo;

    public Tabungan(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void simpanUang(int jumlah) {
        saldo += jumlah;
    }

    public boolean ambilUang(int jumlah) {
        if (saldo < jumlah)
            return false;
        saldo -= jumlah;
        return true;
    }
}

class PenyimpananUang extends Tabungan {
    private double tingkatBunga;

    public PenyimpananUang(int saldo, double tingkatBunga) {
        super(saldo);
        this.tingkatBunga = tingkatBunga;
    }

    public double cekUang() {
        return this.getSaldo() + this.getSaldo() * tingkatBunga;
    }
}