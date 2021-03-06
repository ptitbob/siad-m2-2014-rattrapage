package fr.univ.blois.siad.m2.todolist.ws.rs;

import fr.univ.blois.siad.m2.todolist.exception.NotFoundEntityException;
import fr.univ.blois.siad.m2.todolist.model.User;
import fr.univ.blois.siad.m2.todolist.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

/*
Point 1 - L'acces aux API de cette classe doit se faire selon cette URL : http://localhost:8080/todo/api/user
De plus, elle doit produire et consommer des donnée de type XML ou JSON
 */
@Path("user")
@Produces({"application/json", "application/xml"})
public class UserAPI {

    @Inject
    private UserService userService;

    /*
    point 2 - Méthode repondant à la requete http://localhost:8080/todo/api/user
    Renvoyant la liste des utlisateur
     */
    @GET
    public List<User> getUserList() {
        return userService.getUserList();
    }

    /*
    Point 3 - Méthode repondant à la requete http://localhost:8080/todo/api/user/1 ou de manière plus générique à la requete http://localhost:8080/todo/api/user/[id de l'utilisateur]
    Renvoyant l'utlisateur demandé
     */
    @GET
    @Path("/{id:[0-9][0-9]*}")
    public User getUserById(@PathParam("id") Long id) throws NotFoundEntityException {
        return userService.getUser(id);
    }

    /*
    Point 4 - Méthode permettant de supprimer l'utilisateur avec cette url : http://localhost:8080/todo/api/user/1
     */
    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") Long id) throws NotFoundEntityException {
        userService.deleteUser(id);
        return Response.ok().build();
    }

    /*
    Point 5 - Méthode permettant de renvoyer tous les utilisateur d'une vile (code postale) avec celle url: http://localhost:8080/todo/api/user/?zipcode=41000
    */
    @GET
    @Path("/zip")
    public List<User> getUserPerZipCode(@QueryParam("zipcode") String zipCode) {
        return userService.getUserByZipCode(zipCode);
    }

    /*
    Point 6 - Méthode permattant d'ajouter un utilisateur (dans le corp de la requete) sur cette url : http://localhost:8080/todo/api/user/
     */
    @POST
    public Response createUser(User user) {
        User userCreated = userService.createUser(user);
        return Response.created(UriBuilder.fromResource(UserAPI.class).path(String.valueOf(userCreated.getId())).build()).build();
    }

    /*
    Point 7 - Méthode permettant de modifier un utilisateir (dans le corp de la requete) avec cette URL : http://localhost:8080/todo/api/user/
     */
    @PUT
    public Response updateUser(User user) throws NotFoundEntityException {
        userService.updateUser(user);
        return Response.ok().build();
    }

}
