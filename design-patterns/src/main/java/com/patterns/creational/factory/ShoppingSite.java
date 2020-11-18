package com.patterns.creational.factory;

import java.util.List;

public class ShoppingSite extends Website {

    public ShoppingSite() {
        super();
        pagesList.add(Pages.ITEMS_PAGE);
        pagesList.add(Pages.CART_PAGE);
    }

    @Override
    public String toString() {
        return "ShoppingSite{" +
                "pagesList=" + pagesList +
                '}';
    }
}
