
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Random;

import javax.imageio.ImageIO;

public class JamAnalog extends Frame {
    private int PusatX, PusatY, xorR, xorG, xorB;
    Random Rdm;

    public JamAnalog() {
        super("om_agus Klok_klok");
        setLayout(new FlowLayout());
        setSize(800, 600);
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
        setBackground(Color.black);
    


        new javax.swing.Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                repaint();
                PusatX = getWidth() / 2;
                PusatY = getHeight() / 2;
                xorR = Rdm.nextInt(255);
                xorG = Rdm.nextInt(255);
                xorB = Rdm.nextInt(255);
            }
        }).start();
    }

    public static void main(String[] a) {
        new JamAnalog().setVisible(true);
    }

    public void paint(Graphics G) {
        G.setColor(Color.BLACK);
        G.setColor(Color.red);
        int Panjang;
        if (getWidth() < getHeight())
            Panjang = getWidth() - 100;
        else
            Panjang = getHeight() - 100;
        G.drawOval(PusatX - Panjang / 2, PusatY - Panjang / 2, Panjang, Panjang);

        G.setColor(Color.white);
        for (int I = 1; I <= 12; I++) {
            G.fillOval((int) (PusatX + Math.sin(30 * Math.PI * I / 180) * Panjang / 2),
                    (int) (PusatY + Math.cos(30 * Math.PI * I / 180) * -1 * Panjang / 2), 5, 5);
            G.drawString("" + I, (int) (PusatX + Math.sin(30 * Math.PI * I / 180) * Panjang / 2.2),
                    (int) (PusatY + Math.cos(30 * Math.PI * I / 180) * -1 * Panjang / 2.2));
        }

        G.setXORMode(new Color(xorR, xorG, xorB));

        float Detik = Waktu(Calendar.SECOND) + (float) Waktu(Calendar.MILLISECOND) / 1000;
        G.setColor(Color.white);
        G.drawLine(PusatX, PusatY, (int) (PusatX + (Math.sin(2 * Math.PI * Detik / 60) * Panjang / 2
        )),
                (int) (PusatY + (-1 * Math.cos(2 * Math.PI * Detik / 60) * Panjang / 2)));

        float Menit = Waktu(Calendar.MINUTE) + (float) Detik / 60;
        G.setColor(Color.green);
        G.drawLine(PusatX, PusatY, (int) (PusatX + (Math.sin(2 * Math.PI * Menit / 60) * Panjang / 2.1)),
                (int) (PusatY + (-1 * Math.cos(2 * Math.PI * Menit / 60) * Panjang / 2.1)));

        float Jam = Waktu(Calendar.HOUR) + (float) Menit / 60;
        G.setColor(Color.BLUE);
        G.drawLine(PusatX, PusatY, (int) (PusatX + (Math.sin(2 * Math.PI * Jam / 12) * Panjang / 2.3)),
                (int) (PusatY + (-1 * Math.cos(2 * Math.PI * Jam / 12) * Panjang / 2.3)));

        G.fillOval(PusatX - 5, PusatY - 5, 10, 10);
    }

    private int Waktu(int Jenis) {
        return Calendar.getInstance().get(Jenis);
    }
}