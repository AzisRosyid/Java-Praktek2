public class Tugas4_1 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.tambahNasabah("Agus", "Daryanto");
        bank.getNasabah(0).setTabungan(new Tabungan(5000));
        bank.tambahNasabah("Tuti", "Irawan");
        bank.getNasabah(1).setTabungan(new Tabungan(7000));
        bank.tambahNasabah("Ani", "Ratna");
        bank.getNasabah(2).setTabungan(new Tabungan(4000));
        bank.tambahNasabah("Bambang", "Darwaman");
        bank.getNasabah(3).setTabungan(new Tabungan(6500));
        System.out.println("Jumlah nasabah = " + bank.getJumlahNasabah());
        for (int i = 0; i < bank.getJumlahNasabah(); i++) {
            System.out.println("Nasabah ke-" + (i + 1) + " : " + bank.getNasabah(i).getNamaAwal() + " "
                    + bank.getNasabah(i).getNamaAkhir() + " ; Saldo = " + bank.getNasabah(i).getTabungan().getSaldo());
        }
    }
}

class Bank {
    private Nasabah[] nasabah;
    private int jumlahNasabah;

    public Bank() {
        nasabah = new Nasabah[0];
    }

    public void tambahNasabah(String namaAwal, String namaAkhir) {
        Nasabah[] temp = new Nasabah[nasabah.length + 1];
        for (int i = 0; i < nasabah.length; i++)
            temp[i] = nasabah[i];
        temp[nasabah.length] = new Nasabah(namaAwal, namaAkhir);
        nasabah = temp;
        jumlahNasabah++;
    }

    public int getJumlahNasabah() {
        return jumlahNasabah;
    }

    public Nasabah getNasabah(int indeks) {
        return nasabah[indeks];
    }
}