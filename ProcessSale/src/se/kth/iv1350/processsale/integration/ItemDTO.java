package se.kth.iv1350.processsale.integration;

/**
 * represent a datapackage compiled of data regarding a specific item.
 */
public class ItemDTO {
    private String itemName = "";
    private double itemPrice;
    private int itemBarcode;

    /**
     * Constructor that creates a specific instance of an object itemDTO
     * @param itemName specifies the items name
     * @param itemPrice specifies the items price
     * @param itemBarcode specifies the items barcode
     */
    public ItemDTO(String itemName, double itemPrice, int itemBarcode) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemBarcode = itemBarcode;
    }

    /**
     * Method that adds the attributes of a given itemDTO to an explanatory String.
     * @return a string containing an explanation of a specific items attributes.
     */
    public String toString(){
        String itemDescription = "";
        itemDescription = "(ItemName: " +this.itemName +", ItemPrice: " +this.itemPrice +", ItemBarcode: " +this.itemBarcode +")";
        return itemDescription;
    }

    /**
     *
     * @return the price of a specific item.
     */
    public double getItemPrice() {
        return this.itemPrice;
    }

    /**
     *
     * @return the barcode of a specific item.
     */
    public int getItemBarcode() {
        return this.itemBarcode;
    }

    /**
     *
     * @return the name of a specific item.
     */
    public String getItemName() {
        return this.itemName;
    }
}
