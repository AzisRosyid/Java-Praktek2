import javax.swing.*;

// Icons
public class Tugas6_Contoh5 extends JFrame {
    JButton[] buttons = new JButton[10];

    public Tugas6_Contoh5() {
        super("Tugas6_Contoh5");
        // setSize(335,318);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        ImageIcon icon = new ImageIcon("src\\icon.png");
        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton(icon);
            pane.add(buttons[i]);
        }
        setContentPane(pane);
        setLocationRelativeTo(null);
        pack();// pengganti setSize()
        show();
    }

    public static void main(String[] args) {
        Tugas6_Contoh5 rb = new Tugas6_Contoh5();
    }
}