public class TesLatihan1 {
    public static void main(String[] args) {
        Tabungan2 Tabungan2 = new Tabungan2(5000);
        System.out.println("Saldo awal : " + Tabungan2.saldo);
        Tabungan2.ambilUang(2300);
        System.out.println("Jumlah uang yang diambil : 2300");
        System.out.println("Saldo sekarang : " + Tabungan2.saldo);
    }
}

class Tabungan2 {
    public int saldo;

    public Tabungan2(int initsaldo) {
        saldo = initsaldo;
    }

    public void ambilUang(int jumlah) {
        saldo -= jumlah;
    }
}
