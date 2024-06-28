package com.example.scb8.kotlinegs.callback;

public class Ansari {

    public void add(int a, int b,MobilePhone callBack){
        try {
            Thread.sleep(5000);
            callBack.onAdding(a+b);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
