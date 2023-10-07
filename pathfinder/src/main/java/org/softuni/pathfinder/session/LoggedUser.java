package org.softuni.pathfinder.session;

import org.softuni.pathfinder.model.enums.UserLevel;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {

    private boolean isLogged;

    private String username;

    private String fullName;

    private UserLevel userLevel;

    public void reset(){
        isLogged = false;
        username = null;
        fullName = null;
        userLevel = null;
    }

    public boolean isLogged() {
        return isLogged;
    }


    public LoggedUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public LoggedUser setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserLevel getUserLevel() {
        return userLevel;
    }

    public LoggedUser setUserLevel(UserLevel userLevel) {
        this.userLevel = userLevel;
        return this;
    }


}
