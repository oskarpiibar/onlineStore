package nl.utwente.di.store.dao;

import nl.utwente.di.store.model.CatalogueItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Item {
    instance;

    private final Map<String, CatalogueItem> items = new HashMap<>();

    Item() {
        items.put("hall001", new CatalogueItem("hall001", "<I>Core Servlets and JavaServer Pages 2nd Edition</I> (Volume 1) by Marty Hall and Larry Brown", "The definitive reference on servlets and JSP from Prentice Hall and \nSun Microsystems Press.<P>Nominated for the Nobel Prize in Literature.", "tech", 39.95));
        items.put("hall002", new CatalogueItem("hall002", "<I>Core Web Programming, 2nd Edition</I> by Marty Hall and Larry Brown", "One stop shopping for the Web programmer. Topics include \n<UL><LI>Thorough coverage of Java 2; including Threads, Networking, Swing, \nJava 2D, RMI, JDBC, and Collections\n<LI>A fast introduction to HTML 4.01, including frames, style sheets, and layers.\n<LI>A fast introduction to HTTP 1.1, servlets, and JavaServer Pages.\n<LI>A quick overview of JavaScript 1.2\n</UL>", "tech", 49.99));
        items.put("lewis001", new CatalogueItem("lewis001", "<I>The Chronicles of Narnia</I> by C.S. Lewis", "The classic children's adventure pitting Aslan the Great Lion and his followers\nagainst the White Witch and the forces of evil. Dragons, magicians, quests, \nand talking animals wound around a deep spiritual allegory. Series includes\n<I>The Magician's Nephew</I>,\n<I>The Lion, the Witch and the Wardrobe</I>,\n<I>The Horse and His Boy</I>,\n<I>Prince Caspian</I>,\n<I>The Voyage of the Dawn Treader</I>,\n<I>The Silver Chair</I>, and \n<I>The Last Battle</I>.", "kids", 19.95));
        items.put("alexander001", new CatalogueItem("alexander001", "<I>The Prydain Series</I> by Lloyd Alexander", "Humble pig-keeper Taran joins mighty Lord Gwydion in his battle against\nArawn the Lord of Annuvin. Joined by his loyal friends the beautiful princess\nEilonwy, wannabe bard Fflewddur Fflam,and furry half-man Gurgi, Taran discovers courage, nobility, and other values along\nthe way. Series includes\n<I>The Book of Three</I>,\n<I>The Black Cauldron</I>,\n<I>The Castle of Llyr</I>,\n<I>Taran Wanderer</I>, and\n<I>The High King</I>.", "kids", 19.95));
        items.put("rowling001", new CatalogueItem("rowling001", "<I>The Harry Potter Series</I> by J.K. Rowling", "The first five of the popular stories about wizard-in-training Harry Potter\ntopped both the adult and children's best-seller lists. Series includes\n<I>Harry Potter and the Sorcerer's Stone</I>,\n<I>Harry Potter and the Chamber of Secrets</I>,\n<I>Harry Potter and the Prisoner of Azkaban</I>,\n<I>Harry Potter and the Goblet of Fire</I>, and\n<I>Harry Potter and the Order of the Phoenix</I>.\n", "kids", 59.95));
    }

    public List<CatalogueItem> getAll() {
        return new ArrayList<>(items.values());
    }

    public List<CatalogueItem> getByCategory(String category) {
        return items.values().stream().filter(item -> item.getCategory().equals(category)).collect(Collectors.toList());
    }

    public CatalogueItem getById(String id) {
        return items.get(id);
    }
}
