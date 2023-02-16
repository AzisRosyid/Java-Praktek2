public class Tugas3_Tugas {
    public static void main(String[] args) {
        Penjualan bolpoint = new Penjualan("bolpoint", 150, 4000);
        Penjualan pensil = new Penjualan("pensil", 100, 2000);
        Penjualan penghapus = new Penjualan("penghapus", 50, 1000);
        System.out.println(Penjualan.getTotalHarga());
    }
}

class Penjualan {
    private String nama;
    private int stok;
    private double hargaSatuan, harga;
    private static double totalHarga;

    public Penjualan(String nama, int stok, double hargaSatuan) {
        this.nama = nama;
        this.stok = stok;
        this.hargaSatuan = hargaSatuan;
        setHarga();
    }

    public void setNama(String nama) {
        this.nama = nama;
        setHarga();
    }

    public void setStok(int stok) {
        Penjualan.setTotalHarga(Penjualan.totalHarga - getHarga());
        this.stok = stok;
        setHarga();
    }

    public void setHargaSatuan(double hargaSatuan) {
        Penjualan.setTotalHarga(Penjualan.totalHarga - getHarga());
        this.hargaSatuan = hargaSatuan;
        setHarga();
    }

    private void setHarga() {
        this.harga = this.stok * this.hargaSatuan;
        Penjualan.setTotalHarga(Penjualan.totalHarga + this.harga);
    }

    private static void setTotalHarga(double totalHarga) {
        Penjualan.totalHarga = totalHarga;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public double getHargaSatuan() {
        return hargaSatuan;
    }

    public double getHarga() {
        return harga;
    }

    public static double getTotalHarga() {
        return totalHarga;
    }
}