package fr.univ.blois.siad.m2.todolist.exception;

import fr.univ.blois.siad.m2.todolist.model.User;

/**
 * Created by francois on 28/06/15.
 */
public class NotFoundEntityException extends Exception {

    public NotFoundEntityException(Class<User> aClass) {
        super(String.format("Entité %s non trouvé", aClass.getSimpleName()));
    }

    public NotFoundEntityException(Class<User> aClass, Throwable cause) {
        super(String.format("Entité %s non trouvé", aClass.getSimpleName()), cause);
    }

}
