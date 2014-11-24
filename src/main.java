import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by salinn on 11/19/14.
 */
public class main {
    public static Database db = new Database();
    public static Lock lock = new ReentrantLock();

    public static void main(String args[]) {
        db = intializer(db);
        new Thread(new runner()).start();
    }

    static class runner implements Runnable {
        public void run(){
            int choice = 0;;

            while (choice != 4) {
                Scanner in = new Scanner(System.in);
                System.out.println("Please pick an option");
                System.out.println("1 = Picking out an item");
                System.out.println("2 = Restocking out an item");
                System.out.println("3 = View an item");
                System.out.println("4 = Exit system");
                choice = Integer.parseInt(in.nextLine());
                db = executor(choice);
            }
        }
    }

    public static Database executor(int choice){
        String productId;
        int amountToPick;
        int amountToRestock;

        lock.lock();
        try {
            switch (choice) {
            case 1:
                productId = check_if_product_exists(db);
                amountToPick = check_if_enough_product(productId, db);
                PickingResult pickingResult = db.pickProduct(productId, amountToPick);

                System.out.println("The number of " + pickingResult.getItem().getName() + "'s left is " +
                        pickingResult.getItem().getLevels());
                System.out.println(pickingResult.getItem().getName() + " can be found in " +
                        pickingResult.getItem().getRoom().getName());

                System.out.println();
                break;
            case 2:
                productId = check_if_product_exists(db);
                amountToRestock = how_much_to_stock();

                RestockingResult restockingResult = db.restockProduct(productId,amountToRestock);

                System.out.println("The number of " + restockingResult.getItem().getName() + "'s left is "
                        + restockingResult.getItem().getLevels());
                System.out.println(restockingResult.getItem().getName() + " can be found in " +
                        restockingResult.getItem().getRoom().getName());

                System.out.println();
                break;
            case 3:
                productId = check_if_product_exists(db);
                db.view_items(productId);
                System.out.println();
                break;
            case 4:
                System.out.println("Thanks for using our system");
                System.out.println();
                break;
            }
        } finally {
            lock.unlock();
        }

        return db;
    }

    public static String check_if_product_exists(Database db){
        Scanner in = new Scanner(System.in);
        boolean flag;
        flag = true;
        String productId = "";

        while (flag) {
            System.out.println("Enter which item you want");
            productId = in.nextLine();
            if(db.getItems().containsKey(productId)){
                flag = false;
            } else {
                System.out.println("That item is not in the database");
            }
        }
        return productId;
    }

    public static int check_if_enough_product(String productId, Database db){
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        Item item = db.getItems().get(productId);

        while (flag) {
            System.out.println("Enter how many of the items you want");
            String amountToPickString = in.nextLine();
            if(isInteger(amountToPickString)) {
                int amountToPick = Integer.parseInt(amountToPickString);
                if (amountToPick <= item.getLevels()) {
                    return amountToPick;
                } else {
                    System.out.println("Not enough " + item.getName() + "'s, thus you can not order this quantity");
                    System.out.println("Please re-enter the amount that you would like");
                }
            }  else {
                System.out.println("That is not a valid number");
            }
        }
        return -1;
    }

    public static int how_much_to_stock(){
        Scanner in = new Scanner(System.in);
        boolean flag;
        flag = true;

        while (flag) {
            System.out.println("Enter how many of the items you want");
            String amountToRestock = in.nextLine();
            if(isInteger(amountToRestock)) {
                return Integer.parseInt(amountToRestock);
            } else {
                System.out.println("That is not a valid number");
            }
        }
        return -1;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        if ( Integer.parseInt(s) < 0 ){
            return false;
        }
        return true;
    }

    public static Database intializer(Database db){
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        Room room3 = new Room("Room 3");

        Item item1 = new Item("Book1", 3, room1);
        Item item2 = new Item("Book2", 5, room1);
        Item item3 = new Item("Book3", 0, room2);
        Item item4 = new Item("Book4", 1, room1);
        Item item5 = new Item("Book5", 2, room2);
        Item item6 = new Item("Book6", 3, room1);
        Item item7 = new Item("Book7", 7, room3);
        Item item8 = new Item("Book8", 2, room1);


        db.addRoom(room1);
        db.addRoom(room2);
        db.addRoom(room3);

        db.addItem(item1);
        db.addItem(item2);
        db.addItem(item3);
        db.addItem(item4);
        db.addItem(item5);
        db.addItem(item6);
        db.addItem(item7);
        db.addItem(item8);

        return db;
    }
}
