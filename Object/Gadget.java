package Object;

public class Gadget{
    private int id;
    private String namaGadget;
    private double price;
    private int stock;

    public Gadget (int id, String namaGadget, double price, int stock){
        this.id = id;
        this.namaGadget = namaGadget;
        this.price = price;
        this.stock = stock;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getnamaGadget(){
        return namaGadget;
    }

    public void setnamaGadget(String namaGadget){
        this.namaGadget = namaGadget;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public String info(){
        return "id = " + id + ", nama gadget ='" + namaGadget + '\'' + ", price ='" + price + '\'' + ", stock =" + stock;
    }


}
