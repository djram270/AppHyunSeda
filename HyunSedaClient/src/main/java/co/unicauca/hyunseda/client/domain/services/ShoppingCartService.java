package co.unicauca.hyunseda.client.domain.services;

import co.unicauca.hyunseda.client.access.model.Item;
import co.unicauca.hyunseda.client.domain.entities.ShoppingCart;
import co.unicauca.hyunseda.client.infra.Subject;
import java.util.List;

/**
 *
 * @author dizu8
 */
public class ShoppingCartService extends Subject{
    private static ShoppingCartService shoppingCartService;
    
    private ShoppingCartService ()
    {
        ShoppingCart.getShopppingCart();
    }
    
    public static ShoppingCartService getShoppingCartService ()
    {
        if (shoppingCartService == null)
        {
            shoppingCartService = new ShoppingCartService();
        }
        return shoppingCartService;
    }
    
    public List<Item> getShoppingCart() {
        return ShoppingCart.getShopppingCart();
    }
    
    public void setShoppingCart(Item item)
    {
        ShoppingCart.addItem(item);
        this.notifyAllObserves();
    }
    
    public void cleanShoppingCart()
    {
        ShoppingCart.cleanItems();
        ShoppingCart.getShopppingCart();
        this.notifyAllObserves();
        
    }
    
    public void deleteShoppingCartElement (Item item)
    {
        ShoppingCart.deleteShoppingCartItem(item);
        this.notifyAllObserves();
    }
}
