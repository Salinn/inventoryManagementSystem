/**
 * Created by salinn on 11/18/14.
 */
public interface InventoryManagementSystem {
    /**
     * Deduct 'amountToPick' of the given 'productId' from inventory.
     *
     * @param productId
     * @param amountToPick
     *
     * @return to be implemented
     */
    PickingResult pickProduct(String productId, int amountToPick);
    /**
     * Add 'amountToRestock' of the given productId to inventory.
     *
     * @param productId
     * @param amountToRestock
     *
     * @return to be implemented
     */
    RestockingResult restockProduct(String productId, int amountToRestock);

}
