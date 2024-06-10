package co.unicauca.hyunseda.client.domain.entities;

import co.unicauca.hyunseda.client.access.model.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dizu8
 */
public class ShoppingCart {
    private static List<Item> items;

    private ShoppingCart() {
        
    }
    
    public static List<Item> getShopppingCart(){
        if (items == null) {
            items = new ArrayList<>();
        } 
        return items;
    }
    
    public static void addItem(Item item) {
        //
        int indexAt = searchShoppingCartItem(item);
                
        if (indexAt != -1)
        {
            items.get(indexAt).setAmount(items.get(indexAt).getAmount() + item.getAmount());
            return;
        }
        items.add(item);
        //System.out.println("valor actual: " + items.toString());
    }
    
    //retorna menos uno si no encontro un item con el mismo nombre en la lista
    private static int searchShoppingCartItem(Item item)
    {    
        int indexAt = 0;
        
        for (Item it : items)
        {
            if (it.getProductId().equals(item.getProductId()))
            {
                //System.out.println("Corrigiendo: " + items.toString());
                return indexAt;
            }
            indexAt++;
        }
        
        return -1;
    }
    
    public static void cleanItems(){
        items = null;
    }
    
    public static void deleteShoppingCartItem (Item item)
    {
        int indexAt = searchShoppingCartItem(item);
        
        if (indexAt == -1)
        {
            return;
        }
        items.remove(indexAt);
    }
}
