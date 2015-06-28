package fr.univ.blois.siad.m2.todolist.ws.rs;

import fr.univ.blois.siad.m2.todolist.model.User;
import fr.univ.blois.siad.m2.todolist.service.UserService;

import javax.inject.Inject;
import java.util.List;

/*
L'acces aux API de cette classe doit se faire selon cette URL : http://localhost:8080/todo/api/user
De plus, elle doit produire et consommer des donnée de type XML ou JSON
 */
public class UserAPI {

    @Inject
    private UserService userService;

    /*
    Méthode repondant à la requete http://localhost:8080/todo/api/user
    Renvoyant la liste des utlisateur
     */
    public List<User> getUserList() {
        return userService.getUserList();
    }

    /*
    Méthode repondant à la requete http://localhost:8080/todo/api/user/1 ou de manière plus générique à la requete http://localhost:8080/todo/api/user/[id de l'utilisateur]
    Renvoyant l'utlisateur demandé
     */

    /*
    Méthode permettant de supprimer l'utilisateur avec cette url : http://localhost:8080/todo/api/user/1
     */

    /*
    Méthode permettant de renvoyer tous les utilisateur d'une vile (code postale) avec celle url: http://localhost:8080/todo/api/user/?zipcode=41000
    */

    /*
    Méthode permattant d'ajouter un utilisateur (dans le corp de la requete) sur cette url : http://localhost:8080/todo/api/user/
     */

    /*
    Méthode permettant de modifier un utilisateir (dans le corp de la requete) avec cette URL : http://localhost:8080/todo/api/user/
     */

}
