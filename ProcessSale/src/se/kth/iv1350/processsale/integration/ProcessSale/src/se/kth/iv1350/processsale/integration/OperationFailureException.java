package se.kth.iv1350.processsale.integration;

/**
 * Exception that is used when an operation fails in the integration layer.
 */
public class OperationFailureException extends RuntimeException{

    /**
     * Creates an error message
     * @param errorMessage the error message that is to be shown.
     */
    public OperationFailureException(String errorMessage){
            super(errorMessage);
        }
}

