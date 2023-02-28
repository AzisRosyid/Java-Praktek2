class Meal {
    Meal() {
        System.out.println("Meal()");
    }
}

class Bread {
    Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {
    Cheese() {
        System.out.println("Cheese()");
    }
}

class Lettuce {
    Lettuce() {
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal {
    Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {
    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}

public class Program7 extends PortableLunch { // Sandwich
    Bread b = new Bread();
    Cheese c = new Cheese();
    Lettuce l = new Lettuce();

    Program7() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        new Program7();
    }
}

// Kesimpulannya constructor Class parrent tereksekusi terlebih dahulu dibanding class childnya
