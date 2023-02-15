import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tugas2_Latihan4 {
    public static void main(String[] args) {
        
    }
}

class Report {
    public static String bacaInputan() {
        String baca = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            baca = br.readLine();
        } catch (IOException e) {
            System.out.println("Error!");
        }
        return baca;
    }

    public static void main(String[] args) {
        String name = "";
        int nilaiMatematika, nilaiFisika, nilaiKimia;
        System.out.println("Masukkan nama : ");
        name = bacaInputan();
        System.out.print("Masukkan nilai matematika : ");
        nilaiMatematika = Integer.parseInt(bacaInputan());
        System.out.print("Masukkan nilai Fisika : ");
        nilaiFisika = Integer.parseInt(bacaInputan());
        System.out.print("Masukkan nilai Kimia : ");
        nilaiKimia = Integer.parseInt(bacaInputan());

        System.out.println("\n-------------------------------------");
        System.out.println("" + name);
        System.out.println("Nilai kamu adalah ");
        System.out.println("Matematika : " + nilaiMatematika);
        System.out.println("Fisika : " + nilaiFisika);
        System.out.println("Kimia : " + nilaiKimia);
    }
}
