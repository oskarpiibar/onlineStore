package nl.utwente.di.store.dao;

import nl.utwente.di.store.model.ItemOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum ShoppingCart {
    instance;

    private final List<ItemOrder> itemsOrdered = new ArrayList<>();

    public List<ItemOrder> getItemsOrdered() {
        return itemsOrdered;
    }

    /**
     * Looks through cart to see if it already contains an order entry
     * corresponding to item ID. If it does, increments the number ordered by more. If
     * not, looks up Item in catalogue and adds an order entry for it.
     */
    public synchronized void addItem(String itemID, int amount) {
        Optional<ItemOrder> order = this.itemsOrdered.stream().filter(item -> item.getItem().getItemID().equals(itemID)).findAny();
        if (order.isPresent()) {
            order.get().addNumItems(amount);
        } else {
            ItemOrder newOrder = new ItemOrder(Item.instance.getById(itemID), amount);
            this.itemsOrdered.add(newOrder);
        }
    }

    public void clear() {
        this.itemsOrdered.clear();
    }
}
