<h1>Software Engineer Off-Site Problem</h1>
<h3>Introduction</h3>
<p>Assume you are working on a new warehouse inventory management system named IMS. IMS will be responsible for the inventory tracking
within physical, single site warehouses. IMS will track the named physical location of a product within the warehouse and the inventory level of
each product. IMS will be deployed to busy warehouses supporting many pickers and restockers working with individual terminals and clients.
 Updates to inventory levels will be handled in real time to prevent pickers trying to pick a product that is out of stock.</p> 
 
<h3>Assumptions<h3>
<p>Each product will be stored at one and only one named location within the warehouse.
Inventory adjustments may be additive (restocks) or subtractive (picks)
No additional product information needs to be tracked beyond location and level.</p>
<h3>Problem</h3>
<p>In Java, implement the picking and restocking routines for the IMS system. The InventoryManagementSystem interface will be the first
component to be implemented, all relevant domain objects will have to be implemented. The InventoryManagementSystem interface has
already been distributed to other teams which depend on it.<p>

<h3>Deliverables</h3>
<p>Valid Java source code implementing the pickProduct and restockProduct methods of the InventoryManagementSystem interface.
A compilable java application containing any additional artifacts and/or domain classes used to solve the problem.</p>

```java
/**
 * Implementations of this interface must be thread-safe. Access to shared data must be
synchronized as methods of this
 * interface may be executed from multiple threads.
 * */
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
```
