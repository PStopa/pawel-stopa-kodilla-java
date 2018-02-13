package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int id;
    private final String name;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int quantityOfPost;

    public ForumUser(final int id, final String name, final char sex, final LocalDate dateOfBirth, final int quantityOfPost) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.quantityOfPost = quantityOfPost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getQuantityOfPost() {
        return quantityOfPost;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", quantityOfPost=" + quantityOfPost +
                '}';
    }
}
