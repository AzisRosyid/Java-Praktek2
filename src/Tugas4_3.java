public class Tugas4_3 {
    public static void main(String[] args) {
        System.out.println(new Silinder(10, 30).getVolume());
    }
}

class Lingkaran {
    private double r;

    public Lingkaran() {

    }

    public Lingkaran(double r) {
        this.r = r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public double getDiameter() {
        return r*2;
    }

    public double getKeliling() {
        return Math.PI * getDiameter();
    }

    public double getLuas() {
        return Math.PI * r * r;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Kerucut extends Lingkaran {
    private double tinggi;

    public Kerucut() {

    }

    public Kerucut(double r, double tinggi) {
        super(r);
        this.tinggi = tinggi;
    }
    
    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public double getVolume() {
        return Math.PI / 3 * super.getR() * super.getR() * tinggi;
    }

    @Override
    public double getLuas() {
        return Math.PI * super.getR() * (Math.sqrt(super.getR() * super.getR() + this.tinggi * this.tinggi) + super.getR());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Silinder extends Lingkaran {
    private double tinggi;

    public Silinder() {

    }

    public Silinder(double r, double tinggi) {
        super(r);
        this.tinggi = tinggi;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public double getVolume() {
        return super.getLuas() * tinggi;
    }

    @Override
    public double getLuas() {
        return super.getDiameter() * (super.getR() + this.tinggi);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}