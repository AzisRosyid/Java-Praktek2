abstract class Pemrograman {
    public abstract void belajar();

    public void mrogram() {
        System.out.println("Program java");
    }
}

class Budi extends Pemrograman {
    public void belajar() {
        System.out.println("Belajar Java");
    }

    public void mrogram() {
        System.out.println("Memprogram Java");
    }
}

class Siti extends Pemrograman {
    public void belajar() {
        System.out.println("Belajar Pemrograman Java");
    }
}

class CobaAbstract {
    char c6 = '\uface';

  //  char c5 = '\iface';
    
    static char c1 = 064770;
    
    char c3 = 0xbeef;
    
   // char c4 = \u0022;
    
    // char c2 = 'face';


    public static void main(String args[]) {
        Budi pandu = new Budi();
        pandu.belajar();
        pandu.mrogram();
        Pemrograman rana = new Siti();
        rana.belajar();
        rana.mrogram();
        System.out.println("\n\n");
        pandu.belajar();
        System.out.println(c1);

    }
}