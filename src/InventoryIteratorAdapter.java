import java.util.Enumeration;
import java.util.Iterator;

public class InventoryIteratorAdapter implements IInventoryIteratorProvider {
    private LegacyInventory inventory;

    public InventoryIteratorAdapter(LegacyInventory inventory) {
        this.inventory = inventory;
    }

    public Iterator<String> getInventoryIterator() {
        Enumeration<String> enumeration = inventory.getCatalogEnumeration();

        return new Iterator<String>() {
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            public String next() {
                return enumeration.nextElement();
            }
        };
    }
}