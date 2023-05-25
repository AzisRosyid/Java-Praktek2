import java.io.BufferedReader;
import java.io.InputStreamReader;
<<<<<<< HEAD

public class latQueue {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Queue data = new latQueue().new Queue();
=======
import java.util.ArrayDeque;
import java.util.Queue;

public class latQueue {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Queue<String> data = new ArrayDeque<>();
>>>>>>> 4cff99e96e410aa64617b11d31daa082416ff0b1
    private static int spc;

    public static void main(String[] args) throws Exception {
        while (true) {
<<<<<<< HEAD
            System.out.print("<===== Menu Pilihan =====>\n1. Tambah Data Queue\n2. Ambil Data Queue\n3. Lihat Data Queue\n4. Buat Queue Baru\n5. Keluar \nInput Menu yang Anda pilih : ");
=======
            System.out.print("<===== Menu Pilihan =====>\n1. Tambah Data Queue\n2. Ambil Data Queue\n3. Lihat Data Queue\n4. Buat Queue Baru\n5. Keluar Program\nInput Menu yang Anda pilih : ");
>>>>>>> 4cff99e96e410aa64617b11d31daa082416ff0b1
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
<<<<<<< HEAD
=======
                    System.out.println("TERIMA KASIH!");
>>>>>>> 4cff99e96e410aa64617b11d31daa082416ff0b1
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
<<<<<<< HEAD
        Long input = Long.parseLong(br.readLine());
        data.enQueue(input);
=======
        String input = br.readLine();
        data.add(input);
>>>>>>> 4cff99e96e410aa64617b11d31daa082416ff0b1
        tampilData(data);
    }

    private static void ambilData() throws Exception {
        System.out.println("\n<=== Ambil Data ===>");
<<<<<<< HEAD
        System.out.println("Ambil Data => " + data.deQueue());
=======
        System.out.println("Ambil Data => " + data.poll());
>>>>>>> 4cff99e96e410aa64617b11d31daa082416ff0b1
        tampilData(data);
    }

    private static void lihatData() throws Exception {
        System.out.println("\n<=== Lihat Semua Isi Data Queue ===>");
        tampilData(data);
    }

    private static void clearQueue() throws Exception {
        System.out.println("\n<=== Buat Queue Baru <Clear Data> ===>");
<<<<<<< HEAD
        data = new latQueue().new Queue();
=======
        data = new ArrayDeque<>();
>>>>>>> 4cff99e96e410aa64617b11d31daa082416ff0b1
    }

    private static void setSpc() {
        spc = 2;
<<<<<<< HEAD
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
=======
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
>>>>>>> 4cff99e96e410aa64617b11d31daa082416ff0b1
                index++;
            }
            System.out.println("\n"+"-".repeat(spc + 3));
        } else 
<<<<<<< HEAD
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
=======
            System.out.println("\nSTACK KOSONG!");
>>>>>>> 4cff99e96e410aa64617b11d31daa082416ff0b1
    }
}
