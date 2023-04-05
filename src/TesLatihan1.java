public class TesLatihan1 {
    public static void main(String[] args) {
        Tabungan Tabungan = new TesLatihan1().new Tabungan(5000);
        System.out.println("Saldo awal : " + Tabungan.saldo);
        Tabungan.ambilUang(2300);
        System.out.println("Jumlah uang yang diambil : 2300");
        System.out.println("Saldo sekarang : " + Tabungan.saldo);
    }

    public class Tabungan {
        public int saldo;
    
        public Tabungan(int initsaldo) {
            saldo = initsaldo;
        }
    
        public void ambilUang(int jumlah) {
            saldo -= jumlah;
        }
    }
}