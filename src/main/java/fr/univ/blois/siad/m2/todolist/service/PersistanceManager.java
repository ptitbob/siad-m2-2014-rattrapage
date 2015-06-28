package fr.univ.blois.siad.m2.todolist.service;

import fr.univ.blois.siad.m2.todolist.exception.NotFoundEntityException;
import fr.univ.blois.siad.m2.todolist.model.User;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Long.MIN_VALUE;

@Singleton
public class PersistanceManager {

    private Map<Long, User> userMap = new HashMap<>();

    public PersistanceManager() {
    }

    public User getUserById(final Long userId) throws NotFoundEntityException {
        if (!userMap.containsKey(userId)) {
            throw new NotFoundEntityException(User.class);
        }
        return userMap.get(userId);
    }

    public List<User> getUserList() {
        return new ArrayList<>(userMap.values());
    }

    public User deleteUserById(final Long userId) throws NotFoundEntityException {
        if (userId == null) {
            throw new NotFoundEntityException(User.class);
        }
        User user = getUserById(userId);
        userMap.remove(user.getId());
        return user;
    }

    public User updateUser(final User user) throws NotFoundEntityException {
        if (user != null && user.getId() != null) {
            getUserById(user.getId());
            userMap.put(user.getId(), user);
            return user;
        }
        throw new IllegalStateException("L'utilisateur doit posseder un id valide");
    }

    public User persistUser(User user) {
        if (user != null) {
            if (user.getId() != null) {
                throw new IllegalStateException("L'utilisateur ne doit pas posseder d'id lors de la création");
            }
            user.setId(getNewId());
            userMap.put(user.getId(), user);
            return user;
        }
        throw new IllegalStateException("L'utilisateur doit être assigné");
    }

    private Long getNewId() {
        Long id = MIN_VALUE;
        for (User user : userMap.values()) {
            if (id < user.getId()) {
                id = user.getId();
            }
        }
        return MIN_VALUE == id ? 1 : id + 1;
    }

    public void clearUser() {
        userMap.clear();
    }
}
