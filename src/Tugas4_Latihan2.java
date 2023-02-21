public class Tugas4_Latihan2 {
    public static void main(String[] args) {
        System.out.println("Masukkan identitas dosen 1 : Agus");
        Dosen dosen1 = new Dosen("Agus");
        System.out.println("Masukkan identitas dosen 2 : Budi, NIP. 1458");
        Dosen dosen2 = new Dosen("Budi", 1458);
        System.out.println("Masukkan identitas dosen 3 : Iwan, NIP. 1215, umur 47");
        Dosen dosen3 = new Dosen("Iwan", 1215, 47);
        System.out.println();
        dosen1.Info();
        System.out.println();
        dosen2.Info();
        System.out.println();
        dosen3.Info();
    }
}

class Orang {
    protected String nama;
    protected int umur;

    public Orang(String nama) {
        this.nama = nama;
    }

    public Orang(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }
}

class Dosen extends Orang {
    private int nip;

    public Dosen(String nama) {
        super(nama);
    }

    public Dosen(String nama, int nip) {
        super(nama);
        this.nip = nip;
    }

    public Dosen(String nama, int nip, int umur) {
        super(nama, umur);
        this.nip = nip;
    }

    public void Info() {
        System.out.printf("Nama : %s\nNIP : %s\nUmur : %s\n", this.nama, this.nip != 0 ? this.nip : "-", this.umur != 0 ? this.umur : "-");
    }
}
