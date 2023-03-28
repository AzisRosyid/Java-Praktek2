import javax.swing.*;

// Expiration Date
public class Tugas6_Contoh10 extends JFrame {
    JComboBox monthBox = new JComboBox();
    JComboBox yearBox = new JComboBox();

    public Tugas6_Contoh10() {
        super("Expiration Date");
        setSize(220, 90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        JLabel exp = new JLabel("Expiration Date");
        pane.add(exp);
        for (int i = 1; i < 13; i++)
            monthBox.addItem("" + i);
        for (int i = 2000; i < 2010; i++)
            yearBox.addItem("" + i);
        pane.add(monthBox);
        pane.add(yearBox);
        setContentPane(pane);
        setLocationRelativeTo(null);
        show();
    }

    public static void main(String[] args) {
        Tugas6_Contoh10 ex = new Tugas6_Contoh10();
    }
}