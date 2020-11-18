package com.patterns.creational.factory;

public class Executor {

    public static void main(String[] args) {

        System.out.println(WebsiteFactory.getWebsite(WebsiteType.BLOG));

        System.out.println(WebsiteFactory.getWebsite(WebsiteType.SHOPPING));

    }

}
