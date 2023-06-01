import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Random;
import javax.swing.*;
import java.util.Date;

public class Jamku extends Frame {
    JLabel tampil_jam = new JLabel();
    private int PusatX, PusatY, xorR, xorG, xorB;
    Random Rdm;

    public Jamku() {
        super("Jame Denmas Ardiy");

        // setLayout(new FlowLayout());
        setSize(200, 200);
        // setLayout(new GridLayout(2, 0, 5, 5));

        addWindowListener(new WindowListener() {
            public void windowActivated(WindowEvent e) {
            }

            public void windowClosed(WindowEvent e) {
            }

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            public void windowDeactivated(WindowEvent e) {
            }

            public void windowDeiconified(WindowEvent e) {
            }

            public void windowIconified(WindowEvent e) {
            }

            public void windowOpened(WindowEvent e) {
            }
        });

        Rdm = new java.util.Random();
        setBackground(Color.blue);// latar belakang jendela
        new javax.swing.Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                repaint();
                PusatX = getWidth() / 2;
                PusatY = 10 + getHeight() / 2;
                // xorR=Rdm.nextInt(255);
                // xorG=Rdm.nextInt(255);
                // xorB=Rdm.nextInt(255);

            }
        }).start();
    }

    public static void main(String[] a) {
        new Jamku().setVisible(true);
    }

    public void paint(Graphics G) {

        G.setColor(Color.yellow);// warna bingkai lingkaran jam
        int Panjang;
        if (getWidth() < getHeight())
            Panjang = getWidth() - 50;
        else
            Panjang = getHeight() - 50;
        G.drawOval(PusatX - Panjang / 2, PusatY - Panjang / 2, Panjang, Panjang);// gambar lingkaran luar kuning
        G.drawOval(PusatX + 5 - Panjang / 2, PusatY + 5 - Panjang / 2, Panjang - 10, Panjang - 10);// gambar lingkaran
                                                                                                   // dalam kuning
        // lingkaran putih
        G.setColor(Color.white);
        G.fillOval(8 + (int) (PusatX - Panjang / 2), 8 + (int) (PusatY - Panjang / 2), 135, 135);
        // angka jam
        G.setColor(Color.yellow);
        for (int I = 1; I <= 60; I++)
            G.fillOval((int) (PusatX + Math.sin(6 * Math.PI * I / 180) * Panjang / 2),
                    (int) (PusatY + Math.cos(6 * Math.PI * I / 180) * -1 * Panjang / 2), 5, 5);
        G.setColor(Color.black);
        for (int I = 1; I <= 12; I++)
            G.drawString("" + I, -2 + (int) (PusatX + Math.sin(30 * Math.PI * I / 180) * Panjang / 2.5),
                    5 + (int) (PusatY + Math.cos(30 * Math.PI * I / 180) * -1 * Panjang / 2.5));

        String detik_awal = "";
        String menit_awal = "";
        String jam_awal = "";
        String hari_awal = "";
        String bulan_awal = "";
        Date dt = new Date();
        int nilai_detik = dt.getSeconds();
        int nilai_menit = dt.getMinutes();
        int nilai_jam = dt.getHours();
        int nilai_hari = dt.getDate();
        int nilai_bulan = dt.getMonth() + 1;
        int nilai_tahun = dt.getYear() + 1900;

        if (nilai_detik <= 9) {
            detik_awal = "0";
        }
        if (nilai_jam <= 9) {
            jam_awal = "0";
        }
        if (nilai_menit <= 9) {
            menit_awal = "0";
        }

        if (nilai_hari <= 9) {
            hari_awal = "0";
        }
        if (nilai_bulan <= 9) {
            bulan_awal = "0";
        }
        /*
         * String namabln;
         * switch (nilai_bulan) {
         * case 1: namabln = "Jan";
         * break;
         * case 2: namabln = "Feb";
         * break;
         * case 3: namabln = "Mar";
         * break;
         * case 4: namabln = "Apr";
         * break;
         * case 5: namabln = "Mei";
         * break;
         * case 6: namabln = "Jun";
         * break;
         * case 7: namabln = "Jul";
         * break;
         * case 8: namabln = "Ags";
         * break;
         * case 9: namabln = "Sep";
         * break;
         * case 10: namabln = "Okt";
         * break;
         * case 11: namabln = "Nop";
         * break;
         * case 12: namabln = "Des";
         * break;
         * default: System.out.println("Errors: invalid status");
         * System.exit(0);
         * }
         */

        String detik = detik_awal + Integer.toString(nilai_detik);
        String menit = menit_awal + Integer.toString(nilai_menit);
        String jam = jam_awal + Integer.toString(nilai_jam);
        String hari = hari_awal + Integer.toString(nilai_hari);
        String bulan = bulan_awal + Integer.toString(nilai_bulan);
        String tahun = Integer.toString(nilai_tahun);
        // G.setXORMode(new Color(xorR,xorG,xorB));
        // jarum detik
        G.setColor(Color.black);// warna jarum
        // float Detik=Waktu(Calendar.SECOND)+(float)Waktu(Calendar.MILLISECOND)/1000;
        double Detik = Double.parseDouble(detik);
        G.drawLine(PusatX, PusatY, (int) (PusatX + (Math.sin(2 * Math.PI * Detik / 60) * Panjang / 2)),
                (int) (PusatY + (-1 * Math.cos(2 * Math.PI * Detik / 60) * Panjang / 2)));
        // jarum menit
        // float Menit=Waktu(Calendar.MINUTE)+(float)Detik/60;
        double Menit = Double.parseDouble(menit);
        G.drawLine(PusatX, PusatY, (int) (PusatX + (Math.sin(2 * Math.PI * Menit / 60) * Panjang / 2.2)),
                (int) (PusatY + (-1 * Math.cos(2 * Math.PI * Menit / 60) * Panjang / 2.2)));
        // jarum jam
        float Jam = Waktu(Calendar.HOUR) + (float) Menit / 60;
        // double Jam=Double.parseDouble(jam);
        G.drawLine(PusatX, PusatY, (int) (PusatX + (Math.sin(2 * Math.PI * Jam / 12) * Panjang / 3)),
                (int) (PusatY + (-1 * Math.cos(2 * Math.PI * Jam / 12) * Panjang / 3)));
        G.fillOval(PusatX - 5, PusatY - 5, 10, 10);// lingkaran pusat jarum

        G.drawString(" " + jam + " : " + menit + " : " + detik, 70, 90);
        G.drawString(" " + hari + "/" + bulan + " /" + tahun, 65, 140);

    }

    private int Waktu(int Jenis) {
        return Calendar.getInstance().get(Jenis);
    }
}
