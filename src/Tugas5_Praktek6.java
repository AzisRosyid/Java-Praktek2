import java.awt.*;
import java.awt.event.*;

public class Tugas5_Praktek6 extends Frame {

    private TextField tfInput;
    private TextArea taDisplay;

    public Tugas5_Praktek6() {
        setLayout(new FlowLayout());

        add(new Label("Enter Text: "));
        tfInput = new TextField(10);
        add(tfInput);
        taDisplay = new TextArea(5, 40);
        add(taDisplay);

        tfInput.addKeyListener(new MyKeyListener());

        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setTitle("KeyEvent Demo");
        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Tugas5_Praktek6();
    }

    private class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent evt) {
            taDisplay.append("You have typed " + evt.getKeyChar() + "\n");
        }

        @Override
        public void keyPressed(KeyEvent evt) {
        }

        @Override
        public void keyReleased(KeyEvent evt) {
        }
    }
}
