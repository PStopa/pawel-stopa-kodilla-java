package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        Forum forum = new Forum();
        Map<Integer, ForumUser> theResultMapOfForumUser = forum.getTheUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.getDateOfBirth().isBefore(LocalDate.of(1998,02,01)))
                .filter(forumUser -> forumUser.getQuantityOfPost() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));

        System.out.println("# elements: " + theResultMapOfForumUser.size());
        theResultMapOfForumUser.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}