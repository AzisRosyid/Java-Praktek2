import java.awt.*;
import java.awt.event.*;

public class Tugas5_Praktek4 extends Frame {
    private TextField tfMouseX;
    private TextField tfMouseY; 

    public Tugas5_Praktek4() {
        setLayout(new FlowLayout());
        add(new Label("X-Click: "));
        tfMouseX = new TextField(10);
        tfMouseX.setEditable(false);
        add(tfMouseX);
        add(new Label("Y-Click: "));
        tfMouseY = new TextField(10);
        tfMouseY.setEditable(false);
        add(tfMouseY);
        addMouseListener(new MyMouseListener());
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setTitle("MouseEvent Demo");
        setSize(350, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Tugas5_Praktek4();
    }

    private class MyMouseListener implements MouseListener {
        // Called back upon mouse clicked @Override
        public void mouseClicked(MouseEvent evt) {
            tfMouseX.setText(evt.getX() + "");
            tfMouseY.setText(evt.getY() + "");
        }

        // Not used - need to provide an empty body to compile.
        @Override
        public void mousePressed(MouseEvent evt) {
        }

        @Override
        public void mouseReleased(MouseEvent evt) {
        }

        @Override
        public void mouseEntered(MouseEvent evt) {
        }

        @Override
        public void mouseExited(MouseEvent evt) {
        }
    }

}
