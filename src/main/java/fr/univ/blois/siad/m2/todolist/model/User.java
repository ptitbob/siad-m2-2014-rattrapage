package fr.univ.blois.siad.m2.todolist.model;

import java.util.Objects;

/*
Cette classe doit presenter une serialisation XML avec le login et l'id en attribut, la ville en element
 */
public class User {

    /**
     * Identifiant
     */
    private Long id;

    /**
     * Login de l'utilisateur
     */
    private String login;

    /**
     * Vile de l'utilisateur
     */
    private Town town;

    /**
     * Constructeur vide
     */
    public User() {
    }

    /**
     * Constructeur paramétré
     * @param id identifiant de l'utilisateur
     * @param login login de l'utilisateur
     */
    public User(Long id, String login) {
        this.id = id;
        this.login = login;
    }

    public User(Long id, String login, Town town) {
        this(id, login);
        this.town = town;
    }

    public User(String login, Town town) {
        this(null, login, town);
    }

    public User(String login) {
        this(null, login);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login);
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("User{");
        stringBuilder.append("id=").append(id);
        stringBuilder.append(", login='").append(login).append('\'');
        stringBuilder.append(", town=").append(town);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
