package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum(){
        theUserList.add(new ForumUser(1, "Piotr",'M', LocalDate.of(1990,01,05), 10));
        theUserList.add(new ForumUser(2, "Monika",'F', LocalDate.of(1992,12,01), 15));
        theUserList.add(new ForumUser(3, "Karol",'M', LocalDate.of(1980,05,12), 20));
        theUserList.add(new ForumUser(4, "Anna",'F', LocalDate.of(1991,07,21), 5));
        theUserList.add(new ForumUser(4, "Jacek",'M', LocalDate.of(2002,03,04), 2));
        theUserList.add(new ForumUser(4, "Agnieszka",'F', LocalDate.of(2005,10,11), 15));
        theUserList.add(new ForumUser(4, "Kamil",'M', LocalDate.of(2002,01,11), 19));
        theUserList.add(new ForumUser(4, "Karolina",'F', LocalDate.of(2000,05,20), 8));
    }

    public List<ForumUser> getTheUserList() {
        return new ArrayList<>(theUserList);
    }
}
