import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class latStack {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Stack<String> data = new Stack<>();

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.print("<===== Menu Pilihan =====>\n1. Tambah Data\n2. Ambil Data\n3. Lihat Data Paling Atas\n4. Lihat Semua Isi Data STack\n5. Buat Stack Baru <Clear Data>\n6. Keluar Program\nInput Menu yang Anda pilih : ");
            int input = Integer.parseInt(br.readLine());
            switch(input) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    ambilData();
                    break;
                case 3:
                    lihatAtas();
                    break;
                case 4:
                    lihatSemua();
                    break;
                case 5:
                    clearStack();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Input yang Anda masukkan tidak ada di dalam Menu!");
                    break;
            }
            System.out.println();
        }
    }

    private static void tambahData() throws Exception {
        System.out.print("<=== Tambah Data ===>\nMasukkan Data : ");
        String input = br.readLine();
        data.push(input);
        tampilData(data);
    }

    private static void ambilData() throws Exception {
        System.out.println("<=== Ambil Data ===>");
        Stack<String> temp = new Stack<>();
        temp.push(data.pop());
        tampilData(temp);
    }
    
    private static void lihatAtas() throws Exception {
        System.out.println("<=== Lihat Data Paling Atas ===>");
        Stack<String> temp = new Stack<>();
        temp.push(data.peek());
        tampilData(temp);
    }

    private static void lihatSemua() throws Exception {
        System.out.println("<=== Lihat Semua Isi Data Stack ===>");
        tampilData(data);
    }

    private static void clearStack() throws Exception {
        System.out.println("<=== Buat Stack Baru <Clear Data> ===>");
        data = new Stack<String>();
    }

    private static void tampilData(Stack<String> data) {
        for (String st : data) {
            System.out.println(st);
        }
    }
}
