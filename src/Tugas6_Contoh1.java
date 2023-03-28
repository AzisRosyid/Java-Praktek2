import javax.swing.JFrame;

// Simple Frame
public class Tugas6_Contoh1 extends JFrame {
    public Tugas6_Contoh1() {
        super("Frame title");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Tugas6_Contoh1 sf = new Tugas6_Contoh1();
    }
}