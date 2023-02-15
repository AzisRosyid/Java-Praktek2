import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tugas2_3 {
    public static void main(String[] args) throws Exception {
        System.out.print("Input bilangan : ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int bil = Integer.parseInt(input.readLine());
        System.out.println("\nSegitiga sama sisi, sisi = " + bil);
        for (int i = 0; i < bil; i++) 
            System.out.println(" ".repeat(i) + "* ".repeat(bil-i));
        System.out.println("\nSegitiga siku-siku dengan alas = " + bil + ", tinggi = " + bil);
        for (int i = 0; i < bil; i++)
            System.out.println("*  ".repeat(i+1));
    }
}