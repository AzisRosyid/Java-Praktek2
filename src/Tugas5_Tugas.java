import java.awt.*;
import java.awt.event.*;

public class Tugas5_Tugas extends Frame {
    private Button[] btnNumbers;
    private Button[] btnOperators;
    private Button btnClear, btnHasil;
    private TextField tfDisplay;
    Double nilaiA = null, hasil = null;
    String operator = null;

    public Tugas5_Tugas() {
        Panel panelDisplay = new Panel(new FlowLayout());
        tfDisplay = new TextField("0", 25);
        panelDisplay.add(tfDisplay);
        Panel panelButtons = new Panel(new GridLayout(4, 4));
        tfDisplay.setEditable(false);
        btnNumbers = new Button[10];
        btnOperators = new Button[4];
        btnNumbers[1] = new Button("1");
        panelButtons.add(btnNumbers[1]);
        btnNumbers[2] = new Button("2");
        panelButtons.add(btnNumbers[2]);
        btnNumbers[3] = new Button("3");
        panelButtons.add(btnNumbers[3]);
        btnOperators[0] = new Button("+");
        panelButtons.add(btnOperators[0]);
        btnNumbers[4] = new Button("4");
        panelButtons.add(btnNumbers[4]);
        btnNumbers[5] = new Button("5");
        panelButtons.add(btnNumbers[5]);
        btnNumbers[6] = new Button("6");
        panelButtons.add(btnNumbers[6]);
        btnOperators[1] = new Button("-");
        panelButtons.add(btnOperators[1]);
        btnNumbers[7] = new Button("7");
        panelButtons.add(btnNumbers[7]);
        btnNumbers[8] = new Button("8");
        panelButtons.add(btnNumbers[8]);
        btnNumbers[9] = new Button("9");
        panelButtons.add(btnNumbers[9]);
        btnOperators[2] = new Button("*");
        panelButtons.add(btnOperators[2]);
        btnClear = new Button("C");
        panelButtons.add(btnClear);
        btnNumbers[0] = new Button("0");
        panelButtons.add(btnNumbers[0]);
        btnHasil = new Button("=");
        panelButtons.add(btnHasil);
        btnOperators[3] = new Button("/");
        panelButtons.add(btnOperators[3]);
        setLayout(new BorderLayout());
        BtnNumberListener btnNumberListener = new BtnNumberListener();
        for (Button button : btnNumbers)
            button.addActionListener(btnNumberListener);
        BtnOperatorListener btnOperatorListener = new BtnOperatorListener();
        for (Button button : btnOperators)
            button.addActionListener(btnOperatorListener);
        btnClear.addActionListener(new BtnClearListener());
        btnHasil.addActionListener(new BtnHasilListener());
        addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        });
        add(panelDisplay, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);
        setTitle("Kalkulator Sederhana");
        setSize(400, 200);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Tugas5_Tugas();
    }

    private class BtnNumberListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (tfDisplay.getText() != "" && hasil == null) {
                if (tfDisplay.getText().equals("0"))
                    tfDisplay.setText(evt.getActionCommand());
                else
                    tfDisplay.setText(tfDisplay.getText() + evt.getActionCommand());
            }
        }
    }

    private class BtnOperatorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (tfDisplay.getText() != "" && operator == null) {
                nilaiA = Double.valueOf(tfDisplay.getText());
                operator = evt.getActionCommand();
                hasil = null;
                tfDisplay.setText("0");
            }
        }
    }

    private class BtnClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            tfDisplay.setText("0");
            nilaiA = null;
            operator = null;
            hasil = null;
        }
    }

    private class BtnHasilListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (nilaiA != null && operator != "" && hasil == null) {
                double nilaiB = Double.valueOf(tfDisplay.getText());
                if (operator.equals("+")) {
                    hasil = nilaiA + nilaiB;
                } else if (operator.equals("-")) {
                    hasil = nilaiA - nilaiB;
                } else if (operator.equals("*")) {
                    hasil = nilaiA * nilaiB;
                } else if (operator.equals("/"))
                    hasil = nilaiA / nilaiB;
                tfDisplay.setText(String.valueOf(hasil));
                operator = null;
            }
        }
    }
}
