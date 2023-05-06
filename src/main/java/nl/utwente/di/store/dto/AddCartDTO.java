package nl.utwente.di.store.dto;

public class AddCartDTO {
    private String itemID;
    private int numItems;

    public  AddCartDTO() {}

    public AddCartDTO(String itemID, int numItems) {
        this.itemID = itemID;
        this.numItems = numItems;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public int getNumItems() {
        return numItems;
    }

    @Override
    public String toString() {
        return this.numItems + "x " + this.itemID;
    }
}
