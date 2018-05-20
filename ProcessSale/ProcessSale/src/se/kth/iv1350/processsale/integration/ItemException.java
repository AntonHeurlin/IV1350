package se.kth.iv1350.processsale.integration;

/**
 * An exception that is thrown when an error including an item has occured.
 */
public class ItemException extends Exception{

    /**
     * Creates and error message
     * @param errorMessage the information that is to be shown in the error message
     */
    public ItemException(String errorMessage){
        super(errorMessage);
    }
}
