import javax.swing.*;

// Form
public class Tugas6_Contoh6 extends JFrame {
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);
    JTextArea comments = new JTextArea(4, 15);

    public Tugas6_Contoh6() {
        super("Feedback Tugas6_Contoh6");
        setSize(260, 160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        JLabel usernameLabel = new JLabel("Username : ");
        JLabel passwordLabel = new JLabel("Password : ");
        JLabel commentsLabel = new JLabel("Comments : ");
        comments.setLineWrap(true);
        comments.setWrapStyleWord(true);
        // password.setEchoChar('#');
        JScrollPane scroll = new JScrollPane(comments, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pane.add(usernameLabel);
        pane.add(username);
        pane.add(passwordLabel);
        pane.add(password);
        pane.add(commentsLabel);
        pane.add(comments);
        pane.add(scroll);
        setContentPane(pane);
        show();
    }

    public static void main(String[] args) {
        Tugas6_Contoh6 input = new Tugas6_Contoh6();
    }
}