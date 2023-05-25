import java.io.BufferedReader;
import java.io.InputStreamReader;

public class latLinkQueue {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static LinkQueue data = new latLinkQueue().new LinkQueue();

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.print("<===== Pilih Menu =====>\n1. Tambah Data Queue\n2. Ambil Data Queue\n3. Lihat Data Queue\n4. Buat Queue Baru\n5. Keluar \nInput Menu yang Anda pilih : ");
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
                    clearStack();
                    break;
                case 5:
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
        data.insert(input);
        tampilData(data);
    }

    private static void ambilData() throws Exception {
        System.out.println("\n<=== Ambil Data ===>");
        System.out.println("Ambil Data => " + data.remove());
        tampilData(data);
    }

    private static void lihatData() throws Exception {
        System.out.println("\n<=== Lihat Semua Isi Data Stack ===>");
        tampilData(data);
    }

    private static void clearStack() throws Exception {
        System.out.println("\n<=== Buat Queue Baru <Clear Data> ===>");
        data = new latLinkQueue().new LinkQueue();
    }

    private static void tampilData(LinkQueue data) {
        if (!data.isEmpty()) {
            data.displayQueue();
        } else 
            System.out.println("\nQueue Kosong!");
    }

    public class LinkQueue {
        private LinkList theList;

        public LinkQueue() 
        {
            theList = new LinkList();
        }

        public void insert(double j)
        {
            theList.insertLast(j);
        }

        public double remove() 
        {
            return theList.deleteFirst();
        }

        public boolean isEmpty() 
        {
            return theList.isEmpty();
        }

        public void displayQueue() {
            System.out.println("Tumpukan datanya adalah: ");
            theList.displayList();
        }
    }

    public class LinkList {
        private Link first;
        private Link last;

        public LinkList() 
        {
            first = null;
            last = null;
        } 

        public boolean isEmpty() {
            return (first == null);
        }

        public void insertLast(double dd) {
            Link newLink = new Link(dd); 
            if (isEmpty()) {
                first = newLink; 
            } else {
                last.next = newLink;
            }
            last = newLink;
        }

        public double deleteFirst() { 
            double temp = first.dData;
            if (first.next == null) {
                last = null;
            }
            first = first.next; 
            return temp;
        }

        public void displayList() {
            Link current = first;
            int spc = 2;
            while (current != null) {
                if (String.valueOf(current.dData).length() + 1 > spc)
                    spc = String.valueOf(current.dData).length() + 1;
                current = current.next;
            }
            current = first;
            while (current != null) {
                System.out.printf("\n| %" + -spc + "s|", current.dData);
                if (current == first)
                    System.out.print(" ==> Front");
                if (current == last)
                    System.out.print(" ==> Rear");
                current = current.next; 
            }
            System.out.println();
            for (int i = 0; i < spc + 3; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public class Link {
        public double dData;
        public Link next; 

        public Link(double dd) 
        {
            dData = dd;
        }
    } 
}
