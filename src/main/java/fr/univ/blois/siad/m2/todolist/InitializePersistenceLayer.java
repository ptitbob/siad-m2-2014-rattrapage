package fr.univ.blois.siad.m2.todolist;

import fr.univ.blois.siad.m2.todolist.model.Town;
import fr.univ.blois.siad.m2.todolist.model.User;
import fr.univ.blois.siad.m2.todolist.service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class InitializePersistenceLayer {

    @Inject
    private UserService userService;

    @PostConstruct
    public void initialize() {
        userService.createUser(new User("toto", new Town("Orléans", "45000")));
        userService.createUser(new User("tata", new Town("Blois", "41000")));
        userService.createUser(new User("titi", new Town("Tours", "37000")));
    }
}
