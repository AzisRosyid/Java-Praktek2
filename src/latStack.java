import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class latStack {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Stack<String> data = new Stack<>();
    private static int spc;

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.print("<===== Menu Pilihan =====>\n1. Tambah Data\n2. Ambil Data\n3. Lihat Data Paling Atas\n4. Lihat Semua Isi Data Stack\n5. Buat Stack Baru <Clear Data>\n6. Keluar Program\nInput Menu yang Anda pilih : ");
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
                    lihatAtas();
                    break;
                case 4:
                    lihatSemua();
                    break;
                case 5:
                    clearStack();
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
        data.push(input);
        tampilData(data);
    }

    private static void ambilData() throws Exception {
        System.out.println("\n<=== Ambil Data ===>");
        System.out.println("Ambil Data => " + data.pop());
        tampilData(data);
    }
    
    private static void lihatAtas() throws Exception {
        System.out.println("\n<=== Lihat Data Paling Atas ===>");
        Stack<String> temp = new Stack<>();
        if (data.isEmpty()) {
            tampilData(data);
            return;
        }
        temp.push(data.peek());
        tampilData(temp);
    }

    private static void lihatSemua() throws Exception {
        System.out.println("\n<=== Lihat Semua Isi Data Stack ===>");
        tampilData(data);
    }

    private static void clearStack() throws Exception {
        System.out.println("\n<=== Buat Stack Baru <Clear Data> ===>");
        data = new Stack<String>();
    }

    private static void setSpc() {
        spc = 2;
        for (String st : data) 
           if (st.length() + 1 > spc)
                spc = st.length() + 1;
    } 

    private static void tampilData(Stack<String> data) {
        if (!data.isEmpty()) {
            setSpc();
            for (int i = data.size()-1 ; i >= 0; i--) {
                System.out.printf("\n| %" + -spc + "s|", data.get(i));
                if (i == data.size()-1)
                    System.out.print(" ==> Data paling atas");
            }
            System.out.println();
            for (int i = 0; i < spc + 3; i++) {
                System.out.print("-");
            }
            System.out.println();
        } else 
            System.out.println("\nSTACK KOSONG!");
    }
} 
