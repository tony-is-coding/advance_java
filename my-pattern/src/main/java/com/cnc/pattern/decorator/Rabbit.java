package com.cnc.pattern.decorator;

public class Rabbit implements Animal {
    @Override
    public void move() {
        System.out.println("rabbit run");
    }

    @Override
    public void eat(String food) {
        System.out.println("rabbit is eating: " + food);
    }


}
