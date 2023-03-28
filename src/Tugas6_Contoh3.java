import javax.swing.*;

// Button
public class Tugas6_Contoh3 extends JFrame {
    JButton abort = new JButton("Abort");
    JButton retry = new JButton("Retry");
    JButton fail = new JButton("Fail");

    public Tugas6_Contoh3() {
        super("Tugas6_Contoh3");
        setSize(80, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.add(abort);
        pane.add(retry);
        pane.add(fail);
        setLocationRelativeTo(null);
        setContentPane(pane);
    }

    public static void main(String[] args) {
        Tugas6_Contoh3 rb = new Tugas6_Contoh3();
        rb.show();
    }
}