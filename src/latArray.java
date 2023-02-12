import java.io.BufferedReader;
import java.io.InputStreamReader;

public class latArray {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;

    public static void main(String[] args) throws Exception {
        System.out.print("Masukkan jumlah data = ");
        int jml = Integer.parseInt(br.readLine());
        arr = new int[jml];
        for (int i = 0; i < jml; i++) {
            System.out.print("Data ke-" + (i + 1) + " = ");
            arr[i] = Integer.parseInt(br.readLine());
        }

        opsi: 
        while (true) {
            System.out.print(
                    "\n<===== Menu Program =====>\n1. Pencarian Data\n2. Penghapusan Data\n3. Penampilan Data\n4. Keluar Program\n\nPilih opsi : ");
            int opsi = Integer.parseInt(br.readLine());
            switch (opsi) {
                case 1:
                    pencarianData();
                    break;
                case 2:
                    penghapusanData();
                    break;
                case 3:
                    penampilanData();
                    break;
                case 4:
                    break opsi;
                default:
                    System.out.println("\nInput yang Anda masukkan tidak ada di dalam opsi!");
                    break;
            }
        }
    }

    private static void pencarianData() throws Exception {
        System.out.print("\n<=== Pencarian Data ===>\nCari Data : ");
        int cari = Integer.parseInt(br.readLine());
        for (int i = 0; i < arr.length; i++)
            if (cari == arr[i]) {
                System.out.println("-------------------------\nData " + cari + " ditemukan!");
                return;
            }
        System.out.println("Data " + cari + " tidak ditemukan!");
    }

    private static void penghapusanData() throws Exception {
        System.out.print("\n<=== Penghapusan Data ===>\nHapus Data : ");
        int hapus = Integer.parseInt(br.readLine());
        for (int i = 0; i < arr.length; i++)
            if (hapus == arr[i]) {
                int[] temp = new int[arr.length-1];
                for (int j = 0; j < arr.length; j++)
                    if (j == i) continue;
                    else if (j < i) 
                        temp[j] = arr[j];
                    else 
                        temp[j-1] = arr[j];
                arr = temp;
                System.out.println("-------------------------\nData " + hapus + " ditemukan dan dihapus!");
                return;
            }
        System.out.println("-------------------------\nData " + hapus + " tidak ditemukan!");
    }

    private static void penampilanData() {
        System.out.println("\n<=== Penampilan Data ===>");
        for (int i = 0; i < arr.length; i++)
            System.out.println("Data ke-" + (i + 1) + " = " + arr[i]);
    }
}
