import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<ItemOrder> cart;

    public ShoppingCart()
    {
        cart = new ArrayList<>();
    }

    public void add(ItemOrder newOrder)
    {
        boolean added = false;
        for(int i = 0; i < cart.size(); i++)
        {
            if(cart.get(i).equals(newOrder))
            {
                cart.set(i, newOrder);
                added = true;
                break;
            }

        }
        if(!added)
        {
            cart.add(newOrder);
        }
    }

    public double getTotal()
    {
        double total = 0;
        for(ItemOrder i: cart)
        {
            total += i.getPrice();
        }
        return total;
    }
}
