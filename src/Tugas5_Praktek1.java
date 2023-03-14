import java.awt.*;
import java.awt.event.*;

public class Tugas5_Praktek1 extends Frame {
    private Label lblCount;
    private TextField tfCount;
    private Button btnCount;
    private int count = 0;

    public Tugas5_Praktek1() {
        setLayout(new FlowLayout());
        lblCount = new Label("Counter");
        add(lblCount); 
        tfCount = new TextField(count + "", 10);
        tfCount.setEditable(false); 
        add(tfCount);
        btnCount = new Button("Count"); 
        add(btnCount); 
        BtnCountListener listener = new BtnCountListener();
        btnCount.addActionListener(listener);
        setTitle("AWT Counter"); 
        setSize(300, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Tugas5_Praktek1 app = new Tugas5_Praktek1();
    }

    private class BtnCountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            ++count; 
            tfCount.setText(count + ""); 
        }
    }
}