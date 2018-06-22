package com.gymn.annotation;

public class Person {
    @Properties(name="hunan",age=25)
    private String person;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
