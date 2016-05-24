package LGBS;

/**
 * Created by Maciek on 2016-02-14.
 */
public class Product{

    private int index;
    private String name;
    private double quantity;
    private double pricePerUnit;
    private double price;

    public Product(int index, String name, double quantity, double pricePerUnit)
    {
        this.index = index;
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.price = quantity * pricePerUnit;
    }

    @Override
    public String toString()
    {
        return String.format("%s\t%s\t%.02f\t%.02f\t%.02f",index,name,quantity,pricePerUnit,price);
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getQuantity()
    {
        return quantity;
    }

    public void setQuantity(double quantity)
    {
        this.quantity = quantity;
    }

    public double getPricePerUnit()
    {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit)
    {
        this.pricePerUnit = pricePerUnit;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
