package com.patterns.creational.factory;

import java.util.ArrayList;
import java.util.List;

public class Website {

    protected List<Pages> pagesList;

    public Website() {
        pagesList = new ArrayList<>();
        pagesList.add(Pages.HOME_PAGE);
    }

    @Override
    public String toString() {
        return "Website{" +
                "pagesList=" + pagesList +
                '}';
    }
}
