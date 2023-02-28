abstract class Shapes {
    void draw() {
    }

    void erase() {
    }
}

class Circle extends Shapes {
    void draw() {
        System.out.println("Circle.draw()");
    }

    void erase() {
        System.out.println("Circle.erase()");
    }
}

class Square extends Shapes {
    void draw() {
        System.out.println("Shape.draw()");
    }

    void erase() {
        System.out.println("Square.erase()");
    }
}

class Triangle extends Shapes {
    void draw() {
        System.out.println("Triangle.draw()");
    }

    void erase() {
        System.out.println("Triangle.erase");
    }
}

class Program6 {
    public static Shapes randShape() {
        switch ((int) (Math.random() * 3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }

    public static void main(String[] args) {
        Shapes[] s = new Shapes[9];
        // Fill up the array with shapes:
        for (int i = 0; i < s.length; i++)
            s[i] = randShape();
        // Make polymorphic method calls:
        for (int i = 0; i < s.length; i++)
            s[i].draw();
    }
}

// Kesimpulannya jika sebuah sebuah class child (Circle, Square, Triangle) memiliki method dengan identifier yang sama dengan class parent (Shapes), maka method yang dipanggil adalah method dari class childnya
