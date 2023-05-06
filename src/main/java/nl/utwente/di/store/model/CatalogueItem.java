package nl.utwente.di.store.model;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;

/**
 * Describes a catalog item for on-line store. The itemID
 * uniquely identifies the item, the short description
 * gives brief info like the book title and author,
 * the long description describes the item in a couple
 * of sentences, and the cost gives the current per-item price.
 * Both the short and long descriptions can contain HTML
 * markup.
 * <p>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition
 * from Prentice Hall and Sun Microsystems Press,
 * http://www.coreservlets.com/.
 * &copy; 2003 Marty Hall; may be freely used or adapted.
 */

@XmlRootElement
public class CatalogueItem {
    private String itemID;
    private String shortDescription;
    private String longDescription;
    private BigDecimal cost;
    private String category;

    public CatalogueItem() {}

    public CatalogueItem(String itemID, String shortDescription, String longDescription, String category, BigDecimal cost) {
        setItemID(itemID);
        setShortDescription(shortDescription);
        setLongDescription(longDescription);
        setCategory(category);
        setCost(cost);
    }

    public CatalogueItem(String itemID, String shortDescription, String longDescription, String category, double cost) {
        this(itemID, shortDescription, longDescription, category, BigDecimal.valueOf(cost));
    }

    public String getItemID() {
        return itemID;
    }

    protected void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    protected void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    protected void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getCost() {
        return cost;
    }

    protected void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
