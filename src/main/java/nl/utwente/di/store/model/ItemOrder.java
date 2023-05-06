package nl.utwente.di.store.model;

public class ItemOrder {
    private CatalogueItem item;
    private int numItems;

    public ItemOrder() {}

    public ItemOrder(CatalogueItem item, int numItems) {
        this.item = item;
        this.numItems = numItems;
    }

    public CatalogueItem getItem() {
        return item;
    }

    public void setItem(CatalogueItem item) {
        this.item = item;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public void addNumItems(int amount) {
        this.numItems += amount;
    }

    public String toString() {
        return "ItemID = " + this.getItem().getItemID() + " NumItems =  " + this.getNumItems();
    }
}
