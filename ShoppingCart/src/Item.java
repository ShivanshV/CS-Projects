public class Item {
    private String name;
    private double price;
    private int bulkQty;
    private double bulkPrice;

    public Item(String n, double p, int bq, double bp)
    {
        if(p < 0 || bq < 0 || bp < 0)
            throw new IllegalArgumentException("error");
        name = n;
        price = p;
        bulkQty = bq;
        bulkPrice = bp;
    }

    public Item(String n, double p)
    {
        this(n,p,0,0);
    }

    public double priceFor(int quantity)
    {
        if(bulkQty <= quantity)
        {
            return quantity*bulkPrice;
        }
        return quantity*price;
    }

    @Override
    public boolean equals(Object obj)
    {
        return ((Item)obj).name.equals(this.name);
    }

    @Override
    public String toString()
    {
        String str = name + ", $" + price;
        if(bulkPrice != 0 && bulkQty != 0)
            str += " (" + bulkQty + " for $" + bulkPrice + " each)";
        return str;
    }

}
