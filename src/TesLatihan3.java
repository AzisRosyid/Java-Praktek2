public class TesLatihan3 {
    public static void main(String[] args) {
        Truk truk = new Truk(1000);
        System.out.println("Muatan maksimal : " + truk.getMuatanMaks());
        truk.tambahMuatan(500);
        System.out.println("Tambah muatan : 500");
        truk.tambahMuatan(350);
        System.out.println("Tambah muatan : 350");
        truk.tambahMuatan(100);
        System.out.println("Tambah muatan : 100");
        truk.tambahMuatan(150);
        System.out.println("Tambah muatan : 150");
        System.out.println("Muatan sekarang = " + truk.getMuatan());
    }
}
