package fr.univ.blois.siad.m2.todolist.service;

import fr.univ.blois.siad.m2.todolist.exception.NotFoundEntityException;
import fr.univ.blois.siad.m2.todolist.model.User;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    @Inject
    private PersistanceManager persistanceManager;

    /**
     * renvoi un utilisateur selon son id
     * @param userId id de l'utilisateur
     * @return utilisateur trouvé
     * @throws NotFoundEntityException si l'utilisateur n'a pas été localisé
     */
    public User getUser(Long userId) throws NotFoundEntityException {
        return persistanceManager.getUserById(userId);
    }

    /**
     * Renvoi la liste des utilisateurs
     * @return liste des utilisateurs
     */
    public List<User> getUserList() {
        return persistanceManager.getUserList();
    }

    /**
     * Supprime un utilisateur
     * @param userId identifiant de l'utilisateur
     * @throws NotFoundEntityException si l'utilisateur n'a pas été localisé
     */
    public void deleteUser(Long userId) throws NotFoundEntityException {
        persistanceManager.deleteUserById(userId);
    }

    /**
     * Met à jour un utilisateur
     * @param user utilisateur
     * @throws NotFoundEntityException si l'utilisateur n'a pas pu etre localisé
     */
    public void updateUser(User user) throws NotFoundEntityException {
        persistanceManager.updateUser(user);
    }

    /**
     * Créer un utilisateur
     * @param user utilisateur
     * @return utilisateur avec Id valorisé
     */
    public User createUser(User user) {
        return persistanceManager.persistUser(user);
    }

    /**
     * Renvoi tous les utilisateur lié à un code postal
     * @param zipCode code postal
     * @return liste des utilisateurs
     */
    public List<User> getUserByZipCode(String zipCode) {
        return getUserList().stream().filter(user -> zipCode.equals(user.getTown().getZipCode())).collect(Collectors.toList());
    }

    /**
     * Supprime toutes les données
     */
    public void clearAll() {
        persistanceManager.clearUser();
    }
}
