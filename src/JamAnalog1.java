import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JamAnalog1 extends Frame implements MouseListener
{
    private int PusatX, PusatY;
    Random Rdm;
    private Image backgroundImage;
    JButton btn;
    private Integer alarmHour;
    private Integer alarmMinute;

    public JamAnalog1()
    {
        super("om_agus Klok_klok");
        setLayout(new FlowLayout());
        setSize(800,600);
        setLocationRelativeTo(null);
        addWindowListener(new WindowListener()
        {
            public void windowActivated(WindowEvent e) {}
            public void windowClosed(WindowEvent e) {}
            public void windowClosing(WindowEvent e) 
            {
                System.exit(0);
            }

            public void windowDeactivated(WindowEvent e){}
            public void windowDeiconified(WindowEvent e) {}
            public void windowIconified(WindowEvent e) {}
            public void windowOpened(WindowEvent e) {}
        });

        addMouseListener(this);
        
        Rdm = new java.util.Random();
        backgroundImage = new ImageIcon("src/bg4.jpg").getImage();
        setBackground(Color.black);

        String bip = "src/detik4.wav";
        playSound(bip, true);

        new javax.swing.Timer(100,new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                repaint();
                PusatX = getWidth() / 2;
                PusatY = getHeight() / 2;
            }
        }).start();
    }

    public static void main(String[]a)
    {
        new JamAnalog1().setVisible(true);
    }

    public void update(Graphics g)
    {
        Image offscreen = createImage(getWidth(), getHeight());
        Graphics offscreenGraphics = offscreen.getGraphics();

        offscreenGraphics.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);

        paint(offscreenGraphics);

        g.drawImage(offscreen, 0, 0, null);
    }

    public void mouseClicked(MouseEvent e) {
        String input = javax.swing.JOptionPane.showInputDialog(this, "Set alarm (HH:mm):");
        if (input != null) {
            String[] timeComponents = input.split(":");
            if (timeComponents.length == 2) {
                try {
                    int hour = Integer.parseInt(timeComponents[0]);
                    int minute = Integer.parseInt(timeComponents[1]);
                    if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) {
                        alarmHour = hour;
                        alarmMinute = minute;
                        setAlarm();
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this, "Invalid time format!");
                    }
                } catch (NumberFormatException ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Invalid time format!");
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid time format!");
            }
        }
    }
    
    // Other methods of the MouseListener interface
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    private void playSound(String path, boolean loop) {
        try {
            File sound = new File(path);

            if (sound.exists()) {
                
                AudioInputStream ai = AudioSystem.getAudioInputStream(sound);
                Clip cp = AudioSystem.getClip();
                cp.open(ai);
                if (loop)
                    cp.loop(Clip.LOOP_CONTINUOUSLY);
                cp.start();
            } else {
                System.out.println("File does not exist!");
            }
        } catch (Exception e) {

        }
    }

    public void paint(Graphics G)
    {
        Graphics2D g2 = (Graphics2D) G;
        g2.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        
        
        int Panjang;
        if (getWidth() < getHeight()) 
            Panjang = getWidth() - 100;
        else 
            Panjang = getHeight() - 100;

        g2.setStroke(new BasicStroke(7));
        g2.setColor(Color.white);
        g2.drawOval(PusatX - Panjang / 2, PusatY - Panjang / 2, Panjang, Panjang);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.darkGray);
        g2.drawOval(PusatX - Panjang / 2, PusatY - Panjang / 2, Panjang, Panjang);

        g2.setColor(Color.white);
        g2.setFont(new Font("Arial", Font.BOLD, 16));
        if (alarmHour != null && alarmMinute != null) 
            g2.setFont(new Font("Arial", Font.BOLD, 22));
        g2.drawString(alarmMinute == null && alarmHour == null ? "Click to set Alarm" : (alarmHour < 10 ? "0" + alarmHour : alarmHour) + ":" + (alarmMinute < 10 ? "0" + alarmMinute : alarmMinute), alarmMinute == null && alarmHour == null ? PusatX - 65 : PusatX - 30, PusatY + 65);

        g2.setColor(Color.white);
        g2.setFont(new Font("Arial", Font.BOLD, 22));
        for(int I=1;I<=12;I++)
        {
            g2.fillOval((int)(PusatX + Math.sin(30 * Math.PI * I / 180) * Panjang / 2), (int) (PusatY + Math.cos(30 * Math.PI * I / 180) * -1 * Panjang / 2),10,10);
            g2.drawString("" + I, (int) (PusatX + (Math.sin(30 * Math.PI * I / 180) * Panjang / 2.2)-5), (int) (PusatY + (Math.cos(30 * Math.PI * I / 180) * -1 * Panjang / 2.2))+13);
        }

        g2.drawString(String.valueOf("Jam Azis"), PusatX - 50, PusatY - 130);
        g2.drawString(String.valueOf(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())), PusatX - 40, PusatY + 110);
        g2.drawString(String.valueOf(LocalDate.now()), PusatX - 50, PusatY + 140);
        

        // G.setXORMode(new Color(xorR,xorG,xorB));

        float Detik = Waktu(Calendar.SECOND) + (float) Waktu (Calendar.MILLISECOND) / 1000;
        
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(PusatX, PusatY, (int) (PusatX + (Math.sin(2 * Math.PI * Detik/60) * Panjang / 2.2)), (int) (PusatY + (-1 * Math.cos(2 * Math.PI * Detik / 60) * Panjang / 2.2)));
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(1));
        g2.drawLine(PusatX, PusatY, (int) (PusatX + (Math.sin(2 * Math.PI * Detik/60) * Panjang / 2.2)), (int) (PusatY + (-1 * Math.cos(2 * Math.PI * Detik / 60) * Panjang / 2.2)));

        float Menit = Waktu(Calendar.MINUTE) + (float) Detik / 60;
        // G.setColor(Color.green);
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(PusatX, PusatY, (int) (PusatX + (Math.sin(2 * Math.PI * Menit / 60) * Panjang / 2.3)), (int) (PusatY + (-1 * Math.cos(2 * Math.PI * Menit / 60) * Panjang / 2.3)));
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(PusatX, PusatY, (int) (PusatX + (Math.sin(2 * Math.PI * Menit / 60) * Panjang / 2.3)), (int) (PusatY + (-1 * Math.cos(2 * Math.PI * Menit / 60) * Panjang / 2.3)));

        float Jam = Waktu(Calendar.HOUR) + (float) Menit / 60;
        // G.setColor(Color.BLUE);
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(7));
        g2.drawLine(PusatX, PusatY, (int) (PusatX + (Math.sin(2 * Math.PI * Jam / 12) * Panjang / 2.5)), (int) (PusatY + (-1 * Math.cos(2 * Math.PI * Jam / 12) * Panjang / 2.5)));
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(PusatX, PusatY, (int) (PusatX + (Math.sin(2 * Math.PI * Jam / 12) * Panjang / 2.5)), (int) (PusatY + (-1 * Math.cos(2 * Math.PI * Jam / 12) * Panjang / 2.5)));

        g2.setColor(Color.white);
        g2.fillOval(PusatX-10,PusatY-10,20,20);
        g2.setColor(Color.black);
        g2.fillOval(PusatX-5,PusatY-5,10,10);
    }

    private int Waktu(int Jenis) {
        return Calendar.getInstance().get(Jenis);
    }

    private void setAlarm() {
        Calendar alarmTime = Calendar.getInstance();
        alarmTime.set(Calendar.HOUR_OF_DAY, alarmHour);
        alarmTime.set(Calendar.MINUTE, alarmMinute);
        alarmTime.set(Calendar.SECOND, 0);
        alarmTime.set(Calendar.MILLISECOND, 0);

        Calendar currentTime = Calendar.getInstance();

        long delay = alarmTime.getTimeInMillis() - currentTime.getTimeInMillis();

        if (delay < 0) {
            alarmTime.add(Calendar.DAY_OF_YEAR, 1);
            delay = alarmTime.getTimeInMillis() - currentTime.getTimeInMillis();
        }

        javax.swing.Timer timer = new javax.swing.Timer((int) delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bip = "src/sound4.wav";
                playSound(bip, false);
                alarmMinute = null;
                alarmHour = null;
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}