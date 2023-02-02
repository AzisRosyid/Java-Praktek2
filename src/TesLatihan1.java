public class TesLatihan1 {
    public static void main(String[] args) {
        Tabungan tabungan = new Tabungan(5000);
        System.out.println("Saldo awal : " + tabungan.saldo);
        tabungan.ambilUang(2300);
        System.out.println("Jumlah uang yang diambil : 2300");
        System.out.println("Saldo sekarang : " + tabungan.saldo);
    }
}

class Tabungan {
    public int saldo;

    public Tabungan(int initsaldo) {
        saldo = initsaldo;
    }

    public void ambilUang(int jumlah) {
        saldo -= jumlah;
    }
}
