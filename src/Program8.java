class Useful {
    public void f() {
    }

    public void g() {
    }
}

class Moreuseful extends Useful {
    public void f() {
    }

    public void g() {
    }

    public void u() {
    }

    public void v() {
    }

    public void w() {
    }
}

public class Program8 { // RTI
    public static void main(String[] args) {
        Useful[] x = {
                new Useful(),
                new Moreuseful()
        };
        x[0].g();
        x[1].f();
        ((Moreuseful) x[1]).u();
     //   ((Moreuseful) x[0]).v();
        ((Useful) x[1]).f();
    }
}

// Class Useful memiliki method yaitu f() dan g() dan Class Moreuseful adalah class child dari Useful, namun memiliki method tambahan yaitu u(), v(), dan w(). Kesimpulannya adalah Class yang merupakan child dari suatu class dapat dicasting menjadi class parentnya, namun class yang merupakan parent dari suatu class tidak dapat dicasting menjadi class childnya