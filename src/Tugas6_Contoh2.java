import javax.swing.JWindow;

// Simple Window
public class Tugas6_Contoh2 extends JWindow {
    public Tugas6_Contoh2() {
        super();
        setBounds(250, 225, 300, 150);
    }

    public static void main(String[] args) {
        Tugas6_Contoh2 sw = new Tugas6_Contoh2();
        sw.setVisible(true);
        for (int i = 0; i < 100000; i++)
            System.out.print(i + " ");
        sw.setVisible(false);
        System.exit(0);
    }
}