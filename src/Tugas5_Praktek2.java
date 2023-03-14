import java.awt.*;
import java.awt.event.*;

public class Tugas5_Praktek2 extends Frame {
    private TextField tfInput, tfOutput;
    private int sum = 0;

    public Tugas5_Praktek2() {
        setLayout(new GridLayout(2, 2));
        add(new Label("Enter an Integer: "));
        tfInput = new TextField(10); // Construct
        add(tfInput); // "super" Frame adds
        tfInput.addActionListener(new TFInputListener());
        add(new Label("The Accumulated Sum is: "));
        tfOutput = new TextField(10); // allocate TextField tfOutput.setEditable(false); // read-only
        add(tfOutput); // "super" Frame adds TextField
        setTitle("AWT Accumulator"); // "super" Frame sets title
        setSize(350, 120); // "super" Frame sets initial window 
        setLocationRelativeTo(null);
        setVisible(true); // "super" Frame shows
    }

    public static void main(String[] args) {
        new Tugas5_Praktek2();
    }

    private class TFInputListener implements ActionListener {
        // ActionEvent handler - Called back upon hitting "enter" key on TextField
        @Override
        public void actionPerformed(ActionEvent evt) {
            // Get the String entered into the TextField tfInput, convert to int
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn; // Accumulate numbers entered into sum
            tfInput.setText(""); // Clear input TextField
            tfOutput.setText(sum + ""); // Display sum on the output TextField
            // convert int to String
        }
    }

}
