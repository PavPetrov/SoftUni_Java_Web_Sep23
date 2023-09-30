package org.softuni.mobilele.util;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private String firstname;
    private String lastname;

    private Boolean isLogged;

    public String getFirstname() {
        return firstname;
    }

    public CurrentUser setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public CurrentUser setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Boolean getLogged() {
        return isLogged;
    }

    public CurrentUser setLogged(Boolean logged) {
        isLogged = logged;
        return this;
    }

    public void logout(){
        setLogged(false);
        setFirstname(null);
        setLastname(null);
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", isLogged=" + isLogged +
                '}';
    }
}
