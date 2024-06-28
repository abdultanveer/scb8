package com.example.scb8.kotlinegs.callback;
public class Secratary implements MobilePhone{
    @Override
    public void onAdding(int sum) {
        System.out.println("ansari gave the sum as--"+sum);
    }
}
