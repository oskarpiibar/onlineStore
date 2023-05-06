package nl.utwente.di.store.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nl.utwente.di.store.dao.ShoppingCart;
import nl.utwente.di.store.dto.AddCartDTO;
import nl.utwente.di.store.model.ItemOrder;

import java.math.BigDecimal;
import java.util.List;

@Path("/cart")
public class ShoppingCartResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCart(AddCartDTO item) {
        ShoppingCart.instance.addItem(item.getItemID(), item.getNumItems());
        System.out.println(item);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ItemOrder> getShoppingCart() {
        return ShoppingCart.instance.getItemsOrdered();
    }

    @DELETE
    public void deleteShoppingCart() {
        ShoppingCart.instance.clear();
    }

    @Path("costs")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String totalCosts() {
        return ShoppingCart.instance.getItemsOrdered().stream().map(item -> item.getItem().getCost().multiply(BigDecimal.valueOf(item.getNumItems()))).reduce(BigDecimal.ZERO, BigDecimal::add).toString();
    }
}
