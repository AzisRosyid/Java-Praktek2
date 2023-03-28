import javax.swing.*;

// JScrollPane
public class Tugas6_Contoh7 extends JFrame {
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);
    JTextArea comments = new JTextArea(4, 15);

    public Tugas6_Contoh7() {
        super("JScrollPane Tugas6_Contoh7");
        setSize(260, 160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        JTextArea comments = new JTextArea(5, 15);
        JScrollPane scroll = new JScrollPane(comments, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pane.add(scroll);
        setContentPane(pane);
        show();
    }

    public static void main(String[] args) {
        Tugas6_Contoh7 input = new Tugas6_Contoh7();
    }
}