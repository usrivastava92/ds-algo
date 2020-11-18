package com.patterns.creational.factory;

public class BlogSite extends Website {

    public BlogSite() {
        super();
        pagesList.add(Pages.ABOUT_PAGE);
        pagesList.add(Pages.COMMENT_PAGE);
    }

    @Override
    public String toString() {
        return "BlogSite{" +
                "pagesList=" + pagesList +
                '}';
    }
}
