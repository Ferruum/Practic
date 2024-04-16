package com.example.demo.dao;

import com.example.demo.models.Inventory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class InventoryDAO {
    private static int INVENTORY_COUNT;
    private final List<Inventory> inventar;

    {
        inventar = new ArrayList<>();
        inventar.add(new Inventory(++INVENTORY_COUNT, "Андрюша","Кухонные","10см","100рублей"));
        inventar.add(new Inventory(++INVENTORY_COUNT, "Сталюша","Производственные","30см","999рублей"));
        inventar.add(new Inventory(++INVENTORY_COUNT, "Кусторезка","Садовые","15см","500рублей"));
    }

    public List<Inventory> inventoryPage(){
        return inventar;
    }

    public Inventory showInventory(int id){
        return inventar.stream().filter(inventory -> inventory.getId() == id).findAny().orElse(null);
    }

    public void saveInventory(Inventory inventory){
        inventory.setId(inventar.size()+1);
        inventar.add(inventory);
    }

    public void updateInventory(int id, Inventory updatedInventory){
        Inventory inventoryToBeUpdated = showInventory(id);
        if (inventoryToBeUpdated != null){
            inventoryToBeUpdated.setName(updatedInventory.getName());
            inventoryToBeUpdated.setBladelength(updatedInventory.getBladelength());
            inventoryToBeUpdated.setType(updatedInventory.getType());
            inventoryToBeUpdated.setPrice(updatedInventory.getPrice());
        }
    }

    public void delete(int id){
        inventar.removeIf(p -> p.getId() == id);
    }
}
