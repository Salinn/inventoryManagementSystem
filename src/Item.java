/**
 * Created by salinn on 11/19/14.
 */
public class Item {
    private String name;
    private int levels;
    private Room room;

    public Item(String name, int levels, Room room){
        this.name = name;
        this.levels = levels;
        this.room = room;
    }

    public String getName(){
        return this.name;
    }
    public int getLevels(){
        return this.levels;
    }
    public Room getRoom(){
        return this.room;
    }

    public void removeAmount(int amount){
        this.levels -= amount;
    }
    public void addAmount(int amount){
        this.levels += amount;
    }
}
