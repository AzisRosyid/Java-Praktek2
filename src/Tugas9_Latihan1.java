import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.swing.*;
import java.awt.event.*;

public class Tugas9_Latihan1 extends JFrame {
    JButton startServer = new JButton("START SERVER");
    JButton shutdown = new JButton("SHUTDOWN");
    JTextArea textArea = new JTextArea(4, 15);
    ServerFrame serverFrame = new ServerFrame();

    Tugas9_Latihan1() {
        // super("Frame title");
        // setSize(300, 100);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setLocationRelativeTo(null);
        // setVisible(true);
        super("Server Frame");
        setSize(300, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        textArea = new JTextArea(8, 25);
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        startServer.addActionListener(new BtnStartServer());
        pane.add(scroll);
        pane.add(startServer);
        pane.add(shutdown);
        shutdown.addActionListener(null);
        setContentPane(pane);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Tugas9_Latihan1 sf = new Tugas9_Latihan1();
    }

    private class BtnStartServer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                serverFrame.startServer(textArea);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class ServerFrame {
    private ServerSocket serverSocket;

    private static final int PORT = 6006;

    public void startServer(JTextArea textArea) throws IOException {

        try {
            serverSocket = new ServerSocket(PORT);
            textArea.append("Waiting for client on port" + serverSocket.getLocalPort() + "...\n");
            Socket server = serverSocket.accept();

            textArea.append("Just connected to" + server.getRemoteSocketAddress() + "\n");
            DataInputStream in = new DataInputStream(server.getInputStream());

            textArea.append(in.readUTF() + "\n");
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("Hello, you are connected...");
        } catch (SocketTimeoutException e) {
            System.out.println("Socket timed out!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}