package se.kth.iv1350.processsale.integration;

public class ItemRegister {
    private ItemDTO[] itemRegister;


    /**
     * Constructor that creates a ItemRegister containing several hardcoded objects of the type ItemDTO
     */
    public ItemRegister(){
        this.itemRegister = new ItemDTO[4];
        this.itemRegister[0] = new ItemDTO("Banan", 12, 1111);
        this.itemRegister[1] = new ItemDTO("Jordgubbe", 5, 1212);
        this.itemRegister[2] = new ItemDTO("Vattenmelon", 45, 1313);
        this.itemRegister[3] = new ItemDTO("Passionsfrukt", 20, 1414);

    }

    /**
     * method that searches through the items in an array in order to find a item with matching barcode
     * @param barcode is the barcode which a Cashier enters into a system in order to add it to a transaction.
     * @return a specific itemDTO object if the barcode finds a match, else returns null.
     */
    public ItemDTO searchItem(int barcode){
        for(int i = 0; i < itemRegister.length; i++)
        {
            if(barcode == itemRegister[i].getItemBarcode())
            {
                return itemRegister[i];
            }
        }
        return null;
    }

    /**
     *
     * @return the current item register.
     */
    public ItemDTO[] getItemRegister() {
        return itemRegister;
    }
}
