import java.io.BufferedReader;
import java.io.InputStreamReader;

public class latLinkStack {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static LinkStack data = new latLinkStack().new LinkStack();

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.print("<===== Pilih Menu =====>\n1. Tambah Data Stack\n2. Ambil Data Stack\n3. Lihat Data Stack\n4. Buat Stack Baru\n5. Keluar \nInput Menu yang Anda pilih : ");
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
        data.push(input);
        tampilData(data);
    }

    private static void ambilData() throws Exception {
        System.out.println("\n<=== Ambil Data ===>");
        System.out.println("Ambil Data => " + data.pop());
        tampilData(data);
    }

    private static void lihatData() throws Exception {
        System.out.println("\n<=== Lihat Semua Isi Data Stack ===>");
        tampilData(data);
    }

    private static void clearStack() throws Exception {
        System.out.println("\n<=== Buat Stack Baru <Clear Data> ===>");
        data = new latLinkStack().new LinkStack();
    }

    private static void tampilData(LinkStack data) {
        if (!data.isEmpty()) {
            data.displayStack();
        } else 
            System.out.println("\nStack Kosong!");
    }

    public class LinkStack {
        private LinkList theList;

        public LinkStack() 
        {
            theList = new LinkList();
        }

        public void push(double j)
        {
            theList.insertFirst(j);
        }

        public double pop() 
        {
            return theList.deleteFirst();
        }

        public boolean isEmpty() 
        {
            return (theList.isEmpty());
        }

        public void displayStack() {
            System.out.println("Tumpukan datanya adalah: ");
            theList.displayList();
        }
    }

    public class LinkList {
        private Link first;

        public LinkList() 
        {
            first = null;
        } 

        public boolean isEmpty() {
            return (first == null);
        }

        public void insertFirst(double dd) {
            Link newLink = new Link(dd); 
            newLink.next = first; 
            first = newLink; 
        }

        public double deleteFirst() { 
            Link temp = first; 
            first = first.next;
            return temp.dData; 
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
                    System.out.print(" ==> Data pertama");
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
