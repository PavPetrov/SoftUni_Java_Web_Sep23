package org.softuni.pathfinder.session;

import org.softuni.pathfinder.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class LoggedUser {

    private boolean isLogged;



    User loggedUser;

    public User getLoggedUser() {
        return loggedUser;
    }

    public LoggedUser setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
        this.isLogged = true;
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public LoggedUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }
}
