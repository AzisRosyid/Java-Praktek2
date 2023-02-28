import java.awt.Point;

class MyRect { // MyRect
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    MyRect buildRect(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = y1;
        this.x2 = x2;
        this.y2 = y2;
        return this;
    }

    MyRect buildRect(Point topleft, Point bottomRight) {
        x1 = topleft.x;
        x2 = topleft.y;
        x2 = bottomRight.x;
        y2 = bottomRight.y;
        return this;
    }

    MyRect buildRect(Point topleft, int w, int h) {
        x1 = topleft.x;
        y1 = topleft.y;
        x2 = (x1 + w);
        y2 = (y1 + h);
        return this;
    }

    void printRect() {
        System.out.println("MyRect :<" + x1 + "," + y1);
        System.out.println(", " + x2 + "," + y2 + ">");
    }

    public static void main(String[] args) {
        MyRect rect = new MyRect();
        System.out.println("Calling buildRect with coordinates 25,25, 50,50:");
        rect.buildRect(25, 25, 50, 50);
        rect.printRect();
        System.out.println("****");
        System.out.println("Calling buildRect with points(10,10), (20,20):");
        System.out.println("width(50) and height(50): ");
        rect.printRect();
        System.out.println("***");
    }
}

public class Program4 {

}
