import java.awt.Point;

class MyRect1 {
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    MyRect1 buildRect(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        return this;
    }

    MyRect1 buildRect(Point topleft, Point bottomRight) {
        x1 = topleft.x;
        y1 = topleft.y;
        x2 = bottomRight.x;
        y2 = bottomRight.y;
        return this;
    }

    MyRect1 buildRect(Point topleft, int w, int h) {
        x1 = topleft.x;
        y1 = topleft.y;
        x2 = (x1 + w);
        y2 = (y1 + h);
        return this;
    }

    void printRect() {
        System.out.print("MyRect : <" + x1 + ", " + y1);
        System.out.println(", " + x2 + ", " + y2 + ">");
    }

    public static void main(String[] args) {
        MyRect1 rect = new MyRect1();
        System.out.println("Buat segiempat dengan koordinat 25,25, 50,50:");
        rect.buildRect(25, 25, 50, 50);
        rect.printRect();
        System.out.println("****");
        System.out.println("Buat segiempat dengan Point(10,10) dan Point(20,20):");
        rect.buildRect(new Point(10, 10), new Point(20, 20));
        rect.printRect();
        System.out.println("****");
        System.out.println("Buat segiempat dengan 1 Point(10,10) dan koordinat width(50), height(50): ");
        rect.buildRect(new Point(10, 10), 50, 50);
        rect.printRect();
        System.out.println("***");
    }
}

public class Tugas7_Percobaan4 {

}
