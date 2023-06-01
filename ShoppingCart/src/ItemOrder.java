public class ItemOrder {
    private Item item;
    private int quantity;

    public ItemOrder(Item i, int q)
    {
        item = i;
        quantity = q;
    }

    public double getPrice()
    {
        return item.priceFor(quantity);
    }

    public Item getItem()
    {
        return item;
    }

    @Override
    public boolean equals(Object obj)
    {
        return this.getItem() == ((ItemOrder)obj).getItem();
    }


}
