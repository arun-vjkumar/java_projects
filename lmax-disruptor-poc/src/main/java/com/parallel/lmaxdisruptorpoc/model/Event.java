package com.parallel.lmaxdisruptorpoc.model;

public class Event<T> {

    private T payload;

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}