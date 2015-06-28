package fr.univ.blois.siad.m2.todolist.ws.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class Ping {

    /**
     * Permet de tester la validité de l'accès aux API REST
     * @return reponse vide (code 204)
     */
    @GET
    public Response pong() {
        return Response.noContent().build();
    }

}
