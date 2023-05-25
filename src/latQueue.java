import java.io.BufferedReader;
import java.io.InputStreamReader;

public class latQueue {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Queue data = new latQueue().new Queue();
    private static int spc;

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.print("<===== Menu Pilihan =====>\n1. Tambah Data Queue\n2. Ambil Data Queue\n3. Lihat Data Queue\n4. Buat Queue Baru\n5. Keluar \nInput Menu yang Anda pilih : ");
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
        Long input = Long.parseLong(br.readLine());
        data.enQueue(input);
        tampilData(data);
    }

    private static void ambilData() throws Exception {
        System.out.println("\n<=== Ambil Data ===>");
        System.out.println("Ambil Data => " + data.deQueue());
        tampilData(data);
    }

    private static void lihatData() throws Exception {
        System.out.println("\n<=== Lihat Semua Isi Data Queue ===>");
        tampilData(data);
    }

    private static void clearQueue() throws Exception {
        System.out.println("\n<=== Buat Queue Baru <Clear Data> ===>");
        data = new latQueue().new Queue();
    }

    private static void setSpc() {
        spc = 2;
        for (int i = 0; i < data.getLength(); i++) 
           if (String.valueOf(data.get(i)).length() + 1 > spc)
                spc = String.valueOf(data.get(i)).length() + 1;
    } 

    private static void tampilData(Queue data) {
        if (!data.isEmpty()) {
            setSpc();
            int index = 0;
            for (int i = 0; i < data.getLength(); i++) {
                System.out.printf("\n| %" + -spc + "s|", data.get(i));
                if (index == 0)
                    System.out.print(" ==> Data pertama");
                index++;
            }
            System.out.println();
            for (int i = 0; i < spc + 3; i++) {
                System.out.print("-");
            }
            System.out.println();
        } else 
            System.out.println("\nQueue Kosong!");
    }

    public class Queue {
        private Long[] queue;

        public Queue() {
            clear();
        }

        public boolean isFull() {
            for (Long st: queue) 
                if (st == null)
                    return false;
            return true;
        }

        public boolean isEmpty() {
            for (Long st: queue) 
                if (st != null)
                    return false;
            return true;
        }

        public void enQueue(Long e) {
            Long[] temp = new Long[queue.length + 1];
            for (int i = 0; i < queue.length; i++) 
                temp[i] = queue[i];
            temp[queue.length] = e;
            queue = temp;
        }

        public long deQueue() {
            Long value = queue[0];
            Long[] temp = new Long[queue.length - 1];
            for (int i = 1; i < queue.length; i++) 
                temp[i-1] = queue[i];
            queue = temp;
            return value;
        }

        public long peek() {
            return queue[0];
        }

        public void clear() {
            queue = new Long[0];
        }

        public int getLength() {
            return queue.length;
        }

        public Long get(int index) {
            return queue[index];
        }
    }
}
