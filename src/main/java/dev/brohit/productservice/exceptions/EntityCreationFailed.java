package dev.brohit.productservice.exceptions;

public class EntityCreationFailed extends Exception{

    private String message;

    public EntityCreationFailed(String message){
        super(message);
        this.message = message;
    }

}
