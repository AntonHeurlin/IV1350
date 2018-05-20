package se.kth.iv1350.processsale.integration;


public class ItemRegister {
    private ItemDTO[] itemRegister;


    /**
     * Constructor that creates a ItemRegister containing several hardcoded objects of the type ItemDTO
     */
    public ItemRegister(){
        this.itemRegister = new ItemDTO[5];
        this.itemRegister[0] = new ItemDTO("Banan", 12, 1111);
        this.itemRegister[1] = new ItemDTO("Jordgubbe", 5, 1212);
        this.itemRegister[2] = new ItemDTO("Vattenmelon", 45, 1313);
        this.itemRegister[3] = new ItemDTO("Passionsfrukt", 20, 1414);

    }

    /**
     * method that searches through the items in an array in order to find a item with matching barcode
     * @param barcode is the barcode which a Cashier enters into a system in order to add it to a transaction.
     * @return a specific itemDTO object if the barcode finds a match, else returns null.
     * @throws OperationFailureException if the an item identifier in the database creates a data base failure.
     * @throws ItemException if an item identifier does not have a match in the item register.
     */
    public ItemDTO searchItem(int barcode) throws OperationFailureException, ItemException {
        if(barcode == 1515){
            throw new OperationFailureException("Search in item register with item identifier [" +barcode +"] generated a database failure:" +"\n");
        }
        for(int i = 0; i < itemRegister.length - 1; i++)
        {
            if(barcode == itemRegister[i].getItemBarcode())
            {
                return itemRegister[i];

            }
        }
        throw new ItemException("Item with barcode: [" +barcode +"] was not found" +"\n");
    }

    /**
     *
     * @return the current item register.
     */
    public ItemDTO[] getItemRegister() {
        return itemRegister;
    }
}
