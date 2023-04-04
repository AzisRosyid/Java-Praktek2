import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Tetris extends Applet implements Runnable, KeyListener, MouseListener {

    private volatile Thread timer;
    private TGrid gtgrid = new TGrid(); // instance class TGrid
    private TShape gtshape = new TShape(); // instance class TShape
    private Image bgi;
    private Graphics bgg;

    private int x, y; // posisi x,y shape pada grid
    private int score; // score permainan
    private int delay = 200;
    private boolean mulai = false;

    public void init() {
        setBackground(Color.black);
        addKeyListener(this);
        addMouseListener(this);
        bgi = createImage(getSize().width, getSize().height);
        bgg = bgi.getGraphics();
        score = 0;
        printScore();
        nextShape(); // persiapkan shape berikutnya
        reDrawGrid();
        reDrawNextShape();
    }

    public void start() {
        timer = new Thread(this);
        timer.start();
    }

    public void stop() {
        timer = null;
    }

    public void run() {
        boolean gameover = false;
        Thread me = Thread.currentThread();
        while (timer == me && !gameover) {
            try {
                Thread.currentThread().sleep(delay);
            } catch (InterruptedException e) {
            }
            if (mulai)
                gameover = !runGame();
            repaint();
        }
    }

    private boolean runGame() {
        // apakah shape bisa turun kebawah
        if (gtgrid.testShape(x, y + 1, gtshape))
            moveXY(0, 1); // pindah shape 1 baris ke bawah
        else {
            gtgrid.putShape(x, y, gtshape); // tempatkan shape kegrid
            score = score + gtgrid.checkGrid(); // periksa baris yang lengkap
            reDrawGrid(); // cetak ulang grid
            printScore(); // cetak score
            // jika shape tertahan di baris 3, artinya game over
            if (y < 3) {
                printGameOver();
                return false;
            } else
                nextShape(); // persiapkan gambar berikutnya
        }
        return true;
    }

    public void paint(Graphics g) {
        if (mulai) {
            g.drawImage(bgi, 0, 0, this);
        } else {
            g.setColor(Color.white);
            g.drawString("Klik pada applet untuk mulai", 10, 10);
        }
    }

    public void update(Graphics g) {
        paint(g);
    }

    // metoda mempersiapkan shape berikutnya
    private void nextShape() {
        gtshape.generateNextShape();
        reDrawNextShape(); // cetak shape berikutnya
        x = 7; // koordinat awal di 7,0
        y = 0;
        delay = 200;
    }

    // memindahkan shape keposisi x,y
    private void moveXY(int dx, int dy) {
        clearShape(); // hapus gambar sebelumnya
        x += dx; // ubah posisi x,y
        y += dy;
        drawShape(); // gambar diposisi baru
    }

    // metoda untuk mencetak score dilayar
    private void printScore() {
        bgg.setColor(Color.black);
        bgg.fillRect(20, 10, 200, 20);
        bgg.setColor(Color.white);
        bgg.drawString("Score : " + score, 20, 20);
    }

    // metoda untuk mencetak gameover
    private void printGameOver() {
        bgg.setColor(Color.white);
        bgg.drawString("Game Over!!!" + score, 20, 40);
    }

    // menggambar sel dari suatu shape
    private void drawSel(int x, int y, int w, int h, Color c) {
        if (y > 2) {
            bgg.setColor(c);
            bgg.fillRect(x * 21, y * 21, w, h);
            bgg.setColor(Color.white);
            bgg.drawRect(x * 21, y * 21, w, h);
        }
    }

    // menggambar sel dari suatu shape
    private void clearSel(int x, int y, int w, int h) {
        if (y > 2) {
            bgg.setColor(Color.black);
            bgg.fillRect(x * 21, y * 21, w, h);
            bgg.drawRect(x * 21, y * 21, w, h);
        }
    }

    // mengambar shape secara sementara
    private void drawShape() {
        for (int i = 0; i < 4; i++) {
            drawSel(x + gtshape.currentShapeSel(i, 0),
                    y + gtshape.currentShapeSel(i, 1),
                    20, 20, gtshape.currentcolor);
        }
    }

    // menghapus shape sementara
    private void clearShape() {
        for (int i = 0; i < 4; i++) {
            clearSel(x + gtshape.currentShapeSel(i, 0),
                    y + gtshape.currentShapeSel(i, 1),
                    20, 20);
        }
    }

    // mengambar ulang nextshape
    private void reDrawNextShape() {
        // menghapus bentuk sebelumnya
        bgg.setColor(Color.black);
        bgg.fillRect(300, 60, 120, 120);
        for (int i = 0; i < 4; i++) {
            drawSel(16 + gtshape.nextShapeSel(i, 0),
                    4 + gtshape.nextShapeSel(i, 1),
                    20, 20, gtshape.nextcolor);
        }
    }

    // mengambar ulang grid
    private void reDrawGrid() {
        for (int i = 3; i < 13; i++) {
            for (int j = 3; j < 23; j++) {
                // ada isi
                if (gtgrid.parr[i][j] != 0)
                    drawSel(i, j, 20, 20, gtgrid.carr[i][j]);
                else
                    clearSel(i, j, 20, 20);
            }
        }
        bgg.setColor(Color.white);
        bgg.drawRect(3 * 21 - 1, 3 * 21 - 1, 10 * 21 + 1, 20 * 21 + 1);
    }

    // by implementing a MouseListener
    public void mouseEntered(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }

    public void mousePressed(MouseEvent event) {
    }

    public void mouseReleased(MouseEvent event) {
    }

    public void mouseClicked(MouseEvent event) {
        mulai = true;
    }

    // by implementing a KeyListener
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (gtgrid.testShape(x - 1, y, gtshape))
                moveXY(-1, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (gtgrid.testShape(x + 1, y, gtshape))
                moveXY(1, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            gtshape.rotate(); // rotasi
            // apakah hasil rotasi dapat ditempatkan diposisi x,y
            if (gtgrid.testShape(x, y, gtshape)) {
                // kalau ya, rotasi balik kembali
                gtshape.deRotate();
                clearShape(); // hapus animasi shape sebelumnya
                gtshape.rotate(); // rotasi
                drawShape(); // ambar animasi shape baru
            } else
                gtshape.deRotate();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            delay = 10;
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}

class TGrid {
    public int[][] parr = new int[16][26]; // Array menyimpan isi sel pada grid
    public Color[][] carr = new Color[16][26]; // Array menyimpan warna sel pada grid

    // konstruktur class tgrid
    TGrid() {
        int i, j;
        for (i = 0; i < 16; i++) {
            for (j = 0; j < 26; j++)
                parr[i][j] = 1; // isi bingkai
        }
        for (i = 3; i < 13; i++) {
            for (j = 0; j < 23; j++)
                parr[i][j] = 0; // isi arena
        }
    }

    // Mengembalikan nilai yang menunjukan apakah
    // shape dapat ditempatkan pada grid diposisi x,y
    public boolean testShape(int x, int y, TShape s) {
        int i;
        for (i = 0; i < 4; i++) {
            // apakah sel pada grid telah terisi
            if (parr[x + s.currentShapeSel(i, 0)][y + s.currentShapeSel(i, 1)] > 0)
                return false;
        }
        return true;
    }

    // Menempatkan shape pada posisi x,y di grid
    public void putShape(int x, int y, TShape s) {
        int i;
        for (i = 0; i < 4; i++) {
            parr[x + s.currentShapeSel(i, 0)][y + s.currentShapeSel(i, 1)] = 1;
            carr[x + s.currentShapeSel(i, 0)][y + s.currentShapeSel(i, 1)] = s.currentcolor;
        }
    }

    // periksa apakah ada baris yang berhasil diselesaikan pemain
    public int checkGrid() {
        int i, j;
        int b, k;
        int complete;
        complete = 0;
        i = 22;
        while (i > 3) {
            j = 3;
            while ((parr[j][i] != 0) && (j < 13))
                j++;

            if (j == 13) {
                complete++;
                for (b = i; b > 3; b--) {
                    for (k = 3; k < 13; k++) {
                        parr[k][b] = parr[k][b - 1];
                        carr[k][b] = carr[k][b - 1];
                    }
                }
            } else
                i--;
        }
        return complete;
    }
}

class TShape {
    private int currentshape; // menyimpan nomor current shape
    private int nextshape; // menyimpan nomor next shape
    public Color currentcolor; // menyimpan warna current shape
    public Color nextcolor; // menyimpan warna next shape

    private int currentstate; // nomor rotasi shape

    // Array 4 dimensi yang berisi nilai sel dari masing-masing bentuk
    // serta bentuk rotasinya
    private int[][][][] sarr = { { { { 1, 0 }, { 1, 1 }, { 1, 2 }, { 1, 3 } },
            { { 0, 1 }, { 1, 1 }, { 2, 1 }, { 3, 1 } },
            { { 1, 0 }, { 1, 1 }, { 1, 2 }, { 1, 3 } },
            { { 0, 1 }, { 1, 1 }, { 2, 1 }, { 3, 1 } } },
            { { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } },
                    { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } },
                    { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } },
                    { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } } },
            { { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } },
                    { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 2, 0 } },
                    { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 } },
                    { { 0, 1 }, { 1, 1 }, { 2, 0 }, { 2, 1 } } },
            { { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } },
                    { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 0 } },
                    { { 1, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } },
                    { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 2, 1 } } },
            { { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } },
                    { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 2, 0 } },
                    { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } },
                    { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 2, 0 } } },
            { { { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 } },
                    { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } },
                    { { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 } },
                    { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } } } };

    // konstrutor untuk class tshape
    TShape() {
        generateShape();
    }

    // Membuat next shape berikutnya, dan menset current shape
    public void generateNextShape() {
        currentshape = nextshape;
        currentcolor = nextcolor;
        currentstate = 0; // rotasi ke 0
        generateShape(); // buat nextshape baru
    }

    // Membuat bentuk dan mengembalikan melalui parameter shape dan shapecolor
    private void generateShape() {
        int c;
        nextshape = (int) (Math.random() * 6); // random untuk shape
        c = (int) (Math.random() * 8); // random untuk shape color
        switch (c) {
            case 0:
                nextcolor = Color.red;
                break;
            case 1:
                nextcolor = Color.green;
                break;
            case 2:
                nextcolor = Color.blue;
                break;
            case 3:
                nextcolor = Color.orange;
                break;
            case 4:
                nextcolor = Color.pink;
                break;
            case 5:
                nextcolor = Color.cyan;
                break;
            case 6:
                nextcolor = Color.gray;
                break;
            default:
                nextcolor = Color.magenta;
        }
    }

    // Rotasi ke bentuk berikutnya
    public void rotate() {
        currentstate = currentstate + 1; // Rotasi berikutnya
        if (currentstate == 4)
            currentstate = 0; // Kembali ke bentuk awal
    }

    // Rotasi ke bentuk sebelumnya
    public void deRotate() {
        currentstate = currentstate - 1; // Rotasi sebelumnya
        if (currentstate == -1)
            currentstate = 3;
    }

    // Mengembalikan sel i,j dari current shape
    public int currentShapeSel(int i, int j) {
        return sarr[currentshape][currentstate][i][j];
    }

    // Mengembalikan sel i,j dari next shape
    public int nextShapeSel(int i, int j) {
        return sarr[nextshape][0][i][j]; // Bentuk awal
    }
}
