import java.util.*;

/**
 * Created by salinn on 11/19/14.
 */
public class Database implements InventoryManagementSystem {
    private Hashtable<String, Item> items;
    private Hashtable<String, Room> rooms;

    public Database(){
        this.items = new Hashtable<String, Item>();
        this.rooms = new Hashtable<String, Room>();
    }

    public Database addItem(Item item){
        items.put(item.getName(), item);
        return this;
    }
    public Database addRoom(Room room){
        rooms.put(room.getName(), room);
        return this;
    }

    public Hashtable<String, Item> getItems(){
        return this.items;
    }

    public Hashtable<String, Room> getRooms(){
        return this.rooms;
    }

    public void view_items(String item_name){
        Item item = this.items.get(item_name);
        System.out.println(item.getName() + " has " + item.getLevels() + " copies left. These copies can be found in " +
                item.getRoom().getName());
    }

    public PickingResult pickProduct(String productId, int amountToPick){
        Item item = items.get(productId);
        item.removeAmount(amountToPick);

        PickingResult pickingResult = new PickingResult(item);
        return pickingResult;
    }
    public RestockingResult restockProduct(String productId, int amountToRestock){
        Item item = items.get(productId);
        item.addAmount(amountToRestock);

        RestockingResult restockingResult = new RestockingResult(item);
        return restockingResult;
    }
}
