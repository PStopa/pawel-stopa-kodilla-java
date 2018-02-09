package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {

    public int quantityOfUser, quantityOfPost, quantityOfComments;
    public double avgPostPerUser, avgCommentsPerUser, avgCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics){
        quantityOfUser = statistics.usersNames().size();
        quantityOfPost = statistics.postsCount();
        quantityOfComments = statistics.commentsCount();

        if(quantityOfUser == 0){
            avgPostPerUser = 0;
            avgCommentsPerUser = 0;
        } else {
            avgPostPerUser = (double)quantityOfPost / quantityOfUser;
            avgCommentsPerUser = (double)quantityOfComments / quantityOfUser;
        }
        if(quantityOfPost == 0){
            avgCommentsPerPost = 0;
        } else {
            avgCommentsPerPost = (double)quantityOfComments / quantityOfPost;
        }

    }

    public void ShowStatistics(){
        System.out.println("Quantity of User: " + quantityOfUser);
        System.out.println("Quantity of Post: " + quantityOfPost);
        System.out.println("Quantity of Comments: " + quantityOfComments);
        System.out.println("Average Post per User: " + avgPostPerUser);
        System.out.println("Average Comments per User: " + avgCommentsPerUser);
        System.out.println("Average Comments per Post: " + avgCommentsPerPost);
    }
}
