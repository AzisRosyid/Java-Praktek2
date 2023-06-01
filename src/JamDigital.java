import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.awt.*;

public class JamDigital extends JFrame {
    JLabel tampil_jam = new JLabel();

    public JamDigital() {
        tampil_jam.setFont(new Font("Dialog", 1, 30));
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(tampil_jam);
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String jam_awal = "";
                String menit_awal = "";
                String detik_awal = "";
                Date dt = new Date();
                int nilai_jam = dt.getHours();
                int nilai_menit = dt.getMinutes();
                int nilai_detik = dt.getSeconds();
                if (nilai_jam <= 9) {
                    jam_awal = "0";
                }
                if (nilai_menit <= 9) {
                    menit_awal = "0";
                }
                if (nilai_detik <= 9) {
                    detik_awal = "0";
                }
                String jam = jam_awal + Integer.toString(nilai_jam);
                String menit = menit_awal + Integer.toString(nilai_menit);
                String detik = detik_awal + Integer.toString(nilai_detik);
                tampil_jam.setText("  " + jam + " : " + menit + " : " + detik + "  ");
            }
        };
        new Timer(1000, taskPerformer).start();
    }

    public static void main(String[] args) {
        JamDigital jd = new JamDigital();
        jd.setTitle("Jam Digitalku Baru");
        jd.setVisible(true);
        jd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jd.setSize(200, 300);
        jd.show();
    }
}
