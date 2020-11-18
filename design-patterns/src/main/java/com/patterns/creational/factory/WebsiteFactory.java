package com.patterns.creational.factory;

public class WebsiteFactory {

    public static Website getWebsite(WebsiteType websiteType) {
        switch (websiteType) {
            case BLOG:
                return new BlogSite();
            case SHOPPING:
                return new ShoppingSite();
            default:
                return null;
        }
    }

}
