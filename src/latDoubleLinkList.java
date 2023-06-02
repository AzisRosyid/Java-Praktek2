import java.io.BufferedReader;
import java.io.InputStreamReader;

public class latDoubleLinkList {
    private static BufferedReader br;
    private static DoubleLink data = new latDoubleLinkList().new DoubleLink();

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.print("<===== Pilih Menu =====>\n1. Tambah Data\n2. Menghapus Data\n3. Mengupdate Data\n4. Menampilkan Data\n5. Keluar \nInput Menu yang Anda pilih : ");
            br = new BufferedReader(new InputStreamReader(System.in));
            int input = 0;
            try {
                input = Integer.parseInt(br.readLine());
            } catch (Exception e) {}
            switch(input) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    hapusData();
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    lihatData();
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
        System.out.print("\n<=== Tambah Data ===>\nMasukkan Nama : ");
        String nama = br.readLine();
        System.out.print("Masukkan NIM : ");
        String nim = br.readLine();
        System.out.print("Masukkan Jenis Kelamin (L/W) : ");
        Character jenisKelamin = null;
        try {
            jenisKelamin = (char) br.read();
            if (jenisKelamin != 'L' && jenisKelamin != 'W') {
                System.out.println("Input Jenis Kelamin harus (L/W)");
                return;
            }
        } catch (Exception e) {}
        data.insert(nama, nim, jenisKelamin);
        tampilData(data);
    }

    private static void updateData() throws Exception {
        System.out.println("\n<=== Update Data ===>");
        System.out.print("Masukkan NIM : ");
        String nim = br.readLine();
        if (data.validNIM(nim)) {
            System.out.println("NIM not found!");
            return;
        }
        Link menu = data.findNIM(nim);
        System.out.printf("Menu Update : \n1. %-21s-> %s\n2. %-21s-> %s\n3. %-21s-> %s\nPilih menu : ", "Update Nama", menu.nama, "Update NIM", menu.nim, "Update Jenis Kelamin", menu.jenisKelamin);
        int input = 0;
        try {
            input = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            return;
        }
        switch(input) {
            case 1:
                System.out.print("Nama Baru : ");
                String newNama = br.readLine();
                data.updateName(nim, newNama);
                break;
            case 2:
                System.out.print("NIM Baru : ");
                String newNIM = br.readLine();
                data.updateNIM(nim, newNIM);
                break;
            case 3:
                System.out.print("Jenis Kelamin Baru (L/W) : ");
                Character newJenisKelamin = null;
                try {
                    newJenisKelamin = (char) br.read();
                    if (newJenisKelamin != 'L' && newJenisKelamin != 'W') {
                        System.out.println("Input Jenis Kelamin harus (L/W)");
                        return;
                    }
                } catch (Exception e) {
                }
                data.updateJenisKelamin(nim, newJenisKelamin);
                break;
        }
        System.out.println("\n<= Data setelah diupdate => ");
        tampilData(data);
    }

    private static void hapusData() throws Exception {
        System.out.println("\n<=== Hapus Data ===>");
        System.out.print("Masukkan NIM : ");
        String nim = br.readLine();
        if (data.validNIM(nim)) {
            System.out.println("NIM not found!");
            return;
        }
        Link hapus = data.hapus(nim);
        DoubleLink temp = new latDoubleLinkList().new DoubleLink();
        temp.insertFirst(hapus.nama, hapus.nim, hapus.jenisKelamin);
        temp.tampilMaju();
        System.out.println("<= Data setelah dihapus => ");
        tampilData(data);
    }

    private static void lihatData() throws Exception {
        System.out.println("\n<=== Lihat Semua Isi Data Double Linked List ===>");
        tampilData(data);
    }

    private static void tampilData(DoubleLink data) {
        if (!data.isEmpty()) {
            data.tampilMaju();
        } else 
            System.out.println("\nDouble Linked List kosong!");
    }

    public class DoubleLink {
        private Link first;
        private Link last;

        public DoubleLink() 
        {
            first = null;
            last = null;
        } 

        public boolean isEmpty() {
            return (first == null);
        }

        public void insert(String nama, String nim, char jenisKelamin) {
            sortByNIM();
            if (!validNIM(nim)) {
                return;
            }
            Link newLink = new Link(nama, nim, jenisKelamin);

            if (isEmpty()) {
                first = newLink;
                last = newLink;
            } else {
                newLink.next = first;
                first.previous = newLink;
                first = newLink;

                if (first.next != null) {
                    sortByNIM();
                }
            }
        }

        public void insertFirst(String nama, String nim, char jenisKelamin) {
            sortByNIM();
            if (!validNIM(nim)) {
                return;
            }
            Link newLink = new Link(nama, nim, jenisKelamin); 
            if (isEmpty()) {
                last = newLink;
            } else {
                first.previous = newLink;
            }
            newLink.next = first;
            first = newLink;
            
        }

        public void insertLast(String nama, String nim, char jenisKelamin) {
            sortByNIM();
            if (!validNIM(nim)) {
                return;
            }
            Link newLink = new Link(nama, nim, jenisKelamin); 
            if (isEmpty()) {
                first = newLink;
            } else {
                last.next = newLink;
                newLink.previous = last;
            }
            last = newLink;
        }

        public Link deleteFirst() { 
            Link temp = first;
            if (first.next == null) {
                last = null;
            } else {
                first.next.previous = null;
            }
            first = first.next; 
            return temp;
        }

        public Link deleteLast() { 
            Link temp = last;
            if (first.next == null) {
                first = null;
            } else {
                last.previous.next = null;
            }
            last = last.previous;
            return temp;
        }

        public boolean insertAfter(String indexNIM, String nama, String nim, char jenisKelamin) {
            sortByNIM();
            Link indek = first;
            if (!validNIM(nim)) {
                return false;
            }
            while (!indek.nim.equals(indexNIM)) {
                indek = indek.next;
                if(indek == null)
                    return false; 
            }
            Link newLink = new Link(nama, nim, jenisKelamin);
            if(indek == last) {
                last = newLink;
            }
            else {
                newLink.next = indek.next;
                indek.next.previous = newLink;
            }
            newLink.previous = indek;
            indek.next = newLink;
            return true; 
        }

        public boolean updateName(String indexNIM, String nama) {
            if (!validNIM(indexNIM)) {
                return false;
            }
            Link current = first;
            while (current != null) {
                if (current.nim.equals(indexNIM)) {
                    current.nama = nama;
                    return true;
                }
                current = current.next;
            }
            return false; 
        }

        public boolean updateNIM(String indexNIM, String nim) {
            if (!validNIM(indexNIM)) {
                return false;
            }
            Link current = first;
            while (current != null) {
                if (current.nim.equals(indexNIM)) {
                    current.nim = nim;
                    return true;
                }
                current = current.next;
            }
            return false; 
        }

        public boolean updateJenisKelamin(String indexNIM, char jenisKelamin) {
            if (!validNIM(indexNIM)) {
                return false;
            }
            Link current = first;
            while (current != null) {
                if (current.nim.equals(indexNIM)) {
                    current.jenisKelamin = jenisKelamin;
                    return true;
                }
                current = current.next;
            }
            return false; 
        }

        public Link hapus(String indexNIM) {
            Link indek = first;
            while(!indek.nim.equals(indexNIM)) {
                indek = indek.next;
                if(indek == null)
                    return null;
            }
            if(indek == first)
                first = indek.next;
            else
                indek.previous.next = indek.next;
            
            if(indek == last)
                last = indek.previous;
            else
                indek.next.previous = indek.previous;
            return indek;
        }

        public void tampilMaju() {
            sortByNIM();
            Link current = first;
            int spc;
            int spcNama = 5, spcNIM = 4, spcKelamin = 14;
            while (current != null) {
                if (current.nama.length() + 1 > spcNama)
                    spcNama = String.valueOf(current.nama).length() + 1;
                if (current.nim.length() + 1 > spcNIM)
                    spcNIM = String.valueOf(current.nim).length() + 1;
                current = current.next;
            }
            spc = spcNama + spcNIM + spcKelamin + 7;
            System.out.println("\n" + "-".repeat(spc));
            System.out.printf("| %" + -spcNama + "s| %" + -spcNIM + "s| %" + -spcKelamin + "s|", "Nama", "NIM", "Jenis Kelamin");
            System.out.printf("\n" + "-".repeat(spc));

            current = first;
            while (current != null) {
                System.out.printf("\n| %" + -spcNama + "s| %" + -spcNIM + "s| %" + -spcKelamin + "s|", current.nama, current.nim, current.jenisKelamin);
                current = current.next; 
            }
            System.out.print("\n" + "-".repeat(spc) + "\n\n");
        }

        public void tampilMundur() {
            sortByNIM();
            Link current = last;
            int spc;
            int spcNama = 5, spcNIM = 4, spcKelamin = 14;
            while (current != null) {
                if (current.nama.length() + 1 > spcNama)
                    spcNama = String.valueOf(current.nama).length() + 1;
                if (current.nim.length() + 1 > spcNIM)
                    spcNIM = String.valueOf(current.nim).length() + 1;
                current = current.previous;
            }
            spc = spcNama + spcNIM + spcKelamin + 7;
            System.out.println("\n" + "-".repeat(spc));
            System.out.printf("| %" + -spcNama + "s| %" + -spcNIM + "s| %" + -spcKelamin + "s|", "Nama", "NIM", "Jenis Kelamin");
            System.out.printf("\n" + "-".repeat(spc));

            current = last;
            while (current != null) {
                System.out.printf("\n| %" + -spcNama + "s| %" + -spcNIM + "s| %" + -spcKelamin + "s|", current.nama, current.nim, current.jenisKelamin);
                if (current == first)
                    System.out.print(" ==> First");
                if (current == last)
                    System.out.print(" ==> Last");
                current = current.previous; 
            }
            System.out.print("\n" + "-".repeat(spc) + "\n\n");
        }

        public boolean validNIM(String indexNIM) {
            Link indek = first;
            while(indek != null) {
                if(indek.nim.equals(indexNIM))
                    return false; 
                indek = indek.next;
            }
            return true;
        }

        public Link findNIM(String indexNIM) {
            Link indek = first;
            while (indek != null) {
                if (indek.nim.equals(indexNIM))
                    return indek; 
                indek = indek.next;
            }
            return null;
        }

        public void sortByNIM() {
            if (isEmpty() || first.next == null) {
                return; 
            }
        
            first = mergeSort(first);
            Link current = first;
            while (current.next != null) {
                current.next.previous = current;
                current = current.next;
            }
            last = current;

            groupByJenisKelamin();
        }

        private Link mergeSort(Link head) {
            if (head == null || head.next == null) {
                return head; 
            }

            Link middle = getMiddle(head);
            Link nextOfMiddle = middle.next;
            middle.next = null;

            Link left = mergeSort(head);
            Link right = mergeSort(nextOfMiddle);

            return merge(left, right);
        }
        
        private Link merge(Link left, Link right) {
            Link sorted = null;

            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }

            if (left.nim.length() < right.nim.length()
                    || (left.nim.length() == right.nim.length() && left.nim.compareTo(right.nim) <= 0)) {
                sorted = left;
                sorted.next = merge(left.next, right);
            } else {
                sorted = right;
                sorted.next = merge(left, right.next);
            }

            return sorted;
        }

        private Link getMiddle(Link head) {
            if (head == null) {
                return head;
            }
        
            Link slow = head;
            Link fast = head;
        
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
        
            return slow;
        }

        private void groupByJenisKelamin() {
            if (first == null || first.next == null) {
                return; 
            }

            Link middle = getMiddle(first);
            Link nextOfMiddle = middle.next;
            middle.next = null;

            groupByJenisKelamin();
            groupByJenisKelaminHelper(first, nextOfMiddle);
        }
        
        private void groupByJenisKelaminHelper(Link left, Link right) {
            Link sorted = null;

            if (left == null) {
                first = right;
                return;
            }
            if (right == null) {
                first = left;
                return;
            }

            if (left.jenisKelamin <= right.jenisKelamin) {
                sorted = left;
                sorted.next = mergeByJenisKelamin(left.next, right);
            } else {
                sorted = right;
                sorted.next = mergeByJenisKelamin(left, right.next);
            }
        
            first = sorted;
        }
        
        private Link mergeByJenisKelamin(Link left, Link right) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
        
            if (left.jenisKelamin <= right.jenisKelamin) {
                left.next = mergeByJenisKelamin(left.next, right);
                left.next.previous = left;
                left.previous = null;
                return left;
            } else {
                right.next = mergeByJenisKelamin(left, right.next);
                right.next.previous = right;
                right.previous = null;
                return right;
            }
        }
    }

    public class Link {
        public String nama, nim;
	    public char jenisKelamin;
	    public Link next;		
	    public Link previous;	

	    public Link(String nama, String nim, char jenisKelamin) {
		    this.nama = nama;
            this.nim = nim;
            this.jenisKelamin = jenisKelamin;
	    }
    }

    public class Mahasiswa {
        private String nama, nim;
        private char jenisKelamin;

        public Mahasiswa(String nama, String nim, char jenisKelamin) {
            this.nama = nama;
            this.nim = nim;
            this.jenisKelamin = jenisKelamin;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getNama() {
            return nama;
        }

        public void setNIM(String nim) {
            this.nim = nim;
        }

        public String getNIM() {
            return nim;
        }

        public void setJenisKelamin(char jenisKelamin) {
            this.jenisKelamin = jenisKelamin;
        }

        public char getJenisKelamin() {
            return jenisKelamin;
        }
    }
}
