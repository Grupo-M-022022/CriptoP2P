package ar.edu.unq.criptop2p.exception;

import javax.persistence.EntityNotFoundException;

public class UserNotFoundException  extends EntityNotFoundException {
    public UserNotFoundException(String message) {
        super(message);
    }
}