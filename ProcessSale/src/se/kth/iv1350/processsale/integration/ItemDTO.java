package se.kth.iv1350.processsale.integration;

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
    public String itemDescription()
    {
        String itemDescription = "";
        itemDescription = "(ItemName: " +this.itemName +", ItemPrice: " +this.itemPrice +", ItemBarcode: " +this.itemBarcode +")";
        return itemDescription;
    }

    public double getItemPrice() {
        return this.itemPrice;
    }

    public int getItemBarcode() {
        return this.itemBarcode;
    }

    public String getItemName() {
        return this.itemName;
    }
}
