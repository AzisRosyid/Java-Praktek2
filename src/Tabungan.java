public class Tabungan {
    public int saldo;

    public Tabungan(int initsaldo) {
        saldo = initsaldo;
    }

    public void ambilUang(int jumlah) {
        saldo -= jumlah;
    }
}
