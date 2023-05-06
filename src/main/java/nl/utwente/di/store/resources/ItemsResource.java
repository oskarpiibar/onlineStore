package nl.utwente.di.store.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nl.utwente.di.store.dao.Item;
import nl.utwente.di.store.model.CatalogueItem;

import java.util.List;

@Path("/items")
public class ItemsResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CatalogueItem> getAllCatalogueItems(@QueryParam("category") String category) {
        // TODO: Make less hacky
        if (category == null) return Item.instance.getAll();
        else return Item.instance.getByCategory(category);
    }

    @Path("count")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        return String.valueOf(Item.instance.getAll().size());
    }

    @Path("{itemID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CatalogueItem getTodo(@PathParam("itemID") String id) {
        return Item.instance.getById(id);
    }
}
