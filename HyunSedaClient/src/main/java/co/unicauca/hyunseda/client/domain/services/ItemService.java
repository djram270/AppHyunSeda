/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.client.domain.services;

import co.unicauca.hyunseda.client.access.microservice.iMicroserviceItem;
import co.unicauca.hyunseda.client.access.microservice.implementation.MicroserviceItem;
import co.unicauca.hyunseda.client.access.model.Item;
import java.util.List;

/**
 *
 * @author dizu8
 */
public class ItemService {
    private static ItemService itemService;
    private iMicroserviceItem microserviceItem;
    
    private ItemService ()
    {
        microserviceItem = new MicroserviceItem();
    }
    
    public static ItemService getItemService ()
    {
        if (itemService == null)
        {
            itemService = new ItemService();
        }
        return itemService;
    }
    
    public List<Item> getItems()
    {
        return microserviceItem.getItems();
    }
    
    public Item getItemById(Long id)
    {
        return microserviceItem.getItem(id.toString());
    }
    
    public String postItem(Item item)
    {
        return microserviceItem.postItem(item);
    }
}
