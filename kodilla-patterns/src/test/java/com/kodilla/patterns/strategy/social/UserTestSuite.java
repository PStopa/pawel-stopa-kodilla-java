package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User millenialsUser = new Millenials("Millenials");
        User yGenerationUser = new YGeneration("YGenerationUser");
        User zGenerationUser = new ZGeneration("ZGenerationUser");

        //When
        String millenialsShare = millenialsUser.sharePost();
        System.out.println("Millenials shared: " + millenialsShare);
        String yGenerUserShare = yGenerationUser.sharePost();
        System.out.println("YGeneration User shared: " + yGenerUserShare);
        String zGenerUserShare = zGenerationUser.sharePost();
        System.out.println("ZGeneration User shared: " + zGenerUserShare);

        //Then
        Assert.assertEquals("Facebook", millenialsShare);
        Assert.assertEquals("Twitter", yGenerUserShare);
        Assert.assertEquals("Snapchat", zGenerUserShare);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User yGenerationUser = new YGeneration("YGeneration User");

        //When
        String yGenerUserShare = yGenerationUser.sharePost();
        System.out.println("YGeneration User shared: " + yGenerUserShare);
        yGenerationUser.setSocialPublisher(new FacebookPublisher());
        yGenerUserShare = yGenerationUser.sharePost();
        System.out.println("YGeneration User shared: " + yGenerUserShare);

        //Then
        Assert.assertEquals("Facebook", yGenerUserShare);
    }
}
