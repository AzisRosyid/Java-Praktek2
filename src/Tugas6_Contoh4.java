import javax.swing.*;

// Button Applet
public class Tugas6_Contoh4 extends JApplet {
    JButton abort = new JButton("Abort");
    JButton retry = new JButton("Retry");
    JButton fail = new JButton("Fail");

    public void init() {
        JPanel pane = new JPanel();
        pane.add(abort);
        pane.add(retry);
        pane.add(fail);
        setContentPane(pane);
    }
}