public class coba {
    public static void main(String[] args) {
        System.out.println(Math.round((int) (Math.random() * 4)));
        System.out.println(((int) (Math.random() * 400)) + 50);
        System.out.println(((int) (Math.random() * 500)) + 50);

    }
}

class OrderMenu {
    private int id, qty, carbo, protein;
    private String name, image;
    private double price;
    
    public OrderMenu(int id, String name, int qty, int carbo, int protein, double price, String image) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.carbo = carbo;
        this.protein = protein;
        this.price = price;
        this.image = image;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getCarbo() {
        return carbo;
    }

    public void setCarbo(int carbo) {
        this.carbo = carbo;
    }
    
    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getTotal() {
        return price * qty;
    }
}