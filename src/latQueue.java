import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class latQueue {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Queue<String> data = new ArrayDeque<>();
    private static int spc;

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.print("<===== Menu Pilihan =====>\n1. Tambah Data Queue\n2. Ambil Data Queue\n3. Lihat Data Queue\n4. Buat Queue Baru\n5. Keluar Program\nInput Menu yang Anda pilih : ");
            int input = 0;
            try {
                input = Integer.parseInt(br.readLine());
            } catch (Exception e) {}
            switch(input) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    ambilData();
                    break;
                case 3:
                    lihatData();
                    break;
                case 4:
                    clearQueue();
                    break;
                case 6:
                    System.out.println("TERIMA KASIH!");
                    return;
                default:
                    System.out.println("Input yang Anda masukkan tidak ada di dalam Menu!");
                    break;
            }
            System.out.println();
        }
    }

    private static void tambahData() throws Exception {
        System.out.print("\n<=== Tambah Data ===>\nMasukkan Data : ");
        String input = br.readLine();
        data.add(input);
        tampilData(data);
    }

    private static void ambilData() throws Exception {
        System.out.println("\n<=== Ambil Data ===>");
        System.out.println("Ambil Data => " + data.poll());
        tampilData(data);
    }

    private static void lihatData() throws Exception {
        System.out.println("\n<=== Lihat Semua Isi Data Queue ===>");
        tampilData(data);
    }

    private static void clearQueue() throws Exception {
        System.out.println("\n<=== Buat Queue Baru <Clear Data> ===>");
        data = new ArrayDeque<>();
    }

    private static void setSpc() {
        spc = 2;
        for (String st : data) 
           if (st.length() + 1 > spc)
                spc = st.length() + 1;
    } 

    private static void tampilData(Queue<String> data) {
        if (!data.isEmpty()) {
            setSpc();
            // for (int i = data.size()-1 ; i >= 0; i--) {
            //     System.out.printf("\n| %" + -spc + "s|", data.);
            //     if (i == data.size()-1)
            //         System.out.print(" ==> Data paling atas");
            // }

            int index = 0;
            for (String st : data) {
                System.out.printf("\n| %" + -spc + "s|", st);
                if (index == 0)
                    System.out.print(" ==> Data paling atas");
                index++;
            }
            System.out.println("\n"+"-".repeat(spc + 3));
        } else 
            System.out.println("\nSTACK KOSONG!");
    }
}
