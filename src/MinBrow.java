import java.util.ArrayList;
/* LabSheet 14
   Kontrol GUI Swing
   Mini Browser
   Masukkan link web yang berisi teks
   misal link web yang dimasukkan
   https://github.com/kimhung222/SwingLab/blob/master/src/Textfield/TextfieldExample.java
   by Totok S
*/
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MinBrow extends JFrame {
    public static void main(String[] args) {
        // Membuat sebuah BrowserFrame baru
        JFrame frame = new MinBrow();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();
    }

    MinBrow() {
        setTitle("Azis Mini-Browser");
        Image img;
        try {
            img = ImageIO.read(new File("src\\img.png"));
            // setIconImage(img);
            // add(new JLabel(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_DEFAULT))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBackground(Color.BLACK);
        
        // membuat instance baru dari listener yang memuat halaman
        LoadPage loadPage = new LoadPage();
        // mengatur bidang teks
        textField.requestFocus();
        // Membuat tombol "Go" yang dapat diklik pengguna untuk memuat halaman
        JButton goButton = new JButton("Go");
        goButton.addActionListener(loadPage);
        // Membuat bilah URL, tambahkan ke bagian atas bingkai
        JPanel topPanel = new JPanel();
        topPanel.add(teks);//
        topPanel.add(textField);
        topPanel.add(goButton);
        getContentPane().add(topPanel, BorderLayout.NORTH);
        // Menambahkan panel edit ke tengah bingkai
        editPane.setEditable(false);
        getContentPane().add(new JScrollPane(editPane), BorderLayout.CENTER);
        // ukuran bingkai yang tepat
        pack();
        setSize((int) getSize().getWidth(), 400);
    }

    JLabel teks = new JLabel("Isikan suatu alamat web yang berisi teks");//
    JTextField textField = new JTextField(30);
    JEditorPane editPane = new JEditorPane();

    class LoadPage implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                System.out.println("memuat halaman: " + textField.getText());
                editPane.setPage(textField.getText());
            } catch (Exception ex) {
                // JLabel label = new JLabel("Halaman tidak ditemukan!", null, ABORT);
                // editPane.add(textField.setText("Hello"));
                ex.printStackTrace();
            }
        }
    }
}