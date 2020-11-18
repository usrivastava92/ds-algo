package com.patterns.behavioural.chainofresponsibility;

abstract public class ChainHandler {

    protected ChainHandler successor;

    public ChainHandler(ChainHandler successor) {
        this.successor = successor;
    }

    public abstract void handle(int rs);

}
