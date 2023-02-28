class Note {
    private int value;
    public static final Note MIDDLE_C, C_SHARP, C_FLAT;

    private Note(int val) {
        value = val;
    }

    static {
        MIDDLE_C = new Note(0);
        C_SHARP = new Note(1);
        C_FLAT = new Note(2);
    }
}

class Instrument {
    public void play(Note n) {
        System.out.println("Instrument.play()");
    }
}

class Wind extends Instrument {
    public void play(Note n) {
        System.out.println("Wind.play()");
    }
}

class Stringed extends Instrument {
    public void play(Note n) {
        System.out.println("Stringed.play()");
    }
}

class Brass extends Instrument {
    public void play(Note n) {
        System.out.println("Brass.play()");
    }
}

class Program5 {
    public static void tune(Wind i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tune(Stringed i) {
        i.play(Note.C_SHARP);
    }

    public static void tune(Brass i) {
        i.play(Note.C_FLAT);
    }

    public static void main(String[] args) {
        Wind flute = new Wind(); // NO UPCASTING
        Stringed violin = new Stringed();
        Brass frenchHorn = new Brass();
        tune(flute);
        tune(violin);
        tune(frenchHorn);
    }
}

// Program yang menerapkan method overloading tune, memiliki class Note dengan variabel constant (MIDDLE_C, C_SHARP, C_FLAT), Jika class parent memiliki nama method yang sama dengan class child maka, method yang dipanggil oleh objek yang dideklarasi adalah method milik class child