import javax.swing.*;

// Choose Team
public class Tugas6_Contoh9 extends JFrame {
    JRadioButton[] teams = new JRadioButton[4];
    JCheckBox[] foods = new JCheckBox[4];

    public Tugas6_Contoh9() {
        super("Choose Team");
        setSize(140, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teams[0] = new JRadioButton("Colorado");
        teams[1] = new JRadioButton("Dallas", true);
        teams[2] = new JRadioButton("New Jersey");
        teams[3] = new JRadioButton("Philadelphia");
        JPanel pane = new JPanel();
        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < teams.length; i++) {
            group.add(teams[i]);
            pane.add(teams[i]);
        }
        foods[0] = new JCheckBox("Mie Ayam");
        foods[1] = new JCheckBox("Bakso");
        foods[2] = new JCheckBox("Nasi Goreng");
        foods[3] = new JCheckBox("Rendang", true);
        ButtonGroup group2 = new ButtonGroup();
        for (int i = 0; i < foods.length; i++) {
            group2.add(foods[i]);
            pane.add(foods[i]);
        }
        setContentPane(pane);
        setLocationRelativeTo(null);
        show();
    }

    public static void main(String[] args) {
        Tugas6_Contoh9 ct = new Tugas6_Contoh9();
    }
}